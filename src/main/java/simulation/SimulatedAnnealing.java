package simulation;

import lombok.Data;
import route.Network;
import route.Node;
import route.RouteCorrector;
import route.RouteGenerator;
import simulation.result.BestResults;
import simulation.result.Result;

import java.util.Random;

@Data
public class SimulatedAnnealing {

    private double initTemp;
    private double minTemp;
    private double collingRate;
    private int iterationsNum;
    private double actualTemp;
    private double K_b;
    private String typeCooling;

    private Node sourceNode;
    private Node destinationNode;
    private Network network;
    private BestResults bestResults;
    private Result actualBestResult;

    public SimulatedAnnealing(double initTemp, double minTemp, double collingRate, int iterationsNum, double k_b,
                              String typeCooling, Node sourceNode, Node destinationNode, Network network)
    {
        this.initTemp = initTemp;
        this.actualTemp = initTemp;
        this.minTemp = minTemp;
        this.collingRate = collingRate;
        this.iterationsNum = iterationsNum;
        this.K_b = k_b;
        this.typeCooling = typeCooling;
        this.sourceNode = sourceNode;
        this.destinationNode = destinationNode;
        this.network = network;
    }

    public BestResults solve() {

        RouteCorrector routeCorrector = new RouteCorrector(network, sourceNode, destinationNode);
        RouteGenerator routeGenerator = new RouteGenerator(network, sourceNode, destinationNode);
        Result firstRoute = routeGenerator.generateRoute();
        Integer time = firstRoute.getCost();
        Integer newTime;

        while (actualTemp > minTemp) {

            Result newRoute = correctSolution(routeCorrector, routeGenerator);
            newTime = newRoute.getCost();

            if (time > newTime) {
                actualBestResult = newRoute;
            } else {
                if (acceptanceProbability(time, newTime)) {
                    actualBestResult = newRoute;
                }
            }
            decreaseTemperature();
        }
        return this.bestResults;
    }

    private Result correctSolution(RouteCorrector routeCorrector, RouteGenerator routeGenerator) {
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
        }
    }
}
