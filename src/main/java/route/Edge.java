package route;

import lombok.Data;

@Data
public class Edge {
    Node fromNode;
    Node toNode;
    Float time;
}
