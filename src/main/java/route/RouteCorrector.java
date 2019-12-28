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

    private boolean isGoodDirection(Node node) {
        double A_1 = (this.target.getY() - this.from.getY()) / (this.target.getX() - this.from.getX());
        double A_2 = -(1 / A_1);
        double B_2 = this.from.getY() - A_2*from.getX();

        return A_2*node.getX() + B_2 < node.getY();

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
