package route;


import route.errors.DestinationReachException;
import route.errors.DestinationUnreachableException;
import route.errors.NegativeTimeValueException;
import simulation.result.Result;

import java.util.*;
import java.util.stream.Collectors;

public class RouteGenerator {

    private static final int MAX_TIME = 1440;

    private List<Node> visited;
    private List<Edge> result;
    private Network network;
    private Node from;
    private Node to;
    private int startTime;
    private int time;

    public RouteGenerator(Network network, Node from, Node to, Integer startTime) {
        this.network = network;
        this.from = from;
        this.to = to;
        this.startTime = startTime;
        this.time = startTime;
        this.result = new ArrayList<>();
        this.visited = new ArrayList<>();
    }

    public void changeNetwork(Network network) {
        this.network = network;
        this.result = new ArrayList<>();
        this.visited = new ArrayList<>();
    }

    public void changeDestinationNode(Node to){
        this.to = to;
    }

    public void changeSourceNode(Node from){
        if (from == null) {
            System.out.println("here");
        }
        this.from = from;
    }

    public void changeStartTime(int actual) {
        this.startTime = actual;
    }

    public Result generateRoute()
            throws DestinationReachException, NegativeTimeValueException, DestinationUnreachableException
    {
        this.time = startTime;
        Node current = from;
        int hops = 0;
        int waitingTime = 0;
        visited.add(current);

        if (this.from.equals(this.to)){
            throw new DestinationReachException("Destination already reach");
        }
        if (this.network.getNetwork().isEmpty()) {
            throw new DestinationUnreachableException("Can not reach destination node");
        }

        while (hops <= Math.sqrt(network.getNetwork().size())) {
            List<Edge> next = findDirectlyConnected(current);
            if ( next.size() > 0 ) {
                Optional<Edge> bestNext = chooseBetterConnection(next);
                if (bestNext.isPresent()) {
                    result.add(bestNext.get());
                    waitingTime = calculateWaitingTime(time, bestNext.get().getTime().getArrivalTime());
                    time = time + bestNext.get().getDriveTime() + waitingTime;
                }
                return new Result(result, calculateJourneyTime());
            }
            else {
                Edge nextHop = nextHops(current);
                if ( nextHop == null ) {
                    return new Result(result, calculateJourneyTime());
                } else {
                    current = nextHop.getToNode();
                    hops += 1;
                    visited.add(current);
                    result.add(nextHop);
                    waitingTime = calculateWaitingTime(time, nextHop.getTime().getArrivalTime());
                    time = time + nextHop.getDriveTime() + waitingTime;
                }
            }
        }
        return new Result(result, calculateJourneyTime());
    }

    private int calculateWaitingTime(int time, int arrivalTime) throws NegativeTimeValueException{
        int result = arrivalTime - time;
        if (result < 0) {
            throw new NegativeTimeValueException("Negative time value");
        }
        return result;
    }

    private Optional<Edge> chooseBetterConnection(List<Edge> lines) {
        return lines.stream().min(Comparator.comparingInt(Edge::getDriveTime));
    }

    private Integer calculateJourneyTime() {
        return this.time - this.startTime;
    }

    private List<Edge> findDirectlyConnected(Node current){
        List<Edge> row = null;
        try {
            row = chooseClosedArrivalTime(network.getRow(current.getId()));
        } catch (NoSuchElementException e){
            return new ArrayList<>();
        }
        List<Edge> result = new ArrayList<>();
        for (Edge edge: row){
            if (edge.getToNode().equals(to)) {
                result.add(edge);
            }
        }
        return chooseClosedArrivalTime(result);
    }


    private List<Edge> chooseClosedArrivalTime(List<Edge> allArrival) {

        int min = MAX_TIME;
        List<Edge> result = new ArrayList<>();
        Edge bestEdge = null;
        if (allArrival.size() > 0) {
            int previousFromNode = allArrival.get(0).getToNode().getId();
            for (Edge edge : allArrival) {
                int nowFromNode = edge.getToNode().getId();
                if (previousFromNode == nowFromNode) {
                    if (edge.getTime().getArrivalTime() > time) {
                        int next = edge.getTime().getArrivalTime() - time;
                        if (min > next) {
                            bestEdge = edge;
                            min = next;
                        }
                    }
                }
                else {
                    min = MAX_TIME;
                    if (bestEdge == null){
                        continue;
                    }
                    result.add(new Edge(bestEdge));
                }
                previousFromNode = nowFromNode;
            }
            result.add(new Edge(bestEdge));
        }
        return result;
    }

    private Edge nextHops(Node current){
        List<Edge> row = null;
        try {
            row = chooseClosedArrivalTime(network.getRow(current.getId()));;
        } catch (NoSuchElementException e){
            return null;
        }
        List<Edge> noVisited = new ArrayList<Edge>();
        for (Edge edge: row){
            if (!visited.contains(edge.getToNode())){
                noVisited.add(edge);
                List<Edge> nextHops = findDirectlyConnected(edge.getToNode());
                if ( nextHops.size() > 0) {
//                    if(chooseBetterConnection(nextHops).isPresent()) {
//                        return chooseBetterConnection(nextHops).get();
//                    }
                    return edge;
                }
            }
        }
        if (noVisited.isEmpty()) return null;
        return noVisited.get(getRandomNumberInRange(0, noVisited.size()-1));
    }

    public static int getRandomNumberInRange(Integer min, Integer max) {
        if (min > max) {
            throw new IllegalArgumentException("max must be greater than min");
        }
        if (min.equals(max)) {
            return min;
        }
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}
