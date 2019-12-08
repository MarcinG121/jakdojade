package route;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RouteGenerator {

    private List<Node> visited = new ArrayList<>();
    private List<Edge> result = new ArrayList<>();
    private Network network;
    private Node from;
    private Node to;

    public RouteGenerator(Network network, Node from, Node to) {
        this.network = network;
        this.from = from;
        this.to = to;
    }

    public void changeNetwork(Network network) {
        this.network = network;
    }

    public void changeDestinationNode(Node to){
        this.to = to;
    }

    public void changeSourceNode(Node from){
        this.from = from;
    }

    public List<Edge> generateRoute(){

        Node current = from;
        int hops = 0;
        visited.add(current);

        while (hops <= Math.sqrt(network.getNetwork().size())){
            Edge next = findDirectlyConnected(current);
            if ( next != null){
                result.add(next);
                return result;
            }
            else {
                Edge nextHop = nextHops(current);
                if ( nextHop == null ) {
                    return result;
                } else {
                    current = nextHop.getToNode();
                    hops += 1;
                    visited.add(current);
                    result.add(nextHop);
                }
            }
        }

        return result;
    }

    public Integer calculateJourneyTime() {
        Integer time = 0;
        if(!result.isEmpty()) {
            for (Edge edge : result) {
                time += edge.getTime();
            }
        } else {
            time = Integer.MAX_VALUE;
        }
        return time;
    }


    private Edge findDirectlyConnected(Node current){
        List<Edge> row = network.getRow(current.getId());
        for (Edge edge: row){
            if (edge.getToNode().equals(to)) return edge;
        }
        return null;
    }

    private Edge nextHops(Node current){
        List<Edge> row = network.getRow(current.getId());
        List<Edge> noVisited = new ArrayList<Edge>();
        for (Edge edge: row){
            if (!visited.contains(edge.getToNode())){
                noVisited.add(edge);
                Edge nextHops = findDirectlyConnected(edge.getToNode());
                if (  nextHops != null){
                    return edge;
                }
            }
        }
        if (noVisited.isEmpty()) return null;
        return noVisited.get(getRandomNumberInRange(0, noVisited.size()));
    }


    private static int getRandomNumberInRange(Integer min, Integer max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

}
