package transport.implementation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import transport.MeanOfTransport;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bus implements MeanOfTransport {

    private final static String meanOfTransport = "AUTOBUS";
    public Integer lineNumber;

    public String getType() {
        return meanOfTransport;
    }
}
