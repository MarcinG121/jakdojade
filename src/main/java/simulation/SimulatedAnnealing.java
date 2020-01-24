package simulation;

import lombok.Data;
import route.*;
import route.errors.DestinationReachException;
import route.errors.DestinationUnreachableException;
import route.errors.NegativeTimeValueException;
import simulation.result.BestResults;
import simulation.result.Result;
import transport.implementation.Foot;

import java.util.*;

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
    private Result previousBestRoute;

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

        currentRoute = generateNewRoute(this.startTime);
        previousBestRoute = currentRoute;
        Integer time = previousBestRoute.getCost();
        bestResults.add(previousBestRoute);
        Integer newTime;
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("[");
        while (actualTemp > minTemp) {

            currentRoute = generateNewResult();
            newTime = currentRoute.getCost();

            if (time > newTime) {
                previousBestRoute = currentRoute;
                stringBuilder.append(String.format("%d, " ,previousBestRoute.getCost()));
                if (newTime < bestResults.getResults().get(bestResults.getResults().size()-1).getCost()) {
                    bestResults.add(previousBestRoute);
                }
                time = newTime;
            } else if (time < newTime) {
                if (acceptanceProbability(time, newTime)) {
                    previousBestRoute = currentRoute;
                    time = newTime;
                }
            }

            decreaseTemperature();
            if (currentRoute.getResults().isEmpty()) {
                return this.bestResults;
            }
        }
        stringBuilder.setLength(stringBuilder.length()-2);
        stringBuilder.append("]");
        System.out.println(stringBuilder.toString());
        return this.bestResults;
    }

    private Result generateNewResult() throws NegativeTimeValueException {

//        TreeMap<Integer, Result> resultMap = new TreeMap<>();
//
//        Result result1 = correctSolution(10, 5);
//        resultMap.put(result1.getCost(), result1);
//        Result result2 = correctSolution(5, 25);
//        resultMap.put(result2.getCost(), result2);
//        Result result3 = correctSolution(16, 10);
//        resultMap.put(result3.getCost(), result3);
//        Result result4 = correctSolution(2, 25);
//        resultMap.put(result4.getCost(), result4);
//        Result result5 = correctSolution(0, 25);
//        resultMap.put(result5.getCost(), result5);
        double diff = (actualTemp -minTemp)/ initTemp;
        if (diff > 0.8) {
            return correctSolution(18, 3);
        } else if (diff > 0.75) {
            return correctSolution(17, 4);
        } else if (diff > 0.7) {
            return correctSolution(16, 5);
        } else if (diff > 0.65) {
            return correctSolution(15, 6);
        } else if (diff > 0.6) {
            return correctSolution(14, 7);
        } else if (diff > 0.55) {
            return correctSolution(13, 8);
        } else if (diff > 0.5) {
            return correctSolution(12, 9);
        } else if (diff > 0.45) {
            return correctSolution(11, 10);
        } else if (diff > 0.4) {
            return correctSolution(10, 11);
        } else if (diff > 0.35) {
            return correctSolution(9, 12);
        } else if (diff > 0.3) {
            return correctSolution(8, 13);
        } else if (diff > 0.25) {
            return correctSolution(7, 14);
        } else if (diff > 0.2) {
            return correctSolution(5, 15);
        }
        return correctSolution(getRandomNumberInRange(1, 5), getRandomNumberInRange(20, 25));
    }

    private Result correctSolution(int startRepair, int loopSize) throws NegativeTimeValueException {

        RouteCorrector routeCorrector = new RouteCorrector(new Network(network), sourceNode, destinationNode);
        RouteGenerator routeGenerator = new RouteGenerator(new Network(network), sourceNode, destinationNode, startTime);
        Result result = new Result();
        int actualTime = this.startTime;
        Edge nextEdge = null;
        int count = 0;

        if (startRepair > this.previousBestRoute.getResults().size()) {
//            return this.previousBestRoute.reachTargetOnFoot(this.destinationNode, this.sourceNode);
            return generateNewRoute(actualTime);
        }

        for (Edge edge : previousBestRoute.getResults()) {
            if (count > startRepair) break;
            if (edge.getMeanOfTransport().getClass().equals(Foot.class)) break;

            int cost = edge.getDriveTime() + (edge.getTime().getArrivalTime() - actualTime);
            actualTime += cost;
            result.addEdge(edge, cost);
            count += 1;
        }
        if (!result.getResults().isEmpty()){
            routeGenerator.changeSourceNode(result.getResults().get(result.getResults().size()-1).getToNode());
            routeCorrector.changeSourceNode(result.getResults().get(result.getResults().size()-1).getToNode());
            routeGenerator.changeStartTime(actualTime);
        }

        for (int i=0; i < loopSize; i++) {
            Result nextRoute = null;
            try {
                Network closedNeighbors = routeCorrector.findCloseNeighbors(result);
                routeGenerator.changeNetwork(closedNeighbors);
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
        return result.addResult(generateNewRoute(actualTime));
    }

    private int generateStartRepairing(int prev) {
        int problemSize = this.network.getNetwork().size()/2;
        int piece = (int) this.initTemp/problemSize;

        int actual = (int) (this.initTemp - this.actualTemp);

        if (actual > piece*prev) prev++;

        return prev;
    }

    private int generateLoopSize(int prev) {
        int problemSize = this.network.getNetwork().size();
        int piece = (int) this.initTemp/problemSize;

        int actual = (int) (this.initTemp - this.actualTemp);

        if (actual > piece*prev) prev++;

        return prev;
    }

    private Result generateNewRoute(int actualTime) {
        RouteGenerator routeGenerator = new RouteGenerator(new Network(network), sourceNode, destinationNode, actualTime);
        try {
            return routeGenerator.generateRoute().reachTargetOnFoot(this.destinationNode, null);
        } catch (DestinationReachException | DestinationUnreachableException | NegativeTimeValueException e) {
            return new Result().reachTargetOnFoot(this.destinationNode, this.sourceNode);
        }

    }

    private boolean acceptanceProbability(Integer time, Integer newTime) {

        if (time.equals(newTime)) return false;

        return Math.random() < Math.exp((time - newTime) / (actualTemp));
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

        private static int getRandomNumberInRange(int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("max must be greater than min");
        }
        if (min == max) return min;
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

}
