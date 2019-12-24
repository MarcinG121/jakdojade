package simulation;

import lombok.AllArgsConstructor;
import lombok.Data;
import route.*;
import simulation.result.BestResults;
import simulation.result.Result;

import java.lang.Math;
import java.util.List;
import java.io.*;

@Data
@AllArgsConstructor
public class SimulatedAnnealing {

    private double initTemp;
    private double actualTemp;
    private double minTemp;
    private int iterationsNum;
    private double K_b;
    private String typeCooling;

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
        Integer newTime;

        while (actualTemp > minTemp) {

            List<Edge> newRoute = correctSolution(routeCorrector, routeGenerator);
            newTime = routeGenerator.calculateJourneyTime();
            Result newResult = new Result(newRoute, newTime);

            if (time > newTime) {
                actualBestResult = newResult;
            } else {
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

    private boolean acceptanceProbability(Integer time, Integer newTime) {
        Random r = new Random();

        return r.nextInt() < Math.exp((time - newTime) / (actualTemp * K_b));
    }

    private void decreaseTemperature() {
        switch (this.typeCooling) {
            case "Linear":
                this.actualTemp -= (this.initTemp - this.minTemp) / this.iterationsNum;
                break;
            case "Geometrical":
                this.actualTemp *= Math.pow(this.minTemp / this.initTemp, 1 / this.iterationsNum);
                break;
            case "Logarytmical":
                this.actualTemp /= 1 + this.actualTemp *
                        ((this.initTemp - this.minTemp) / (this.iterationsNum * this.minTemp * this.actualTemp));
                break;
            default:
                System.out.println("You entered the wrong type of cooling.");
        }
    }
}
