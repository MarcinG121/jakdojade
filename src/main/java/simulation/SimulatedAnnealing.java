package simulation;

import mocks.MockNetworks;
import route.Network;
import route.Node;
import route.Route;

import java.util.*;


public class SimulatedAnnealing {

    // Final temperature to which the system cools (iteration terminates)
    public static double T_min = 1;

    // Coefficient of decrease temperature
    public static double collingRate = 0.9;

    // Number of iterations before decreasing temperature
    public static int numIterations = 100;

    // Initial temperature
    public static double T = 1000;

    // Initial node
    public static Node src = new Node(1);

    // Destination node
    public static Node dest = new Node(2);

    // Network
    public static Network network = MockNetworks.getNetworkFour();

    // Calculate the acceptance probability
    public static double acceptanceProbability(int time, int newTime, double temperature) {
        return newTime < time ? 1 : Math.exp((time - newTime) / temperature);
    }


    public static void main(String[] args) {
        System.out.println("Simulated annealing is running...");

        Route route = new Route();
        int time = route.calculateJourneyTime(src, dest, network);
        int newTime = 0;

        while(T_min < T) {
            for(int i = 0; i < numIterations; i++) {
                assert true; // TO DO if is needed
            }

            // Get time of solution
            Route newRoute = new Route();
            newTime = newRoute.calculateJourneyTime(src, dest, network);

            // Decide to accept solution
            Random r = new Random();
            if(r.nextDouble() < acceptanceProbability(time, newTime, T)) {
                route = newRoute;
            }

            // Keep best solution
            if(newTime < time) {
                time = newTime;
            }

            // System cooling
            T *= collingRate;
        }
        System.out.println("Final solution is: " + time);

    }
}
