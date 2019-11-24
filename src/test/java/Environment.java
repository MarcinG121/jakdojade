import mocks.MockNetworks;
import org.junit.jupiter.api.Test;
import route.Edge;
import route.Network;
import route.Node;
import route.Route;

import java.util.List;

public class Environment {

    @Test
    public void testMockNetwork(){

        System.out.println(MockNetworks.getNetworkFour());


    }

    @Test
    public void testFindRoute(){

        Network network = MockNetworks.getNetworkFour();
        Route route = new Route();

        List<Edge> re = route.findRoute(new Node(1), new Node(2), network);
        Integer time_re = route.calculateJourneyTime(new Node(1), new Node(2), network);

        System.out.println(re);
        System.out.println(time_re);
    }
}
