package transport.implementation;


import transport.MeanOfTransport;

public class Tram implements MeanOfTransport {

    private final static String meanOfTransport = "TRAMWAJ";

    public String getType() {
        return meanOfTransport;
    }
}
