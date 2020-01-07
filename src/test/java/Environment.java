import mocks.MockNetworks;
import org.junit.jupiter.api.Test;
import route.Network;
import route.Node;
import simulation.SimulatedAnnealing;

public class Environment {

    @Test
    public void testMockNetwork(){

        System.out.println(MockNetworks.getNetworkTwenty());

    }

    @Test
    public void testFindRoute(){
        double initTemp = 1000;
        double minTemp = 10;
        double collingRate = 0.9;
        int iterationsNum = 10;
        double K_b = 1.380649 * 1E-23;
        String typeCooling = "Linear";
        Integer startTime = 36;
        Network network = MockNetworks.getNetworkNine();
        Node sourceNode = network.getRow(3).get(0).getFromNode();
        Node destinationNode = network.getRow(2).get(0).getFromNode();

        SimulatedAnnealing annealing = new SimulatedAnnealing(initTemp, minTemp, collingRate, iterationsNum, K_b,
                typeCooling, startTime, sourceNode,  destinationNode, network);
        System.out.println(annealing.solve());

    }
}
