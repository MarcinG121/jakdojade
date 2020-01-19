import mocks.MockNetworks;
import org.junit.jupiter.api.Test;
import route.Network;
import route.Node;
import route.RouteCorrector;
import route.errors.DestinationUnreachableException;
import route.errors.NegativeTimeValueException;
import simulation.SimulatedAnnealing;

public class Environment {

    @Test
    public void testMockNetwork(){

        System.out.println(MockNetworks.getNetworkTwenty());

    }

    @Test
    public void testFindRoute() throws NegativeTimeValueException {
        double initTemp = 1000;
        double minTemp = 10;
        double collingRate = 0.9;
        int iterationsNum = 1000;
        double K_b = 1.380649 * 1E-23;
        String typeCooling = "Logarytmical";
        Integer startTime = 600;
        Network network = MockNetworks.getNetworkFifty();
        Node sourceNode = network.getRow(46).get(0).getFromNode();
        Node destinationNode = network.getRow(2).get(0).getFromNode();

        SimulatedAnnealing annealing = new SimulatedAnnealing(initTemp, minTemp, collingRate, iterationsNum, K_b,
                typeCooling, startTime, sourceNode,  destinationNode, network);
        System.out.println(annealing.solve());

    }

    @Test
    public void testDirection() throws DestinationUnreachableException {

        Network network = MockNetworks.getNetworkNine();
        Node sourceNode = network.getRow(2).get(0).getFromNode();
        Node destinationNode = network.getRow(5).get(0).getFromNode();
        RouteCorrector routeCorrector = new RouteCorrector(new Network(network), sourceNode, destinationNode);
        routeCorrector.findCloseNeighbors(null);

    }
}
