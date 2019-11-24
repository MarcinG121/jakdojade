package route;

import lombok.AllArgsConstructor;
import lombok.Data;
import simulation.Time;

@Data
@AllArgsConstructor
public class Edge {
    private Node fromNode;
    private Node toNode;
    private Time arrivalTime;
    private Time departureTime;

    public Edge(Node fromNode, Node toNode, Integer time) {
        this.fromNode = fromNode;
        this.toNode = toNode;
        this.arrivalTime = new Time();
        this.departureTime = new Time();
    }

    public Integer driveTime(){
        return departureTime.getTime() - arrivalTime.getTime();
    }

    public Integer getTime(){
        return driveTime();
    }


}
