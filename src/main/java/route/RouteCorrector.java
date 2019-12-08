package route;

import java.util.List;
import java.util.stream.Collectors;

public class RouteCorrector {

    private static final Integer FIRST_ELEM_IN_ROW = 0;

    private List<Node> targetNeighbors;
    private Network network;
    private Node from;
    private Node target;

    public RouteCorrector(Network network, Node from, Node target) {
        this.network = network;
        this.from = from;
        this.target = target;
    }

    public Network findClosedNeighbors(){
        List<Node> neighborNodes = collectNeighborNodes();
        reduceNetwork(neighborNodes);
        return this.network;
    }

    private List<Node> collectNeighborNodes() {
        return this.network.getAllNodes().stream()
                .filter(this::isGoodDirection)
                .collect(Collectors.toList());
    }

    private void reduceNetwork(List<Node> targetNeighbors){

        this.network.setNetwork(reduceRows(targetNeighbors));
        this.network.setNetwork( this.network.getNetwork().stream()
                                    .map(row -> reduceColumns(row, targetNeighbors))
                                    .collect(Collectors.toList()) );
    }

    // TODO function choosing is a node in good direction
    private boolean isGoodDirection(Node node){
        if (this.from.getX() > this.target.getX()) {
            return true;
        }
        return false;
    }

    private List<List<Edge>> reduceRows(List<Node> targetNeighbors) {
        return this.network.getNetwork().stream()
                .filter(row -> targetNeighbors.contains(row.get(FIRST_ELEM_IN_ROW).getFromNode()))
                .collect(Collectors.toList());
    }

    private List<Edge> reduceColumns(List<Edge> row, List<Node> targetNeighbors) {
        return row.stream()
                .filter(col -> targetNeighbors.contains(col.getToNode()))
                .collect(Collectors.toList());
    }







}
