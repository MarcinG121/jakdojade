package route;

import lombok.AllArgsConstructor;
import lombok.Data;
import transport.MeanOfTransport;

import java.util.List;

@Data
@AllArgsConstructor
public class Network {
    private MeanOfTransport meanOfTransport;
    private List<List<Edge>> theNetwork;

    public List<Edge> getRow(Integer num){
        return this.theNetwork.get(num-1);
    }
}
