package transport.implementation;

import transport.MeanOfTransport;

public class Foot implements MeanOfTransport {

    private final static String meanOfTransport = "Z BUTA";

    public String getType() {
        return meanOfTransport;
    }
}
