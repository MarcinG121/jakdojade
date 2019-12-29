package simulation.result;

import lombok.Data;
import route.Edge;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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

    public void addEdge(Edge edge) {
        results.add(edge);
        cost = cost + edge.getDriveTime();
    }


}
