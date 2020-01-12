package simulation;

import lombok.Data;
import route.*;
import route.errors.DestinationReachException;
import route.errors.DestinationUnreachableException;
import route.errors.NegativeTimeValueException;
import simulation.result.BestResults;
import simulation.result.Result;

import java.util.ArrayList;
import java.util.Random;

@Data
public class SimulatedAnnealing {

    private static final int MAX_TIME = 1440;

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
        this.bestResults = new BestResults();
    }

    public BestResults solve() throws NegativeTimeValueException {

        currentRoute = generateNewRoute();
        Integer time = currentRoute.getCost();
        Integer newTime;


        while (actualTemp > minTemp) {

            currentRoute = correctSolution(2,25);
            newTime = currentRoute.getCost();

            if (time > newTime) {
                bestResults.add(currentRoute);
                time = newTime;
            } else {
                if (acceptanceProbability(time, newTime)) {
                    currentRoute = generateNewRoute();
                }
            }

            decreaseTemperature();
            if (currentRoute.getResults().isEmpty()) {
                return this.bestResults;
            }
        }
        return this.bestResults;
    }

    private Result correctSolution(int startRepair, int loopSize) throws NegativeTimeValueException {

        RouteCorrector routeCorrector = new RouteCorrector(new Network(network), sourceNode, destinationNode);
        RouteGenerator routeGenerator = new RouteGenerator(new Network(network), sourceNode, destinationNode, startTime);
        Result result = new Result();
        int actualTime = this.startTime;
        Edge nextEdge = null;
        int count = 0;
        Node startNode = null;

        if (startRepair > this.currentRoute.getResults().size()) {
            return new Result().reachTargetOnFoot(this.destinationNode, this.sourceNode);
        }

        for (Edge edge : currentRoute.getResults()) {
            if (count > startRepair) {
                startNode = edge.getFromNode();
                break;
            }
            int cost = edge.getDriveTime() + (edge.getTime().getArrivalTime() - actualTime);
            actualTime += cost;
            result.addEdge(edge, cost);
            count += 1;
        }
        routeGenerator.changeSourceNode(startNode);
        routeCorrector.changeSourceNode(startNode);

        for (int i=0; i < loopSize; i++) {
            Network closedNeighbors = routeCorrector.findCloseNeighbors(nextEdge);
            routeGenerator.changeNetwork(closedNeighbors);
            Result nextRoute = null;
            try {
                nextRoute = routeGenerator.generateRoute();
            } catch (DestinationReachException e) {
                return result;
            } catch (DestinationUnreachableException e) {
                return result.reachTargetOnFoot(this.destinationNode, this.sourceNode);
            }
            if (!nextRoute.getResults().isEmpty()) {
                nextEdge = nextRoute.getResults().get(0);
                int cost = nextEdge.getDriveTime() + (nextEdge.getTime().getArrivalTime() - actualTime);
                actualTime += cost;
                result.addEdge(nextEdge, cost);
                routeGenerator.changeStartTime(actualTime);
                routeGenerator.changeSourceNode(nextEdge.getToNode());
                routeCorrector.changeSourceNode(nextEdge.getToNode());
            }
        }
        return result.reachTargetOnFoot(this.destinationNode, this.sourceNode);
    }

    private Result generateNewRoute() {
        RouteGenerator routeGenerator = new RouteGenerator(new Network(network), sourceNode, destinationNode, startTime);
        try {
            return routeGenerator.generateRoute().reachTargetOnFoot(this.destinationNode, null);
        } catch (DestinationReachException | DestinationUnreachableException | NegativeTimeValueException e) {
            return new Result().reachTargetOnFoot(this.destinationNode, this.sourceNode);
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
