package mocks;

import route.Edge;
import route.Network;
import route.Node;
import transport.MeanOfTransport;
import transport.implementation.Bus;
import transport.implementation.Tram;

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

    /*
    //TODO: krawedzie sa w formacie edge(from, to, travel_time),
    // zmienić na edge(from, to, meanOfTransport, arrival_time, departure_time := arrival_time + travel_time)
    public static Network getNetworkTwenty(){

        List<Node> nodes = new ArrayList<Node>();
        nodes.add(new Node(1,12,14));
        nodes.add(new Node(2,15,14));
        nodes.add(new Node(3,19,14));
        nodes.add(new Node(4,23,14));
        nodes.add(new Node(5,3,11));
        nodes.add(new Node(6,6,11));
        nodes.add(new Node(7,9,11));
        nodes.add(new Node(8,12,11));
        nodes.add(new Node(9,15,11));
        nodes.add(new Node(10,0,7));
        nodes.add(new Node(11,3,7));
        nodes.add(new Node(12,6,7));
        nodes.add(new Node(13,9,7));
        nodes.add(new Node(14,12,7));
        nodes.add(new Node(15,15,3));
        nodes.add(new Node(16,15,3));
        nodes.add(new Node(17,15,3));
        nodes.add(new Node(18,15,3));
        nodes.add(new Node(19,6,0));
        nodes.add(new Node(20,9,0));

        // --- TRAMWAJ LINIA 1 ------------------------------------------
        // 5 > 6 > 7 > 8 > 1 > 2 > 3 > 4
        Edge tr1_05_06 = new Edge(nodes.get(4), nodes.get(5), 3);
        Edge tr1_05_07 = new Edge(nodes.get(4), nodes.get(6), 6);
        Edge tr1_05_08 = new Edge(nodes.get(4), nodes.get(7), 9);
        Edge tr1_05_01 = new Edge(nodes.get(4), nodes.get(0), 12);
        Edge tr1_05_02 = new Edge(nodes.get(4), nodes.get(1), 15);
        Edge tr1_05_03 = new Edge(nodes.get(4), nodes.get(2), 19);
        Edge tr1_05_04 = new Edge(nodes.get(4), nodes.get(3), 23);
        Edge tr1_06_07 = new Edge(nodes.get(5), nodes.get(6), 3);
        Edge tr1_06_08 = new Edge(nodes.get(5), nodes.get(7), 6);
        Edge tr1_06_01 = new Edge(nodes.get(5), nodes.get(0), 9);
        Edge tr1_06_02 = new Edge(nodes.get(5), nodes.get(1), 12);
        Edge tr1_06_03 = new Edge(nodes.get(5), nodes.get(2), 16);
        Edge tr1_06_04 = new Edge(nodes.get(5), nodes.get(3), 20);
        Edge tr1_07_08 = new Edge(nodes.get(6), nodes.get(7), 3);
        Edge tr1_07_01 = new Edge(nodes.get(6), nodes.get(0), 6);
        Edge tr1_07_02 = new Edge(nodes.get(6), nodes.get(1), 9);
        Edge tr1_07_03 = new Edge(nodes.get(6), nodes.get(2), 13);
        Edge tr1_07_04 = new Edge(nodes.get(6), nodes.get(3), 17);
        Edge tr1_08_01 = new Edge(nodes.get(7), nodes.get(0), 3);
        Edge tr1_08_02 = new Edge(nodes.get(7), nodes.get(1), 6);
        Edge tr1_08_03 = new Edge(nodes.get(7), nodes.get(2), 10);
        Edge tr1_08_04 = new Edge(nodes.get(7), nodes.get(3), 14);
        Edge tr1_01_02 = new Edge(nodes.get(0), nodes.get(1), 3);
        Edge tr1_01_03 = new Edge(nodes.get(0), nodes.get(2), 7);
        Edge tr1_01_04 = new Edge(nodes.get(0), nodes.get(3), 11);
        Edge tr1_02_03 = new Edge(nodes.get(1), nodes.get(2), 4);
        Edge tr1_02_04 = new Edge(nodes.get(1), nodes.get(3), 8);
        Edge tr1_03_04 = new Edge(nodes.get(2), nodes.get(3), 4);
        Edge tr1_04_03 = new Edge(nodes.get(3), nodes.get(2), 4);
        Edge tr1_04_02 = new Edge(nodes.get(3), nodes.get(1), 8);
        Edge tr1_04_01 = new Edge(nodes.get(3), nodes.get(0), 11);
        Edge tr1_04_08 = new Edge(nodes.get(3), nodes.get(7), 14);
        Edge tr1_04_07 = new Edge(nodes.get(3), nodes.get(6), 17);
        Edge tr1_04_06 = new Edge(nodes.get(3), nodes.get(5), 20);
        Edge tr1_04_05 = new Edge(nodes.get(3), nodes.get(4), 23);
        Edge tr1_03_02 = new Edge(nodes.get(2), nodes.get(1), 4);
        Edge tr1_03_01 = new Edge(nodes.get(2), nodes.get(0), 7);
        Edge tr1_03_08 = new Edge(nodes.get(2), nodes.get(7), 10);
        Edge tr1_03_07 = new Edge(nodes.get(2), nodes.get(6), 13);
        Edge tr1_03_06 = new Edge(nodes.get(2), nodes.get(5), 16);
        Edge tr1_03_05 = new Edge(nodes.get(2), nodes.get(4), 19);
        Edge tr1_02_01 = new Edge(nodes.get(1), nodes.get(0), 3);
        Edge tr1_02_08 = new Edge(nodes.get(1), nodes.get(7), 6);
        Edge tr1_02_07 = new Edge(nodes.get(1), nodes.get(6), 9);
        Edge tr1_02_06 = new Edge(nodes.get(1), nodes.get(5), 12);
        Edge tr1_02_05 = new Edge(nodes.get(1), nodes.get(4), 15);
        Edge tr1_01_08 = new Edge(nodes.get(0), nodes.get(7), 3);
        Edge tr1_01_07 = new Edge(nodes.get(0), nodes.get(6), 6);
        Edge tr1_01_06 = new Edge(nodes.get(0), nodes.get(5), 9);
        Edge tr1_01_05 = new Edge(nodes.get(0), nodes.get(4), 12);
        Edge tr1_08_07 = new Edge(nodes.get(7), nodes.get(6), 3);
        Edge tr1_08_06 = new Edge(nodes.get(7), nodes.get(5), 6);
        Edge tr1_08_05 = new Edge(nodes.get(7), nodes.get(4), 9);
        Edge tr1_07_06 = new Edge(nodes.get(6), nodes.get(5), 3);
        Edge tr1_07_05 = new Edge(nodes.get(6), nodes.get(4), 6);
        Edge tr1_06_05 = new Edge(nodes.get(5), nodes.get(4), 3);
        // --------------------------------------------------------------

        // --- TRAMWAJ LINIA 2 ------------------------------------------
        // 5 > 6 > 7 > 13 > 17 > 20
        Edge tr2_05_06 = new Edge(nodes.get(4), nodes.get(5), 3);
        Edge tr2_05_07 = new Edge(nodes.get(4), nodes.get(6), 6);
        Edge tr2_05_13 = new Edge(nodes.get(4), nodes.get(12), 10);
        Edge tr2_05_17 = new Edge(nodes.get(4), nodes.get(16), 14);
        Edge tr2_05_20 = new Edge(nodes.get(4), nodes.get(19), 17);
        Edge tr2_06_07 = new Edge(nodes.get(5), nodes.get(6), 3);
        Edge tr2_06_13 = new Edge(nodes.get(5), nodes.get(12), 7);
        Edge tr2_06_17 = new Edge(nodes.get(5), nodes.get(16), 11);
        Edge tr2_06_20 = new Edge(nodes.get(5), nodes.get(19), 14);
        Edge tr2_07_13 = new Edge(nodes.get(6), nodes.get(12), 4);
        Edge tr2_07_17 = new Edge(nodes.get(6), nodes.get(16), 8);
        Edge tr2_07_20 = new Edge(nodes.get(6), nodes.get(19), 11);
        Edge tr2_13_17 = new Edge(nodes.get(12), nodes.get(16), 4);
        Edge tr2_13_20 = new Edge(nodes.get(12), nodes.get(19), 7);
        Edge tr2_17_20 = new Edge(nodes.get(16), nodes.get(19), 3);
        Edge tr2_20_17 = new Edge(nodes.get(19), nodes.get(16), 3);
        Edge tr2_20_13 = new Edge(nodes.get(19), nodes.get(12), 7);
        Edge tr2_20_07 = new Edge(nodes.get(19), nodes.get(6), 11);
        Edge tr2_20_06 = new Edge(nodes.get(19), nodes.get(5), 14);
        Edge tr2_20_05 = new Edge(nodes.get(19), nodes.get(4), 17);
        Edge tr2_17_13 = new Edge(nodes.get(16), nodes.get(12), 4);
        Edge tr2_17_07 = new Edge(nodes.get(16), nodes.get(6), 8);
        Edge tr2_17_06 = new Edge(nodes.get(16), nodes.get(5), 11);
        Edge tr2_17_05 = new Edge(nodes.get(16), nodes.get(4), 14);
        Edge tr2_13_07 = new Edge(nodes.get(12), nodes.get(6), 4);
        Edge tr2_13_06 = new Edge(nodes.get(12), nodes.get(5), 7);
        Edge tr2_13_05 = new Edge(nodes.get(12), nodes.get(4), 10);
        Edge tr2_07_06 = new Edge(nodes.get(6), nodes.get(5), 3);
        Edge tr2_07_05 = new Edge(nodes.get(6), nodes.get(4), 6);
        Edge tr2_06_05 = new Edge(nodes.get(5), nodes.get(4), 3);
        // --------------------------------------------------------------

        // --- TRAMWAJ LINIA 3 ------------------------------------------
        // 20 > 17 > 13 > 7 > 8 > 1 > 2 > 3 > 4
        Edge tr3_20_17 = new Edge(nodes.get(19), nodes.get(16), 3);
        Edge tr3_20_13 = new Edge(nodes.get(19), nodes.get(12), 7);
        Edge tr3_20_07 = new Edge(nodes.get(19), nodes.get(6), 11);
        Edge tr3_20_08 = new Edge(nodes.get(19), nodes.get(7), 14);
        Edge tr3_20_01 = new Edge(nodes.get(19), nodes.get(0), 17);
        Edge tr3_20_02 = new Edge(nodes.get(19), nodes.get(1), 20);
        Edge tr3_20_03 = new Edge(nodes.get(19), nodes.get(2), 24);
        Edge tr3_20_04 = new Edge(nodes.get(19), nodes.get(3), 28);
        Edge tr3_17_13 = new Edge(nodes.get(19), nodes.get(12), 4);
        Edge tr3_17_07 = new Edge(nodes.get(16), nodes.get(6), 8);
        Edge tr3_17_08 = new Edge(nodes.get(16), nodes.get(7), 11);
        Edge tr3_17_01 = new Edge(nodes.get(16), nodes.get(0), 14);
        Edge tr3_17_02 = new Edge(nodes.get(16), nodes.get(1), 17);
        Edge tr3_17_03 = new Edge(nodes.get(16), nodes.get(2), 21);
        Edge tr3_17_04 = new Edge(nodes.get(16), nodes.get(3), 25);
        Edge tr3_13_07 = new Edge(nodes.get(12), nodes.get(6), 4);
        Edge tr3_13_08 = new Edge(nodes.get(12), nodes.get(7), 7);
        Edge tr3_13_01 = new Edge(nodes.get(12), nodes.get(0), 10);
        Edge tr3_13_02 = new Edge(nodes.get(12), nodes.get(1), 13);
        Edge tr3_13_03 = new Edge(nodes.get(12), nodes.get(2), 17);
        Edge tr3_13_04 = new Edge(nodes.get(12), nodes.get(3), 21);
        Edge tr3_07_08 = new Edge(nodes.get(6), nodes.get(7), 3);
        Edge tr3_07_01 = new Edge(nodes.get(6), nodes.get(0), 6);
        Edge tr3_07_02 = new Edge(nodes.get(6), nodes.get(1), 9);
        Edge tr3_07_03 = new Edge(nodes.get(6), nodes.get(2), 13);
        Edge tr3_07_04 = new Edge(nodes.get(6), nodes.get(3), 17);
        Edge tr3_08_01 = new Edge(nodes.get(7), nodes.get(0), 3);
        Edge tr3_08_02 = new Edge(nodes.get(7), nodes.get(1), 6);
        Edge tr3_08_03 = new Edge(nodes.get(7), nodes.get(2), 10);
        Edge tr3_08_04 = new Edge(nodes.get(7), nodes.get(3), 14);
        Edge tr3_01_02 = new Edge(nodes.get(0), nodes.get(1), 3);
        Edge tr3_01_03 = new Edge(nodes.get(0), nodes.get(2), 7);
        Edge tr3_01_04 = new Edge(nodes.get(0), nodes.get(3), 11);
        Edge tr3_02_03 = new Edge(nodes.get(1), nodes.get(2), 4);
        Edge tr3_02_04 = new Edge(nodes.get(1), nodes.get(3), 8);
        Edge tr3_03_04 = new Edge(nodes.get(2), nodes.get(3), 4);
        Edge tr3_04_03 = new Edge(nodes.get(3), nodes.get(2), 4);
        Edge tr3_04_02 = new Edge(nodes.get(3), nodes.get(1), 8);
        Edge tr3_04_01 = new Edge(nodes.get(3), nodes.get(0), 11);
        Edge tr3_04_08 = new Edge(nodes.get(3), nodes.get(7), 14);
        Edge tr3_04_07 = new Edge(nodes.get(3), nodes.get(6), 17);
        Edge tr3_04_13 = new Edge(nodes.get(3), nodes.get(12), 21);
        Edge tr3_04_17 = new Edge(nodes.get(3), nodes.get(16), 25);
        Edge tr3_04_20 = new Edge(nodes.get(3), nodes.get(19), 28);
        Edge tr3_03_02 = new Edge(nodes.get(2), nodes.get(1), 4);
        Edge tr3_03_01 = new Edge(nodes.get(2), nodes.get(0), 7);
        Edge tr3_03_08 = new Edge(nodes.get(2), nodes.get(7), 10);
        Edge tr3_03_07 = new Edge(nodes.get(2), nodes.get(6), 13);
        Edge tr3_03_13 = new Edge(nodes.get(2), nodes.get(12), 17);
        Edge tr3_03_17 = new Edge(nodes.get(2), nodes.get(16), 21);
        Edge tr3_03_20 = new Edge(nodes.get(2), nodes.get(19), 24);
        Edge tr3_02_01 = new Edge(nodes.get(1), nodes.get(0), 3);
        Edge tr3_02_08 = new Edge(nodes.get(1), nodes.get(7), 6);
        Edge tr3_02_07 = new Edge(nodes.get(1), nodes.get(6), 9);
        Edge tr3_02_13 = new Edge(nodes.get(1), nodes.get(12), 13);
        Edge tr3_02_17 = new Edge(nodes.get(1), nodes.get(16), 17);
        Edge tr3_02_20 = new Edge(nodes.get(1), nodes.get(19), 20);
        Edge tr3_01_08 = new Edge(nodes.get(0), nodes.get(7), 3);
        Edge tr3_01_07 = new Edge(nodes.get(0), nodes.get(6), 6);
        Edge tr3_01_13 = new Edge(nodes.get(0), nodes.get(12), 10);
        Edge tr3_01_17 = new Edge(nodes.get(0), nodes.get(16), 14);
        Edge tr3_01_20 = new Edge(nodes.get(0), nodes.get(19), 17);
        Edge tr3_08_07 = new Edge(nodes.get(7), nodes.get(6), 3);
        Edge tr3_08_13 = new Edge(nodes.get(7), nodes.get(12), 7);
        Edge tr3_08_17 = new Edge(nodes.get(7), nodes.get(16), 11);
        Edge tr3_08_20 = new Edge(nodes.get(7), nodes.get(19), 14);
        Edge tr3_07_13 = new Edge(nodes.get(6), nodes.get(12), 4);
        Edge tr3_07_17 = new Edge(nodes.get(6), nodes.get(16), 8);
        Edge tr3_07_20 = new Edge(nodes.get(6), nodes.get(19), 11);
        Edge tr3_13_17 = new Edge(nodes.get(12), nodes.get(16), 4);
        Edge tr3_13_20 = new Edge(nodes.get(12), nodes.get(19), 7);
        Edge tr3_17_20 = new Edge(nodes.get(16), nodes.get(19), 3);
        // --------------------------------------------------------------

        // --- BUS LINIA 1 ------------------------------------------
        // 9 > 8 > 7 > 6 > 5 > 11 > 15 > 16 > 17 > 18
        Edge bus1_09_08 = new Edge(nodes.get(8), nodes.get(7), 3);
        Edge bus1_09_07 = new Edge(nodes.get(8), nodes.get(6), 6);
        Edge bus1_09_06 = new Edge(nodes.get(8), nodes.get(5), 9);
        Edge bus1_09_05 = new Edge(nodes.get(8), nodes.get(4), 12);
        Edge bus1_09_11 = new Edge(nodes.get(8), nodes.get(10), 16);
        Edge bus1_09_15 = new Edge(nodes.get(8), nodes.get(14), 20);
        Edge bus1_09_16 = new Edge(nodes.get(8), nodes.get(15), 23);
        Edge bus1_09_17 = new Edge(nodes.get(8), nodes.get(16), 26);
        Edge bus1_09_18 = new Edge(nodes.get(8), nodes.get(17), 29);
        Edge bus1_08_07 = new Edge(nodes.get(7), nodes.get(6), 3);
        Edge bus1_08_06 = new Edge(nodes.get(7), nodes.get(5), 6);
        Edge bus1_08_05 = new Edge(nodes.get(7), nodes.get(4), 9);
        Edge bus1_08_11 = new Edge(nodes.get(7), nodes.get(10), 13);
        Edge bus1_08_15 = new Edge(nodes.get(7), nodes.get(14), 17);
        Edge bus1_08_16 = new Edge(nodes.get(7), nodes.get(15), 20);
        Edge bus1_08_17 = new Edge(nodes.get(7), nodes.get(16), 23);
        Edge bus1_08_18 = new Edge(nodes.get(7), nodes.get(17), 26);
        Edge bus1_07_06 = new Edge(nodes.get(6), nodes.get(5), 3);
        Edge bus1_07_05 = new Edge(nodes.get(6), nodes.get(4), 6);
        Edge bus1_07_11 = new Edge(nodes.get(6), nodes.get(10), 10);
        Edge bus1_07_15 = new Edge(nodes.get(6), nodes.get(14), 14);
        Edge bus1_07_16 = new Edge(nodes.get(6), nodes.get(15), 17);
        Edge bus1_07_17 = new Edge(nodes.get(6), nodes.get(16), 20);
        Edge bus1_07_18 = new Edge(nodes.get(6), nodes.get(17), 23);
        Edge bus1_06_05 = new Edge(nodes.get(5), nodes.get(4), 3);
        Edge bus1_06_11 = new Edge(nodes.get(5), nodes.get(10), 7);
        Edge bus1_06_15 = new Edge(nodes.get(5), nodes.get(14), 11);
        Edge bus1_06_16 = new Edge(nodes.get(5), nodes.get(15), 14);
        Edge bus1_06_17 = new Edge(nodes.get(5), nodes.get(16), 17);
        Edge bus1_06_18 = new Edge(nodes.get(5), nodes.get(17), 20);
        Edge bus1_05_11 = new Edge(nodes.get(4), nodes.get(10), 4);
        Edge bus1_05_15 = new Edge(nodes.get(4), nodes.get(14), 8);
        Edge bus1_05_16 = new Edge(nodes.get(4), nodes.get(15), 11);
        Edge bus1_05_17 = new Edge(nodes.get(4), nodes.get(16), 14);
        Edge bus1_05_18 = new Edge(nodes.get(4), nodes.get(17), 17);
        Edge bus1_11_15 = new Edge(nodes.get(10), nodes.get(14), 4);
        Edge bus1_11_16 = new Edge(nodes.get(10), nodes.get(15), 7);
        Edge bus1_11_17 = new Edge(nodes.get(10), nodes.get(16), 10);
        Edge bus1_11_18 = new Edge(nodes.get(10), nodes.get(17), 13);
        Edge bus1_15_16 = new Edge(nodes.get(14), nodes.get(15), 3);
        Edge bus1_15_17 = new Edge(nodes.get(14), nodes.get(16), 6);
        Edge bus1_15_18 = new Edge(nodes.get(14), nodes.get(17), 9);
        Edge bus1_16_17 = new Edge(nodes.get(15), nodes.get(16), 3);
        Edge bus1_16_18 = new Edge(nodes.get(15), nodes.get(17), 6);
        Edge bus1_17_18 = new Edge(nodes.get(16), nodes.get(17), 3);
        Edge bus1_18_17 = new Edge(nodes.get(17), nodes.get(16), 3);
        Edge bus1_18_16 = new Edge(nodes.get(17), nodes.get(15), 6);
        Edge bus1_18_15 = new Edge(nodes.get(17), nodes.get(14), 9);
        Edge bus1_18_11 = new Edge(nodes.get(17), nodes.get(10), 13);
        Edge bus1_18_05 = new Edge(nodes.get(17), nodes.get(4), 17);
        Edge bus1_18_06 = new Edge(nodes.get(17), nodes.get(5), 20);
        Edge bus1_18_07 = new Edge(nodes.get(17), nodes.get(6), 23);
        Edge bus1_18_08 = new Edge(nodes.get(17), nodes.get(7), 26);
        Edge bus1_18_09 = new Edge(nodes.get(17), nodes.get(8), 29);
        Edge bus1_17_16 = new Edge(nodes.get(16), nodes.get(15), 3);
        Edge bus1_17_15 = new Edge(nodes.get(16), nodes.get(14), 6);
        Edge bus1_17_11 = new Edge(nodes.get(16), nodes.get(10), 10);
        Edge bus1_17_05 = new Edge(nodes.get(16), nodes.get(4), 14);
        Edge bus1_17_06 = new Edge(nodes.get(16), nodes.get(5), 17);
        Edge bus1_17_07 = new Edge(nodes.get(16), nodes.get(6), 20);
        Edge bus1_17_08 = new Edge(nodes.get(16), nodes.get(7), 23);
        Edge bus1_17_09 = new Edge(nodes.get(16), nodes.get(8), 26);
        Edge bus1_16_15 = new Edge(nodes.get(15), nodes.get(14), 3);
        Edge bus1_16_11 = new Edge(nodes.get(15), nodes.get(10), 7);
        Edge bus1_16_05 = new Edge(nodes.get(15), nodes.get(4), 11);
        Edge bus1_16_06 = new Edge(nodes.get(15), nodes.get(5), 14);
        Edge bus1_16_07 = new Edge(nodes.get(15), nodes.get(6), 17);
        Edge bus1_16_08 = new Edge(nodes.get(15), nodes.get(7), 20);
        Edge bus1_16_09 = new Edge(nodes.get(15), nodes.get(8), 23);
        Edge bus1_15_11 = new Edge(nodes.get(14), nodes.get(10), 4);
        Edge bus1_15_05 = new Edge(nodes.get(14), nodes.get(4), 8);
        Edge bus1_15_06 = new Edge(nodes.get(14), nodes.get(5), 11);
        Edge bus1_15_07 = new Edge(nodes.get(14), nodes.get(6), 14);
        Edge bus1_15_08 = new Edge(nodes.get(14), nodes.get(7), 17);
        Edge bus1_15_09 = new Edge(nodes.get(14), nodes.get(8), 20);
        Edge bus1_11_05 = new Edge(nodes.get(10), nodes.get(4), 4);
        Edge bus1_11_06 = new Edge(nodes.get(10), nodes.get(5), 7);
        Edge bus1_11_07 = new Edge(nodes.get(10), nodes.get(6), 10);
        Edge bus1_11_08 = new Edge(nodes.get(10), nodes.get(7), 13);
        Edge bus1_11_09 = new Edge(nodes.get(10), nodes.get(8), 16);
        Edge bus1_05_06 = new Edge(nodes.get(4), nodes.get(5), 3);
        Edge bus1_05_07 = new Edge(nodes.get(4), nodes.get(6), 6);
        Edge bus1_05_08 = new Edge(nodes.get(4), nodes.get(7), 9);
        Edge bus1_05_09 = new Edge(nodes.get(4), nodes.get(8), 12);
        Edge bus1_06_07 = new Edge(nodes.get(5), nodes.get(6), 3);
        Edge bus1_06_08 = new Edge(nodes.get(5), nodes.get(7), 6);
        Edge bus1_06_09 = new Edge(nodes.get(5), nodes.get(8), 9);
        Edge bus1_07_08 = new Edge(nodes.get(6), nodes.get(7), 3);
        Edge bus1_07_09 = new Edge(nodes.get(6), nodes.get(8), 6);
        Edge bus1_08_09 = new Edge(nodes.get(7), nodes.get(8), 3);
        // --------------------------------------------------------------

        // --- BUS LINIA 2 ------------------------------------------
        // 9 > 8 > 7 > 6 > 12 > 16 > 19 > 20
        Edge bus2_09_08 = new Edge(nodes.get(8), nodes.get(7), 3);
        Edge bus2_09_07 = new Edge(nodes.get(8), nodes.get(6), 6);
        Edge bus2_09_06 = new Edge(nodes.get(8), nodes.get(5), 9);
        Edge bus2_09_12 = new Edge(nodes.get(8), nodes.get(11), 13);
        Edge bus2_09_16 = new Edge(nodes.get(8), nodes.get(15), 17);
        Edge bus2_09_19 = new Edge(nodes.get(8), nodes.get(18), 20);
        Edge bus2_09_20 = new Edge(nodes.get(8), nodes.get(19), 23);
        Edge bus2_08_07 = new Edge(nodes.get(7), nodes.get(6), 3);
        Edge bus2_08_06 = new Edge(nodes.get(7), nodes.get(5), 6);
        Edge bus2_08_12 = new Edge(nodes.get(7), nodes.get(11), 10);
        Edge bus2_08_16 = new Edge(nodes.get(7), nodes.get(15), 14);
        Edge bus2_08_19 = new Edge(nodes.get(7), nodes.get(18), 17);
        Edge bus2_08_20 = new Edge(nodes.get(7), nodes.get(19), 20);
        Edge bus2_07_06 = new Edge(nodes.get(6), nodes.get(5), 3);
        Edge bus2_07_12 = new Edge(nodes.get(6), nodes.get(11), 7);
        Edge bus2_07_16 = new Edge(nodes.get(6), nodes.get(15), 11);
        Edge bus2_07_19 = new Edge(nodes.get(6), nodes.get(18), 14);
        Edge bus2_07_20 = new Edge(nodes.get(6), nodes.get(19), 17);
        Edge bus2_06_12 = new Edge(nodes.get(5), nodes.get(11), 4);
        Edge bus2_06_16 = new Edge(nodes.get(5), nodes.get(15), 8);
        Edge bus2_06_19 = new Edge(nodes.get(5), nodes.get(18), 11);
        Edge bus2_06_20 = new Edge(nodes.get(5), nodes.get(19), 14);
        Edge bus2_12_16 = new Edge(nodes.get(11), nodes.get(15), 4);
        Edge bus2_12_19 = new Edge(nodes.get(11), nodes.get(18), 7);
        Edge bus2_12_20 = new Edge(nodes.get(11), nodes.get(19), 10);
        Edge bus2_16_19 = new Edge(nodes.get(15), nodes.get(18), 3);
        Edge bus2_16_20 = new Edge(nodes.get(15), nodes.get(19), 6);
        Edge bus2_19_20 = new Edge(nodes.get(18), nodes.get(19), 3);
        Edge bus2_20_19 = new Edge(nodes.get(19), nodes.get(18), 3);
        Edge bus2_20_16 = new Edge(nodes.get(19), nodes.get(15), 6);
        Edge bus2_20_12 = new Edge(nodes.get(19), nodes.get(11), 10);
        Edge bus2_20_06 = new Edge(nodes.get(19), nodes.get(5), 14);
        Edge bus2_20_07 = new Edge(nodes.get(19), nodes.get(6), 17);
        Edge bus2_20_08 = new Edge(nodes.get(19), nodes.get(7), 20);
        Edge bus2_20_09 = new Edge(nodes.get(19), nodes.get(8), 23);
        Edge bus2_19_16 = new Edge(nodes.get(18), nodes.get(15), 3);
        Edge bus2_19_12 = new Edge(nodes.get(18), nodes.get(11), 7);
        Edge bus2_19_06 = new Edge(nodes.get(18), nodes.get(5), 11);
        Edge bus2_19_07 = new Edge(nodes.get(18), nodes.get(6), 14);
        Edge bus2_19_08 = new Edge(nodes.get(18), nodes.get(7), 17);
        Edge bus2_19_09 = new Edge(nodes.get(18), nodes.get(8), 20);
        Edge bus2_16_12 = new Edge(nodes.get(15), nodes.get(11), 4);
        Edge bus2_16_06 = new Edge(nodes.get(15), nodes.get(5), 8);
        Edge bus2_16_07 = new Edge(nodes.get(15), nodes.get(6), 11);
        Edge bus2_16_08 = new Edge(nodes.get(15), nodes.get(7), 14);
        Edge bus2_16_09 = new Edge(nodes.get(15), nodes.get(8), 17);
        Edge bus2_12_06 = new Edge(nodes.get(11), nodes.get(5), 4);
        Edge bus2_12_07 = new Edge(nodes.get(11), nodes.get(6), 7);
        Edge bus2_12_08 = new Edge(nodes.get(11), nodes.get(7), 10);
        Edge bus2_12_09 = new Edge(nodes.get(11), nodes.get(8), 13);
        Edge bus2_06_07 = new Edge(nodes.get(5), nodes.get(6), 3);
        Edge bus2_06_08 = new Edge(nodes.get(5), nodes.get(7), 6);
        Edge bus2_06_09 = new Edge(nodes.get(5), nodes.get(8), 9);
        Edge bus2_07_08 = new Edge(nodes.get(6), nodes.get(7), 3);
        Edge bus2_07_09 = new Edge(nodes.get(6), nodes.get(8), 6);
        Edge bus2_08_09 = new Edge(nodes.get(7), nodes.get(8), 3);
        // --------------------------------------------------------------

        // --- BUS LINIA 3 ------------------------------------------
        // 1 > 8 > 14 > 13 > 12 > 11 > 10
        Edge bus3_01_08 = new Edge(nodes.get(0), nodes.get(7), 3);
        Edge bus3_01_14 = new Edge(nodes.get(0), nodes.get(13), 7);
        Edge bus3_01_13 = new Edge(nodes.get(0), nodes.get(12), 10);
        Edge bus3_01_12 = new Edge(nodes.get(0), nodes.get(11), 13);
        Edge bus3_01_11 = new Edge(nodes.get(0), nodes.get(10), 16);
        Edge bus3_01_10 = new Edge(nodes.get(0), nodes.get(9), 19);
        Edge bus3_08_14 = new Edge(nodes.get(7), nodes.get(13), 4);
        Edge bus3_08_13 = new Edge(nodes.get(7), nodes.get(12), 7);
        Edge bus3_08_12 = new Edge(nodes.get(7), nodes.get(11), 10);
        Edge bus3_08_11 = new Edge(nodes.get(7), nodes.get(10), 13);
        Edge bus3_08_10 = new Edge(nodes.get(7), nodes.get(9), 16);
        Edge bus3_14_13 = new Edge(nodes.get(13), nodes.get(12), 3);
        Edge bus3_14_12 = new Edge(nodes.get(13), nodes.get(11), 6);
        Edge bus3_14_11 = new Edge(nodes.get(13), nodes.get(10), 9);
        Edge bus3_14_10 = new Edge(nodes.get(13), nodes.get(9), 12);
        Edge bus3_13_12 = new Edge(nodes.get(12), nodes.get(11), 3);
        Edge bus3_13_11 = new Edge(nodes.get(12), nodes.get(10), 6);
        Edge bus3_13_10 = new Edge(nodes.get(12), nodes.get(9), 9);
        Edge bus3_12_11 = new Edge(nodes.get(11), nodes.get(10), 3);
        Edge bus3_12_10 = new Edge(nodes.get(11), nodes.get(9), 6);
        Edge bus3_11_10 = new Edge(nodes.get(10), nodes.get(9), 3);
        Edge bus3_10_11 = new Edge(nodes.get(9), nodes.get(10), 3);
        Edge bus3_10_12 = new Edge(nodes.get(9), nodes.get(11), 6);
        Edge bus3_10_13 = new Edge(nodes.get(9), nodes.get(12), 9);
        Edge bus3_10_14 = new Edge(nodes.get(9), nodes.get(13), 12);
        Edge bus3_10_08 = new Edge(nodes.get(9), nodes.get(7), 16);
        Edge bus3_10_01 = new Edge(nodes.get(9), nodes.get(0), 19);
        Edge bus3_11_12 = new Edge(nodes.get(10), nodes.get(11), 3);
        Edge bus3_11_13 = new Edge(nodes.get(10), nodes.get(12), 6);
        Edge bus3_11_14 = new Edge(nodes.get(10), nodes.get(13), 9);
        Edge bus3_11_08 = new Edge(nodes.get(10), nodes.get(7), 13);
        Edge bus3_11_01 = new Edge(nodes.get(10), nodes.get(0), 16);
        Edge bus3_12_13 = new Edge(nodes.get(11), nodes.get(12), 3);
        Edge bus3_12_14 = new Edge(nodes.get(11), nodes.get(13), 6);
        Edge bus3_12_08 = new Edge(nodes.get(11), nodes.get(7), 10);
        Edge bus3_12_01 = new Edge(nodes.get(11), nodes.get(0), 13);
        Edge bus3_13_14 = new Edge(nodes.get(12), nodes.get(13), 3);
        Edge bus3_13_08 = new Edge(nodes.get(12), nodes.get(7), 7);
        Edge bus3_13_01 = new Edge(nodes.get(12), nodes.get(0), 10);
        Edge bus3_14_08 = new Edge(nodes.get(13), nodes.get(7), 4);
        Edge bus3_14_01 = new Edge(nodes.get(13), nodes.get(0), 7);
        Edge bus3_08_01 = new Edge(nodes.get(7), nodes.get(0), 3);
        // --------------------------------------------------------------

        // --- BUS LINIA 4 ------------------------------------------
        // 14 > 18 > 17 > 20 > 19 > 16 > 15
        Edge bus4_14_18 = new Edge(nodes.get(13), nodes.get(17), 4);
        Edge bus4_14_17 = new Edge(nodes.get(13), nodes.get(16), 7);
        Edge bus4_14_20 = new Edge(nodes.get(13), nodes.get(19), 10);
        Edge bus4_14_19 = new Edge(nodes.get(13), nodes.get(18), 13);
        Edge bus4_14_16 = new Edge(nodes.get(13), nodes.get(15), 16);
        Edge bus4_14_15 = new Edge(nodes.get(13), nodes.get(14), 19);
        Edge bus4_18_17 = new Edge(nodes.get(17), nodes.get(16), 3);
        Edge bus4_18_20 = new Edge(nodes.get(17), nodes.get(19), 6);
        Edge bus4_18_19 = new Edge(nodes.get(17), nodes.get(18), 9);
        Edge bus4_18_16 = new Edge(nodes.get(17), nodes.get(15), 12);
        Edge bus4_18_15 = new Edge(nodes.get(17), nodes.get(14), 15);
        Edge bus4_17_20 = new Edge(nodes.get(16), nodes.get(19), 3);
        Edge bus4_17_19 = new Edge(nodes.get(16), nodes.get(18), 6);
        Edge bus4_17_16 = new Edge(nodes.get(16), nodes.get(15), 9);
        Edge bus4_17_15 = new Edge(nodes.get(16), nodes.get(14), 12);
        Edge bus4_20_19 = new Edge(nodes.get(19), nodes.get(18), 3);
        Edge bus4_20_16 = new Edge(nodes.get(19), nodes.get(15), 6);
        Edge bus4_20_15 = new Edge(nodes.get(19), nodes.get(14), 9);
        Edge bus4_19_16 = new Edge(nodes.get(18), nodes.get(15), 3);
        Edge bus4_19_15 = new Edge(nodes.get(18), nodes.get(14), 6);
        Edge bus4_16_15 = new Edge(nodes.get(15), nodes.get(14), 3);
        Edge bus4_15_16 = new Edge(nodes.get(14), nodes.get(15), 3);
        Edge bus4_15_19 = new Edge(nodes.get(14), nodes.get(18), 6);
        Edge bus4_15_20 = new Edge(nodes.get(14), nodes.get(19), 9);
        Edge bus4_15_17 = new Edge(nodes.get(14), nodes.get(16), 12);
        Edge bus4_15_18 = new Edge(nodes.get(14), nodes.get(17), 15);
        Edge bus4_15_14 = new Edge(nodes.get(14), nodes.get(13), 19);
        Edge bus4_16_19 = new Edge(nodes.get(15), nodes.get(18), 3);
        Edge bus4_16_20 = new Edge(nodes.get(15), nodes.get(19), 6);
        Edge bus4_16_17 = new Edge(nodes.get(15), nodes.get(16), 9);
        Edge bus4_16_18 = new Edge(nodes.get(15), nodes.get(17), 12);
        Edge bus4_16_14 = new Edge(nodes.get(15), nodes.get(13), 16);
        Edge bus4_19_20 = new Edge(nodes.get(18), nodes.get(19), 3);
        Edge bus4_19_17 = new Edge(nodes.get(18), nodes.get(16), 6);
        Edge bus4_19_18 = new Edge(nodes.get(18), nodes.get(17), 9);
        Edge bus4_19_14 = new Edge(nodes.get(18), nodes.get(13), 13);
        Edge bus4_20_17 = new Edge(nodes.get(19), nodes.get(16), 3);
        Edge bus4_20_18 = new Edge(nodes.get(19), nodes.get(17), 6);
        Edge bus4_20_14 = new Edge(nodes.get(19), nodes.get(13), 10);
        Edge bus4_17_18 = new Edge(nodes.get(16), nodes.get(17), 3);
        Edge bus4_17_14 = new Edge(nodes.get(16), nodes.get(13), 7);
        Edge bus4_18_14 = new Edge(nodes.get(17), nodes.get(13), 4);
        // --------------------------------------------------------------

        List<Edge> row1 = Arrays.asList(tr1_01_02, tr1_01_03, tr1_01_04, tr1_01_05, tr1_01_06, tr1_01_07, tr1_01_08,
                tr3_01_02, tr3_01_03, tr3_01_04, tr3_01_07, tr3_01_08, tr3_01_13, tr3_01_17, tr3_01_20,
                bus3_01_08, bus3_01_10, bus3_01_11, bus3_01_12, bus3_01_13, bus3_01_14);
        List<Edge> row2 = Arrays.asList(tr1_02_01, tr1_02_03, tr1_02_04, tr1_02_05, tr1_02_06, tr1_02_07, tr1_02_08,
                tr3_02_01, tr3_02_03, tr3_02_04, tr3_02_07, tr3_02_08, tr3_02_13, tr3_02_17, tr3_02_20);
        List<Edge> row3 = Arrays.asList(tr1_03_01, tr1_03_02, tr1_03_04, tr1_03_05, tr1_03_06, tr1_03_07, tr1_03_08,
                tr3_03_01, tr3_03_02, tr3_03_04, tr3_03_07, tr3_03_08, tr3_03_13, tr3_03_17, tr3_03_20);
        List<Edge> row4 = Arrays.asList(tr1_04_01, tr1_04_02, tr1_04_03, tr1_04_05, tr1_04_06, tr1_04_07, tr1_04_08,
                tr3_04_01, tr3_04_02, tr3_04_03, tr3_04_07, tr3_04_08, tr3_04_13, tr3_04_17, tr3_04_20);
        List<Edge> row5 = Arrays.asList(tr1_05_01, tr1_05_02, tr1_05_03, tr1_05_04, tr1_05_06, tr1_05_07, tr1_05_08,
                tr2_05_06, tr2_05_07, tr2_05_13, tr2_05_17, tr2_05_20,
                bus1_05_06, bus1_05_07, bus1_05_08, bus1_05_09, bus1_05_11, bus1_05_15,
                bus1_05_16, bus1_05_17, bus1_05_18);
        List<Edge> row6 = Arrays.asList(tr1_06_01, tr1_06_02, tr1_06_03, tr1_06_04, tr1_06_05, tr1_06_07, tr1_06_08,
                tr2_06_05, tr2_06_07, tr2_06_13, tr2_06_17, tr2_06_20,
                bus1_06_05, bus1_06_07, bus1_06_08, bus1_06_09, bus1_06_11, bus1_06_15,
                bus1_06_16, bus1_06_17, bus1_06_18,
                bus2_06_07, bus2_06_08, bus2_06_09, bus2_06_12, bus2_06_16, bus2_06_19, bus2_06_20);
        List<Edge> row7 = Arrays.asList(tr1_07_01, tr1_07_02, tr1_07_03, tr1_07_04, tr1_07_05, tr1_07_06, tr1_07_08,
                tr2_07_05, tr2_07_06, tr2_07_13, tr2_07_17, tr2_07_20,
                tr3_07_01, tr3_07_02, tr3_07_03, tr3_07_04, tr3_07_08, tr3_07_13, tr3_07_17, tr3_07_20,
                bus1_07_05, bus1_07_06, bus1_07_08, bus1_07_09, bus1_07_11, bus1_07_15,
                bus1_07_16, bus1_07_17, bus1_07_18,
                bus2_07_06, bus2_07_08, bus2_07_09, bus2_07_12, bus2_07_16, bus2_07_19, bus2_07_20);
        List<Edge> row8 = Arrays.asList(tr1_08_01, tr1_08_02, tr1_08_03, tr1_08_04, tr1_08_05, tr1_08_06, tr1_08_07,
                tr3_08_01, tr3_08_02, tr3_08_03, tr3_08_04, tr3_08_07, tr3_08_13, tr3_08_17, tr3_08_20,
                bus1_08_05, bus1_08_06, bus1_08_07, bus1_08_09, bus1_08_11, bus1_08_15,
                bus1_08_16, bus1_08_17, bus1_08_18,
                bus2_08_06, bus2_08_07, bus2_08_09, bus2_08_12, bus2_08_16, bus2_08_19, bus2_08_20,
                bus3_08_01, bus3_08_10, bus3_08_11, bus3_08_12, bus3_08_13, bus3_08_14);
        List<Edge> row9 = Arrays.asList(bus1_09_05, bus1_09_06, bus1_09_07, bus1_09_08, bus1_09_11, bus1_09_15,
                bus1_09_16, bus1_09_17, bus1_09_18,
                bus2_09_06, bus2_09_07, bus2_09_08, bus2_09_12, bus2_09_16, bus2_09_19, bus2_09_20);
        List<Edge> row10 = Arrays.asList(bus3_10_01, bus3_10_08, bus3_10_11, bus3_10_12, bus3_10_13, bus3_10_14);
        List<Edge> row11 = Arrays.asList(bus1_11_05, bus1_11_06, bus1_11_07, bus1_11_08, bus1_11_09, bus1_11_15,
                bus1_11_16, bus1_11_17, bus1_11_18,
                bus3_11_01, bus3_11_08, bus3_11_10, bus3_11_12, bus3_11_13, bus3_11_14);
        List<Edge> row12 = Arrays.asList(bus2_12_06, bus2_12_07, bus2_12_08, bus2_12_09, bus2_12_16, bus2_12_19,
                bus2_12_20,
                bus3_12_01, bus3_12_08, bus3_12_10, bus3_12_11, bus3_12_13, bus3_12_14);
        List<Edge> row13 = Arrays.asList(tr2_13_05, tr2_13_06, tr2_13_07, tr2_13_17, tr2_13_20,
                tr3_13_01, tr3_13_02, tr3_13_03, tr3_13_04, tr3_13_07, tr3_13_08, tr3_13_17, tr3_13_20,
                bus3_13_01, bus3_13_08, bus3_13_10, bus3_13_11, bus3_13_12, bus3_13_14);
        List<Edge> row14 = Arrays.asList(bus3_14_01, bus3_14_08, bus3_14_10, bus3_14_11, bus3_14_12, bus3_14_13,
                bus4_14_15, bus4_14_16, bus4_14_17, bus4_14_18, bus4_14_19, bus4_14_20);
        List<Edge> row15 = Arrays.asList(bus1_15_05, bus1_15_06, bus1_15_07, bus1_15_08, bus1_15_09, bus1_15_11,
                bus1_15_16, bus1_15_17, bus1_15_18,
                bus4_15_14, bus4_15_16, bus4_15_17, bus4_15_18, bus4_15_19, bus4_15_20);
        List<Edge> row16 = Arrays.asList(bus1_16_05, bus1_16_06, bus1_16_07, bus1_16_08, bus1_16_09, bus1_16_11,
                bus1_16_15, bus1_16_17, bus1_16_18,
                bus2_16_06, bus2_16_07, bus2_16_08, bus2_16_09, bus2_16_12, bus2_16_19, bus2_16_20,
                bus4_16_14, bus4_16_15, bus4_16_17, bus4_16_18, bus4_16_19, bus4_16_20);
        List<Edge> row17 = Arrays.asList(tr2_17_05, tr2_17_06, tr2_17_07, tr2_17_13, tr2_17_20,
                tr3_17_01, tr3_17_02, tr3_17_03, tr3_17_04, tr3_17_07, tr3_17_08, tr3_17_13, tr3_17_20,
                bus1_17_05, bus1_17_06, bus1_17_07, bus1_17_08, bus1_17_09, bus1_17_11,
                bus1_17_15, bus1_17_16, bus1_17_18,
                bus4_17_14, bus4_17_15, bus4_17_16, bus4_17_18, bus4_17_19, bus4_17_20);
        List<Edge> row18 = Arrays.asList(bus1_18_05, bus1_18_06, bus1_18_07, bus1_18_08, bus1_18_09, bus1_18_11,
                bus1_18_15, bus1_18_16, bus1_18_17,
                bus4_18_14, bus4_18_15, bus4_18_16, bus4_18_17, bus4_18_19, bus4_18_20);
        List<Edge> row19 = Arrays.asList(bus2_19_06, bus2_19_07, bus2_19_08, bus2_19_09, bus2_19_12, bus2_19_16,
                bus2_19_20,
                bus4_19_14, bus4_19_15, bus4_19_16, bus4_19_17, bus4_19_18, bus4_19_20);
        List<Edge> row20 = Arrays.asList(tr2_20_05, tr2_20_06, tr2_20_07, tr2_20_13, tr2_20_17,
                tr3_20_01, tr3_20_02, tr3_20_03, tr3_20_04, tr3_20_07, tr3_20_08, tr3_20_13, tr3_20_17,
                bus2_20_06, bus2_20_07, bus2_20_08, bus2_20_09, bus2_20_12, bus2_20_16,
                bus2_20_19,
                bus4_20_14, bus4_20_15, bus4_20_16, bus4_20_17, bus4_20_18, bus4_20_19);

        List<List<Edge>> network = Arrays.asList(row1, row2, row3, row4, row5, row6, row7, row8, row9, row10,
                row11, row12, row13, row14, row15, row16, row17, row18, row19, row20);

        return new Network(new Bus(), network);
    }
    */
}
