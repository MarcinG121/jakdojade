package simulation.result;

import lombok.Data;
import route.Edge;
import route.Node;
import transport.implementation.Foot;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
public class Result implements Serializable {

    private List<Edge> results;
    private Integer cost;

    public Result() {
        this.results = new ArrayList<>();
        this.cost = 0;
    }

    public Result(List<Edge> results, Integer cost) {
        this.results = results;
        this.cost = cost;
    }

    public void addEdge(Edge edge, int cost) {
        results.add(edge);
        this.cost = this.cost + cost;
    }

    public Result reachTargetOnFoot(Node target, Node from) {

        Node last = null;
        try {
            last = this.results.get(this.results.size() - 1).getToNode();
        } catch (ArrayIndexOutOfBoundsException e) {
            last = from;
        }

        if (!last.equals(target)) {
            Edge lastEdge = new Edge(last, target, new Foot());

            this.results.add(lastEdge);
            double path = (last.getX()-target.getX())*(last.getX()-target.getX()) +
                    (last.getY()-target.getY())*(last.getY()-target.getY());
            this.cost = this.cost +  ((int) path )*2;
            return this;
        }
        return this;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Edge edge : this.results) {
            builder.append(String.format("%s->", edge.toString()));
        }
        builder.append(results.get(results.size()-1).getToNode().getId());
        builder.append(String.format("||%d", this.cost));
        return builder.toString();
    }
}
