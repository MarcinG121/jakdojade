package simulation.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import route.Edge;

import java.util.List;

@Data
@AllArgsConstructor
public class Result {

    private List<Edge> results;
    private Integer cost;
}
