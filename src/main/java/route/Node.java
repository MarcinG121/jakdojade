package route;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Node {
    private Integer id;
    private Integer x;
    private Integer y;

    public Node(Integer id){
        this.id = id;
        this.x = 0;
        this.y = 0;
    }
}
