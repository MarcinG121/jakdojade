package simulation;

import lombok.AllArgsConstructor;
import lombok.Data;
import route.Edge;
import route.Network;
import route.Node;
import route.Route;

import java.util.List;
import java.util.Random;

@Data
@AllArgsConstructor
public class SimulatedAnnealing {

    private double minTemp;
    private double collingRate;
    private int iterationsNum;
    private double initialTemp;
    private Node sourceNode;
    private Node destinationNode;
    private Network network;

    public List<Edge> solve() {
        System.out.println("Simulated annealing is running...");

        Route route = new Route();
        int time = route.calculateJourneyTime(sourceNode, destinationNode, network);
        int newTime = 0;

        while(minTemp < initialTemp) {
            for(int i = 0; i < iterationsNum; i++) {
                assert true; // TODO if is needed
            }

            // Get time of solution
            Route newRoute = new Route();
            newTime = newRoute.calculateJourneyTime(sourceNode, destinationNode, network);

            // Decide to accept solution
            Random r = new Random();
            if(r.nextDouble() < acceptanceProbability(time, newTime, initialTemp)) {
                route = newRoute;
            }

            // Keep best solution
            if(newTime < time) {
                time = newTime;
            }

            // System cooling
            initialTemp *= collingRate;
        }
        System.out.println("Final solution is: " + time);
        return null;
    }
    private double acceptanceProbability(int time, int newTime, double temperature) {
        return newTime < time ? 1 : Math.exp((time - newTime) / temperature);
    }
}
