package mocks;

import route.Edge;
import route.Network;
import route.Node;
import transport.MeanOfTransport;
import transport.implementation.Bus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MockNetworks {


    public static Network getNetworkFour(){
        MeanOfTransport transport = new Bus();
        List<Node> nodes = new ArrayList<Node>();
        for (int i = 1; i < 6; i++){
            nodes.add(new Node(i));
        }

        Edge edge13 = new Edge(nodes.get(0), nodes.get(2), 3);
        Edge edge15 = new Edge(nodes.get(0), nodes.get(4), 3);
        Edge edge14 = new Edge(nodes.get(0), nodes.get(3), 3);
        Edge edge21 = new Edge(nodes.get(1), nodes.get(0), 3);
        Edge edge42 = new Edge(nodes.get(3), nodes.get(1), 3);
        Edge edge52 = new Edge(nodes.get(4), nodes.get(1), 3);

        List<Edge> row1 = Arrays.asList(edge13, edge14, edge15);
        List<Edge> row2 = Arrays.asList(edge21);
        List<Edge> row3 = new ArrayList<Edge>();
        List<Edge> row4 = Arrays.asList(edge42);
        List<Edge> row5 = Arrays.asList(edge52);

        List<List<Edge>> network = Arrays.asList(row1, row2, row3, row4, row5);

        return new Network(transport, network);
    }



    private static int getRandomNumberInRange(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

//    private List<Edge> createRouteForOneMeanOfTransport(Integer networkSize, Integer rowNum){
//        List<Edge> result = new ArrayList<Edge>();
//        for (int i = 0; i < networkSize; i++){
//            Edge edge = new Edge();
//            edge.setFromNode(new Node(rowNum));
//            edge.setToNode(new Node(getRandomNumberInRange(0, networkSize)));
//            edge.setTime((float) getRandomNumberInRange(0, 15));
//            result.add(edge);
//        }
//        return result;
//    }

}
