package route;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Edge {
    Node fromNode;
    Node toNode;
    // TODO representation of time to work like in the clock
    Integer time;
}
