package route;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Edge {
    Node fromNode;
    Node toNode;
    Integer time;
//    Time arrivalTime;
}
