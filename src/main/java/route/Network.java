package route;

import lombok.AllArgsConstructor;
import lombok.Data;
import transport.MeanOfTransport;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class Network {
    private MeanOfTransport meanOfTransport;
    private List<List<Edge>> network;

    public List<Edge> getRow(Integer num) {
        return this.network.get(num-1);
    }

    public List<Node> getAllNodes(){
        return this.network.stream().map(r -> r.get(0).getFromNode()).collect(Collectors.toList());
    }
}
