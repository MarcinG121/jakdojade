package route;


import route.errors.DestinationReachException;
import simulation.result.Result;

import java.util.*;
import java.util.stream.Collectors;

public class RouteGenerator {

    private List<Node> visited;
    private List<Edge> result;
    private Network network;
    private Node from;
    private Node to;
    private Integer startTime;

    public RouteGenerator(Network network, Node from, Node to, Integer startTime) {
        this.network = network;
        this.from = from;
        this.to = to;
        this.startTime = startTime;
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
        this.from = from;
    }

    public Result generateRoute() throws DestinationReachException {
        Integer time = startTime;
        Node current = from;
        int hops = 0;
        visited.add(current);

        if (this.from.equals(this.to)){
            throw new DestinationReachException("Destination already reach");
        }

        while (hops <= Math.sqrt(network.getNetwork().size())){
            List<Edge> next = findDirectlyConnected(current);
            if ( next.size() > 0 ) {
                Optional<Edge> bestNext = chooseBetterConnection(next);
                if (bestNext.isPresent()) {
                    result.add(bestNext.get());
                    time = time + bestNext.get().getDriveTime();
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
                    time = time + nextHop.getDriveTime();
                }
            }
        }
        return new Result(result, calculateJourneyTime());
    }

    private Optional<Edge> chooseBetterConnection(List<Edge> lines) {
        return lines.stream().min(Comparator.comparingInt(Edge::getDriveTime));
    }

    private Integer calculateJourneyTime() {
        Integer time = 0;
        if(!result.isEmpty()) {
            for (Edge edge : result) {
                time += edge.getDriveTime();
            }
        } else {
            time = Integer.MAX_VALUE;
        }
        return time;
    }

    private List<Edge> findDirectlyConnected(Node current){
        List<Edge> row = network.getRow(current.getId());
        List<Edge> result = new ArrayList<>();
        for (Edge edge: row){
            if (edge.getToNode().equals(to)) {
                result.add(edge);
            }
        }
        return chooseClosedArrivalTime(result);
    }


    private List<Edge> chooseClosedArrivalTime(List<Edge> allArrival) {

        int min = 1440;
        List<Edge> result = new ArrayList<>();
        if (allArrival.size() > 0){
            Integer previousFromNode = allArrival.get(0).getFromNode().getId();
            for (Edge edge : allArrival) {
                Integer nowFromNode = edge.getFromNode().getId();
                if (previousFromNode.equals(nowFromNode)) {
                    if (edge.getTime().getArrivalTime() > startTime) {
                        int next = edge.getTime().getArrivalTime() - startTime;
                        if (min > next) {
                            result.add(edge);
                            min = next;
                        }
                    }
                }
                else {
                    min = 0;
                }
                previousFromNode = nowFromNode;
            }
        }
        return result;
    }

    private Edge nextHops(Node current){
        List<Edge> row = network.getRow(current.getId());
        List<Edge> noVisited = new ArrayList<Edge>();
        for (Edge edge: row){
            if (!visited.contains(edge.getToNode())){
                noVisited.add(edge);
                List<Edge> nextHops = findDirectlyConnected(edge.getToNode());
                if ( nextHops.size() > 0) {
                    if(chooseBetterConnection(nextHops).isPresent()) {
                        return chooseBetterConnection(nextHops).get();
                    }
                }
            }
        }
        if (noVisited.isEmpty()) return null;
        return noVisited.get(getRandomNumberInRange(0, noVisited.size()));
    }

    public static int getRandomNumberInRange(Integer min, Integer max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}
