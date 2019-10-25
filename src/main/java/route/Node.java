package route;

import lombok.Data;
import transport.MeanOfTransport;

@Data
public class Node {
    Integer id;
    MeanOfTransport transport;
}
