package transport.implementation;

import transport.MeanOfTransport;

public class Bus implements MeanOfTransport {

    private final static String meanOfTransport = "AUTOBUS";

    public String getType() {
        return meanOfTransport;
    }
}
