package route;

import lombok.Data;
import simulation.Time;
import transport.MeanOfTransport;
import transport.implementation.Foot;

import java.util.Objects;

@Data
public class Edge {
    private Node fromNode;
    private Node toNode;
    private MeanOfTransport meanOfTransport;
    private Time time;

    public Edge(Node fromNode, Node toNode, MeanOfTransport transport, Integer arrivalTime, Integer departureTime) {
        this.fromNode = fromNode;
        this.toNode = toNode;
        this.meanOfTransport = transport;
        this.time = new Time(arrivalTime, departureTime);
    }

    public Edge(Node fromNode, Node toNode, MeanOfTransport transport) {
        if (!transport.getClass().equals(Foot.class)) {
            throw new IllegalArgumentException();
        }
        this.fromNode = fromNode;
        this.toNode = toNode;
        this.meanOfTransport = transport;
    }

    public Edge(Edge edge) {
        if (!Objects.isNull(edge)) {
            this.fromNode = edge.getFromNode();
            this.toNode = edge.getToNode();
            this.meanOfTransport = edge.getMeanOfTransport();
            this.time = new Time(edge.getTime().getArrivalTime(), edge.getTime().getDepartureTime());
        }
    }

    public Integer getDriveTime() {
        return time.getDepartureTime() - time.getArrivalTime();
    }

    public Integer getDriveTimeWithWaiting(Integer startTime) {
        return getDriveTime() + startTime;
    }

    @Override
    public String toString() {
        return fromNode.getId().toString();
    }
}
