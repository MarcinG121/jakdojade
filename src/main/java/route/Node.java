package route;

import lombok.Data;

@Data
public class Node {
    private Integer id;
    private Integer x;
    private Integer y;

    public Node(Integer id){
        this.id = id;
        this.x = 0;
        this.y = 0;
    }

    public Node(Integer id, Integer x, Integer y){
        this.id = id;
        this.x = x;
        this.y = y;
    }
}
