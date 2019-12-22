package simulation;

import lombok.AllArgsConstructor;
import lombok.Data;
import route.Network;
import route.Node;
import route.RouteCorrector;
import route.RouteGenerator;
import simulation.result.BestResults;
import simulation.result.Result;

@Data
@AllArgsConstructor
public class SimulatedAnnealing {

    private double minTemp;
    private double collingRate;
    private int iterationsNum;
    private double actualTemp;
    private Node sourceNode;
    private Node destinationNode;
    private Network network;
    private BestResults bestResults;
    private Result actualBestResult;

    public BestResults solve() {

        RouteCorrector routeCorrector = new RouteCorrector(network, sourceNode, destinationNode);
        RouteGenerator routeGenerator = new RouteGenerator(network, sourceNode, destinationNode);
        actualBestResult = routeGenerator.generateRoute();
        Integer time = actualBestResult.getCost();
        Integer newTime = 0;

        while(actualTemp > minTemp) {

            Result newResult = correctSolution(routeCorrector, routeGenerator);
            newTime = newResult.getCost();

            if( time > newTime) {
                actualBestResult = newResult;
            }
            else {
                if (acceptanceProbability(time, newTime)){
                    actualBestResult = newResult;
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

    // TODO should return boolean if accept new solution na ćwiczeniach to byla ta funkcja z exp(cos tam) która liczyła
    // TODO prawdopodobieństwo przyjęcia nowego rozwiązania początkowego
    private boolean acceptanceProbability(int time, int newTime) {
//        newTime < time ? 1 : Math.exp((time - newTime) / actualTemp);
        return false;
    }

    // TODO this function should depend on iterationNum
    // TODO trzeba obmyśleć jakiś wzorek w którym obniżanie temperatury będzie zależało od liczby iteracji
    // TODO nie koniecznie tak jak teraz musis to być zależnośc liniowa
    private void decreaseTemperature() {
        this.actualTemp *= this.collingRate;
    }
}
