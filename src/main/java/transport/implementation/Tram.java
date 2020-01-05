package transport.implementation;

import lombok.AllArgsConstructor;
import lombok.Data;
import transport.MeanOfTransport;

@Data
@AllArgsConstructor
public class Tram implements MeanOfTransport {

    private final static String meanOfTransport = "TRAMWAJ";

    public Integer lineNumber;

    public String getType() {
        return meanOfTransport;
    }
}
