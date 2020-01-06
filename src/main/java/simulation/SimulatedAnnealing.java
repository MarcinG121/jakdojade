package simulation;

import lombok.Data;
import org.apache.commons.lang.SerializationUtils;
import route.*;
import route.errors.DestinationReachException;
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
    private Integer startTime;
    private Result currentRoute;

    private Node sourceNode;
    private Node destinationNode;
    private Network network;
    private BestResults bestResults;

    public SimulatedAnnealing(double initTemp, double minTemp, double collingRate, int iterationsNum, double k_b,
                              String typeCooling, Integer startTime, Node sourceNode, Node destinationNode, Network network)
    {
        this.initTemp = initTemp;
        this.actualTemp = initTemp;
        this.minTemp = minTemp;
        this.collingRate = collingRate;
        this.iterationsNum = iterationsNum;
        this.K_b = k_b;
        this.typeCooling = typeCooling;
        this.startTime = startTime;
        this.sourceNode = sourceNode;
        this.destinationNode = destinationNode;
        this.network = network;
    }

    public BestResults solve() {

        RouteCorrector routeCorrector = new RouteCorrector(network, sourceNode, destinationNode);
        RouteGenerator routeGenerator = new RouteGenerator(network, sourceNode, destinationNode, startTime);
        currentRoute = generateNewRoute(routeCorrector, routeGenerator);
        Integer time = currentRoute.getCost();
        Integer newTime;

        while (actualTemp > minTemp) {

            currentRoute = correctSolution(routeGenerator, routeCorrector);
            newTime = currentRoute.getCost();

            if (time > newTime) {
                bestResults.add((Result) SerializationUtils.clone(currentRoute));
            } else {
                if (acceptanceProbability(time, newTime)) {
                    currentRoute = generateNewRoute(routeCorrector,routeGenerator);
                }
            }
            decreaseTemperature();
        }
        return this.bestResults;
    }

    private Result correctSolution(RouteGenerator routeGenerator, RouteCorrector routeCorrector) {

        int loopSize = network.getNetwork().size();
        Result result = new Result();
        for (int i=0; i < loopSize; i++) {
            Network closedNeighbors = routeCorrector.findClosedNeighbors();
            routeGenerator.changeNetwork(closedNeighbors);
            Result nextRoute = null;
            try {
                nextRoute = routeGenerator.generateRoute();
            } catch (DestinationReachException e) {
                return result;
            }
            if (!nextRoute.getResults().isEmpty()) {
                Edge nextEdge = nextRoute.getResults().get(0);
                result.addEdge(nextEdge);
                routeGenerator.changeSourceNode(nextEdge.getToNode());
                routeCorrector.changeSourceNode(nextEdge.getToNode());
            }
        }
        return result;
    }

    private Result generateNewRoute(RouteCorrector routeCorrector, RouteGenerator routeGenerator) {
        Network closedNeighbors = routeCorrector.findClosedNeighbors();
        routeGenerator.changeNetwork(closedNeighbors);
        try {
            return routeGenerator.generateRoute();
        } catch (DestinationReachException e) {
            return new Result();
        }
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
