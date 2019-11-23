package route;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Route {

    private List<Node> visited = new ArrayList<Node>();

    public List<Edge> findRoute(Node from, Node to, Network network){
        List<Edge> result = new ArrayList<Edge>();
        Node current = from;
        Integer hops = 0;
        visited.add(current);

        while (hops <= Math.sqrt(network.getTheNetwork().size())){
            Edge next = findDirectlyConnected(current, to, network);
            if ( next != null){
                result.add(next);
                return result;
            }
            else {
                Edge nextHop = nextHops(current, to, network);
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


    private Edge findDirectlyConnected(Node current, Node to, Network network){
        List<Edge> row = network.getRow(current.getId());
        for (Edge edge: row){
            if (edge.getToNode().equals(to)) return edge;
        }
        return null;
    }

    private Edge nextHops(Node current, Node to, Network network){
        List<Edge> row = network.getRow(current.getId());
        List<Edge> noVisited = new ArrayList<Edge>();
        for (Edge edge: row){
            if (!visited.contains(edge.getToNode())){
                noVisited.add(edge);
                Edge nextHops = findDirectlyConnected(edge.getToNode(), to, network);
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
