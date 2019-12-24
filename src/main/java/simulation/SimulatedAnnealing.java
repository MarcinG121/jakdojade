package simulation;

import lombok.AllArgsConstructor;
import lombok.Data;
import route.*;
import simulation.result.BestResults;
import simulation.result.Result;

import java.util.List;

@Data
@AllArgsConstructor
public class SimulatedAnnealing {

    private double minTemp;
    private double collingRate;
    private int iterationsNum;
    private double actualTemp;
    private double K_b;
    private Node sourceNode;
    private Node destinationNode;
    private Network network;
    private BestResults bestResults;
    private Result actualBestResult;

    public BestResults solve() {

        RouteCorrector routeCorrector = new RouteCorrector(network, sourceNode, destinationNode);
        RouteGenerator routeGenerator = new RouteGenerator(network, sourceNode, destinationNode);
        List<Edge> firstRoute = routeGenerator.generateRoute();
        actualBestResult = new Result(firstRoute, routeGenerator.calculateJourneyTime());
        Integer time = routeGenerator.calculateJourneyTime();
        Integer newTime = 0;

        while(actualTemp > minTemp) {

            List<Edge> newRoute = correctSolution(routeCorrector, routeGenerator);
            newTime = routeGenerator.calculateJourneyTime();
            Result newResult = new Result(newRoute, newTime);

            if (time > newTime) {
                actualBestResult = newResult;
            }
            else {
                if (acceptanceProbability(time, newTime)) {
                    actualBestResult = newResult;
                }
            }

            decreaseTemperature();
        }
        return this.bestResults;
    }

    private List<Edge> correctSolution(RouteCorrector routeCorrector, RouteGenerator routeGenerator) {
        Network closedNeighbors = routeCorrector.findClosedNeighbors();
        routeGenerator.changeNetwork(closedNeighbors);
        return routeGenerator.generateRoute();
    }

    private boolean acceptanceProbability(int time, int newTime) {
        if (newTime < time) {
            return true;
        }

        Random r = new Random();
        return r.nextInt() < Math.exp((time - newTime) / (actualTemp*K_b);
    }

    // TODO this function should depend on iterationNum
    private void decreaseTemperature(String typeCooling) {
        switch (typeCooling):
        case "Linear":
            this.actualTemp *= this.collingRate;
            break;
        case "Geometrical":
            break;
        case "Logarytmical":
            break;
        default:
            System.out.println("You entered the wrong type of cooling.")
    }
}
