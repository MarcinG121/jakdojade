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
        this.targetNeighbors = collectNeighborNodes();
        reduceNetwork();
        return this.network;
    }

    public void changeDestinationNode(Node target) {
        this.target = target;
    }

    public void changeSourceNode(Node from) {
        this.from = from;
    }

    private List<Node> collectNeighborNodes() {
        return this.network.getAllNodes().stream()
                .filter(this::isGoodDirection)
                .collect(Collectors.toList());
    }

    private void reduceNetwork(){

        this.network.setNetwork(reduceRows());
        this.network.setNetwork( this.network.getNetwork().stream()
                                    .map(this::reduceColumns)
                                    .collect(Collectors.toList()) );
    }

    private boolean isGoodDirection(Node node) {
        double dist_x = this.target.getX() - this.from.getX();
        double dist_y = this.target.getY() - this.from.getY();

        if (dist_x == 0) {
            if (this.from.getY() < this.target.getY()) {
                return this.from.getY() <= node.getY();
            } else {
                return this.from.getY() >= node.getY();
            }
        } else {
            if (dist_y == 0) {
                if (this.from.getX() < this.target.getX()) {
                    return this.from.getX() <= node.getX();
                } else {
                    return this.from.getX() >= node.getX();
                }
            } else {
                double A_1 = dist_y / dist_x;
                double A_2 = -(1 / A_1);
                double B_2 = this.from.getY() - A_2 * this.from.getX();

                return A_2 * node.getX() + B_2 < node.getY();
            }
        }
    }

    private List<List<Edge>> reduceRows() {
        return this.network.getNetwork().stream()
                .filter(row -> targetNeighbors.contains(row.get(FIRST_ELEM_IN_ROW).getFromNode()))
                .collect(Collectors.toList());
    }

    private List<Edge> reduceColumns(List<Edge> row) {
        return row.stream()
                .filter(col -> targetNeighbors.contains(col.getToNode()))
                .collect(Collectors.toList());
    }

}
