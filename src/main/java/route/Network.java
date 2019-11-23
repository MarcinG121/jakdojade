package route;

import lombok.AllArgsConstructor;
import lombok.Data;
import transport.MeanOfTransport;

import java.util.List;

@Data
@AllArgsConstructor
public class Network {
    MeanOfTransport meanOfTransport;
    List<List<Edge>> theNetwork;

    public List<Edge> getRow(Integer num){
        return this.theNetwork.get(num-1);
    }
}
