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

public class MockNetworks {


//    public static Network getNetworkFour(){
////        MeanOfTransport transport = new Bus();
////        List<Node> nodes = new ArrayList<Node>();
////        for (int i = 1; i < 6; i++){
////            nodes.add(new Node(i));
////        }
////
////        Edge edge13 = new Edge(nodes.get(0), nodes.get(2), 3);
////        Edge edge15 = new Edge(nodes.get(0), nodes.get(4), 3);
////        Edge edge14 = new Edge(nodes.get(0), nodes.get(3), 3);
////        Edge edge21 = new Edge(nodes.get(1), nodes.get(0), 3);
////        Edge edge42 = new Edge(nodes.get(3), nodes.get(1), 3);
////        Edge edge52 = new Edge(nodes.get(4), nodes.get(1), 3);
////
////        List<Edge> row1 = Arrays.asList(edge13, edge14, edge15);
////        List<Edge> row2 = Arrays.asList(edge21);
////        List<Edge> row3 = new ArrayList<Edge>();
////        List<Edge> row4 = Arrays.asList(edge42);
////        List<Edge> row5 = Arrays.asList(edge52);
////
////        List<List<Edge>> network = Arrays.asList(row1, row2, row3, row4, row5);
////
////        return new Network(transport, network);
////    }



//    private static int getRandomNumberInRange(int min, int max) {
//        if (min >= max) {
//            throw new IllegalArgumentException("max must be greater than min");
//        }
//        Random r = new Random();
//        return r.nextInt((max - min) + 1) + min;
//    }

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



    public static Network getNetworkTwenty(){

        // STEP 1. creating 20 nodes
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
        nodes.add(new Node(15,3,3));
        nodes.add(new Node(16,6,3));
        nodes.add(new Node(17,9,3));
        nodes.add(new Node(18,12,3));
        nodes.add(new Node(19,6,0));
        nodes.add(new Node(20,9,0));

        // STEP 2. creating 20 rows for network
        List<Edge> row1 = new ArrayList<Edge>();
        List<Edge> row2 = new ArrayList<Edge>();
        List<Edge> row3 = new ArrayList<Edge>();
        List<Edge> row4 = new ArrayList<Edge>();
        List<Edge> row5 = new ArrayList<Edge>();
        List<Edge> row6 = new ArrayList<Edge>();
        List<Edge> row7 = new ArrayList<Edge>();
        List<Edge> row8 = new ArrayList<Edge>();
        List<Edge> row9 = new ArrayList<Edge>();
        List<Edge> row10 = new ArrayList<Edge>();
        List<Edge> row11 = new ArrayList<Edge>();
        List<Edge> row12 = new ArrayList<Edge>();
        List<Edge> row13 = new ArrayList<Edge>();
        List<Edge> row14 = new ArrayList<Edge>();
        List<Edge> row15 = new ArrayList<Edge>();
        List<Edge> row16 = new ArrayList<Edge>();
        List<Edge> row17 = new ArrayList<Edge>();
        List<Edge> row18 = new ArrayList<Edge>();
        List<Edge> row19 = new ArrayList<Edge>();
        List<Edge> row20 = new ArrayList<Edge>();

        // STEP 3. creating a lot of edges and adding them into rows


        // --- PARAMETRY LINII ------------------------------------------
        MeanOfTransport tram = new Tram();
        MeanOfTransport bus = new Bus();
        Integer offset1;    // offset1 - czas wystartowania pierwszego kursu
        Integer offset2;    // offset1 + offset2 - czas wystartowania pierwszego kursu w kierunku przeciwnym
        Integer interval;   // czas miedzy kursami
        Integer last_one;   // last_one (i last_one + offset2) - czas, po którym nie startują kursy

        // --- TRAMWAJ LINIA 1 ------------------------------------------
        // 5 > 6 > 7 > 8 > 1 > 2 > 3 > 4
        offset1 = 5*60;
        offset2 = 14;
        interval = 20;
        last_one = 22*60;
        for(Integer offset = offset1; offset < last_one; offset+=interval){

            row5.add(new Edge(nodes.get(4), nodes.get(5), tram, offset, offset + 3 ));
            row5.add(new Edge(nodes.get(4), nodes.get(6), tram, offset, offset + 6 ));
            row5.add(new Edge(nodes.get(4), nodes.get(7), tram, offset, offset + 9 ));
            row5.add(new Edge(nodes.get(4), nodes.get(0), tram, offset, offset + 12));
            row5.add(new Edge(nodes.get(4), nodes.get(1), tram, offset, offset + 15));
            row5.add(new Edge(nodes.get(4), nodes.get(2), tram, offset, offset + 19));
            row5.add(new Edge(nodes.get(4), nodes.get(3), tram, offset, offset + 23));
            row6.add(new Edge(nodes.get(5), nodes.get(6), tram, offset, offset + 3 ));
            row6.add(new Edge(nodes.get(5), nodes.get(7), tram, offset, offset + 6 ));
            row6.add(new Edge(nodes.get(5), nodes.get(0), tram, offset, offset + 9 ));
            row6.add(new Edge(nodes.get(5), nodes.get(1), tram, offset, offset + 12));
            row6.add(new Edge(nodes.get(5), nodes.get(2), tram, offset, offset + 16));
            row6.add(new Edge(nodes.get(5), nodes.get(3), tram, offset, offset + 20));
            row7.add(new Edge(nodes.get(6), nodes.get(7), tram, offset, offset + 3 ));
            row7.add(new Edge(nodes.get(6), nodes.get(0), tram, offset, offset + 6 ));
            row7.add(new Edge(nodes.get(6), nodes.get(1), tram, offset, offset + 9 ));
            row7.add(new Edge(nodes.get(6), nodes.get(2), tram, offset, offset + 13));
            row7.add(new Edge(nodes.get(6), nodes.get(3), tram, offset, offset + 17));
            row8.add(new Edge(nodes.get(7), nodes.get(0), tram, offset, offset + 3 ));
            row8.add(new Edge(nodes.get(7), nodes.get(1), tram, offset, offset + 6 ));
            row8.add(new Edge(nodes.get(7), nodes.get(2), tram, offset, offset + 10));
            row8.add(new Edge(nodes.get(7), nodes.get(3), tram, offset, offset + 14));
            row1.add(new Edge(nodes.get(0), nodes.get(1), tram, offset, offset + 3 ));
            row1.add(new Edge(nodes.get(0), nodes.get(2), tram, offset, offset + 7 ));
            row1.add(new Edge(nodes.get(0), nodes.get(3), tram, offset, offset + 11));
            row2.add(new Edge(nodes.get(1), nodes.get(2), tram, offset, offset + 4 ));
            row2.add(new Edge(nodes.get(1), nodes.get(3), tram, offset, offset + 8 ));
            row3.add(new Edge(nodes.get(2), nodes.get(3), tram, offset, offset + 4 ));

            row4.add(new Edge(nodes.get(3), nodes.get(2), tram, offset + offset2, offset + offset2 + 4 ));
            row4.add(new Edge(nodes.get(3), nodes.get(1), tram, offset + offset2, offset + offset2 + 8 ));
            row4.add(new Edge(nodes.get(3), nodes.get(0), tram, offset + offset2, offset + offset2 + 11));
            row4.add(new Edge(nodes.get(3), nodes.get(7), tram, offset + offset2, offset + offset2 + 14));
            row4.add(new Edge(nodes.get(3), nodes.get(6), tram, offset + offset2, offset + offset2 + 17));
            row4.add(new Edge(nodes.get(3), nodes.get(5), tram, offset + offset2, offset + offset2 + 20));
            row4.add(new Edge(nodes.get(3), nodes.get(4), tram, offset + offset2, offset + offset2 + 23));
            row3.add(new Edge(nodes.get(2), nodes.get(1), tram, offset + offset2, offset + offset2 + 4 ));
            row3.add(new Edge(nodes.get(2), nodes.get(0), tram, offset + offset2, offset + offset2 + 7 ));
            row3.add(new Edge(nodes.get(2), nodes.get(7), tram, offset + offset2, offset + offset2 + 10));
            row3.add(new Edge(nodes.get(2), nodes.get(6), tram, offset + offset2, offset + offset2 + 13));
            row3.add(new Edge(nodes.get(2), nodes.get(5), tram, offset + offset2, offset + offset2 + 16));
            row3.add(new Edge(nodes.get(2), nodes.get(4), tram, offset + offset2, offset + offset2 + 19));
            row2.add(new Edge(nodes.get(1), nodes.get(0), tram, offset + offset2, offset + offset2 + 3 ));
            row2.add(new Edge(nodes.get(1), nodes.get(7), tram, offset + offset2, offset + offset2 + 6 ));
            row2.add(new Edge(nodes.get(1), nodes.get(6), tram, offset + offset2, offset + offset2 + 9 ));
            row2.add(new Edge(nodes.get(1), nodes.get(5), tram, offset + offset2, offset + offset2 + 12));
            row2.add(new Edge(nodes.get(1), nodes.get(4), tram, offset + offset2, offset + offset2 + 15));
            row1.add(new Edge(nodes.get(0), nodes.get(7), tram, offset + offset2, offset + offset2 + 3 ));
            row1.add(new Edge(nodes.get(0), nodes.get(6), tram, offset + offset2, offset + offset2 + 6 ));
            row1.add(new Edge(nodes.get(0), nodes.get(5), tram, offset + offset2, offset + offset2 + 9 ));
            row1.add(new Edge(nodes.get(0), nodes.get(4), tram, offset + offset2, offset + offset2 + 12));
            row8.add(new Edge(nodes.get(7), nodes.get(6), tram, offset + offset2, offset + offset2 + 3 ));
            row8.add(new Edge(nodes.get(7), nodes.get(5), tram, offset + offset2, offset + offset2 + 6 ));
            row8.add(new Edge(nodes.get(7), nodes.get(4), tram, offset + offset2, offset + offset2 + 9 ));
            row7.add(new Edge(nodes.get(6), nodes.get(5), tram, offset + offset2, offset + offset2 + 3 ));
            row7.add(new Edge(nodes.get(6), nodes.get(4), tram, offset + offset2, offset + offset2 + 6 ));
            row6.add(new Edge(nodes.get(5), nodes.get(4), tram, offset + offset2, offset + offset2 + 3 ));
        }
        // --------------------------------------------------------------

        // --- TRAMWAJ LINIA 2 ------------------------------------------
        // 5 > 6 > 7 > 13 > 17 > 20
        offset1 = 5*60+3;
        offset2 = 10;
        interval = 20;
        last_one = 22*60;
        for(Integer offset = offset1; offset < last_one; offset+=interval) {

            row5.add(new Edge(nodes.get(4),   nodes.get(5),  tram, offset, offset + 3 ));
            row5.add(new Edge(nodes.get(4),   nodes.get(6),  tram, offset, offset + 6 ));
            row5.add(new Edge(nodes.get(4),   nodes.get(12), tram, offset, offset + 10));
            row5.add(new Edge(nodes.get(4),   nodes.get(16), tram, offset, offset + 14));
            row5.add(new Edge(nodes.get(4),   nodes.get(19), tram, offset, offset + 17));
            row6.add(new Edge(nodes.get(5),   nodes.get(6),  tram, offset, offset + 3 ));
            row6.add(new Edge(nodes.get(5),   nodes.get(12), tram, offset, offset + 7 ));
            row6.add(new Edge(nodes.get(5),   nodes.get(16), tram, offset, offset + 11));
            row6.add(new Edge(nodes.get(5),   nodes.get(19), tram, offset, offset + 14));
            row7.add(new Edge(nodes.get(6),   nodes.get(12), tram, offset, offset + 4 ));
            row7.add(new Edge(nodes.get(6),   nodes.get(16), tram, offset, offset + 8 ));
            row7.add(new Edge(nodes.get(6),   nodes.get(19), tram, offset, offset + 11));
            row13.add(new Edge(nodes.get(12), nodes.get(16), tram, offset, offset + 4 ));
            row13.add(new Edge(nodes.get(12), nodes.get(19), tram, offset, offset + 7 ));
            row17.add(new Edge(nodes.get(16), nodes.get(19), tram, offset, offset + 3 ));

            row20.add(new Edge(nodes.get(19), nodes.get(16), tram, offset + offset2, offset + offset2 + 3 ));
            row20.add(new Edge(nodes.get(19), nodes.get(12), tram, offset + offset2, offset + offset2 + 7 ));
            row20.add(new Edge(nodes.get(19), nodes.get(6),  tram, offset + offset2, offset + offset2 + 11));
            row20.add(new Edge(nodes.get(19), nodes.get(5),  tram, offset + offset2, offset + offset2 + 14));
            row20.add(new Edge(nodes.get(19), nodes.get(4),  tram, offset + offset2, offset + offset2 + 17));
            row17.add(new Edge(nodes.get(16), nodes.get(12), tram, offset + offset2, offset + offset2 + 4 ));
            row17.add(new Edge(nodes.get(16), nodes.get(6),  tram, offset + offset2, offset + offset2 + 8 ));
            row17.add(new Edge(nodes.get(16), nodes.get(5),  tram, offset + offset2, offset + offset2 + 11));
            row17.add(new Edge(nodes.get(16), nodes.get(4),  tram, offset + offset2, offset + offset2 + 14));
            row13.add(new Edge(nodes.get(12), nodes.get(6),  tram, offset + offset2, offset + offset2 + 4 ));
            row13.add(new Edge(nodes.get(12), nodes.get(5),  tram, offset + offset2, offset + offset2 + 7 ));
            row13.add(new Edge(nodes.get(12), nodes.get(4),  tram, offset + offset2, offset + offset2 + 10));
            row7.add(new Edge(nodes.get(6),   nodes.get(5),  tram, offset + offset2, offset + offset2 + 3 ));
            row7.add(new Edge(nodes.get(6),   nodes.get(4),  tram, offset + offset2, offset + offset2 + 6 ));
            row6.add(new Edge(nodes.get(5),   nodes.get(4),  tram, offset + offset2, offset + offset2 + 3 ));
        }


        // --------------------------------------------------------------

        // --- TRAMWAJ LINIA 3 ------------------------------------------
        // 20 > 17 > 13 > 7 > 8 > 1 > 2 > 3 > 4
        offset1 = 5*60+5;
        offset2 = 13;
        interval = 20;
        last_one = 22*60;
        for(Integer offset = offset1; offset < last_one; offset+=interval) {

            row20.add(new Edge(nodes.get(19), nodes.get(16), tram, offset, offset + 3 ));
            row20.add(new Edge(nodes.get(19), nodes.get(12), tram, offset, offset + 7 ));
            row20.add(new Edge(nodes.get(19), nodes.get(6),  tram, offset, offset + 11));
            row20.add(new Edge(nodes.get(19), nodes.get(7),  tram, offset, offset + 14));
            row20.add(new Edge(nodes.get(19), nodes.get(0),  tram, offset, offset + 17));
            row20.add(new Edge(nodes.get(19), nodes.get(1),  tram, offset, offset + 20));
            row20.add(new Edge(nodes.get(19), nodes.get(2),  tram, offset, offset + 24));
            row20.add(new Edge(nodes.get(19), nodes.get(3),  tram, offset, offset + 28));
            row17.add(new Edge(nodes.get(16), nodes.get(12), tram, offset, offset + 4 ));
            row17.add(new Edge(nodes.get(16), nodes.get(6),  tram, offset, offset + 8 ));
            row17.add(new Edge(nodes.get(16), nodes.get(7),  tram, offset, offset + 11));
            row17.add(new Edge(nodes.get(16), nodes.get(0),  tram, offset, offset + 14));
            row17.add(new Edge(nodes.get(16), nodes.get(1),  tram, offset, offset + 17));
            row17.add(new Edge(nodes.get(16), nodes.get(2),  tram, offset, offset + 21));
            row17.add(new Edge(nodes.get(16), nodes.get(3),  tram, offset, offset + 25));
            row13.add(new Edge(nodes.get(12), nodes.get(6),  tram, offset, offset + 4 ));
            row13.add(new Edge(nodes.get(12), nodes.get(7),  tram, offset, offset + 7 ));
            row13.add(new Edge(nodes.get(12), nodes.get(0),  tram, offset, offset + 10));
            row13.add(new Edge(nodes.get(12), nodes.get(1),  tram, offset, offset + 13));
            row13.add(new Edge(nodes.get(12), nodes.get(2),  tram, offset, offset + 17));
            row13.add(new Edge(nodes.get(12), nodes.get(3),  tram, offset, offset + 21));
            row7.add(new Edge(nodes.get(6),   nodes.get(7),  tram, offset, offset + 3 ));
            row7.add(new Edge(nodes.get(6),   nodes.get(0),  tram, offset, offset + 6 ));
            row7.add(new Edge(nodes.get(6),   nodes.get(1),  tram, offset, offset + 9 ));
            row7.add(new Edge(nodes.get(6),   nodes.get(2),  tram, offset, offset + 13));
            row7.add(new Edge(nodes.get(6),   nodes.get(3),  tram, offset, offset + 17));
            row8.add(new Edge(nodes.get(7),   nodes.get(0),  tram, offset, offset + 3 ));
            row8.add(new Edge(nodes.get(7),   nodes.get(1),  tram, offset, offset + 6 ));
            row8.add(new Edge(nodes.get(7),   nodes.get(2),  tram, offset, offset + 10));
            row8.add(new Edge(nodes.get(7),   nodes.get(3),  tram, offset, offset + 14));
            row1.add(new Edge(nodes.get(0),   nodes.get(1),  tram, offset, offset + 3 ));
            row1.add(new Edge(nodes.get(0),   nodes.get(2),  tram, offset, offset + 7 ));
            row1.add(new Edge(nodes.get(0),   nodes.get(3),  tram, offset, offset + 11));
            row2.add(new Edge(nodes.get(1),   nodes.get(2),  tram, offset, offset + 4 ));
            row2.add(new Edge(nodes.get(1),   nodes.get(3),  tram, offset, offset + 8 ));
            row3.add(new Edge(nodes.get(2),   nodes.get(3),  tram, offset, offset + 4 ));

            row4.add(new Edge(nodes.get(3),   nodes.get(2),  tram, offset + offset2, offset + offset2 +  4));
            row4.add(new Edge(nodes.get(3),   nodes.get(1),  tram, offset + offset2, offset + offset2 +  8));
            row4.add(new Edge(nodes.get(3),   nodes.get(0),  tram, offset + offset2, offset + offset2 + 11));
            row4.add(new Edge(nodes.get(3),   nodes.get(7),  tram, offset + offset2, offset + offset2 + 14));
            row4.add(new Edge(nodes.get(3),   nodes.get(6),  tram, offset + offset2, offset + offset2 + 17));
            row4.add(new Edge(nodes.get(3),   nodes.get(12), tram, offset + offset2, offset + offset2 + 21));
            row4.add(new Edge(nodes.get(3),   nodes.get(16), tram, offset + offset2, offset + offset2 + 25));
            row4.add(new Edge(nodes.get(3),   nodes.get(19), tram, offset + offset2, offset + offset2 + 28));
            row3.add(new Edge(nodes.get(2),   nodes.get(1),  tram, offset + offset2, offset + offset2 +  4));
            row3.add(new Edge(nodes.get(2),   nodes.get(0),  tram, offset + offset2, offset + offset2 +  7));
            row3.add(new Edge(nodes.get(2),   nodes.get(7),  tram, offset + offset2, offset + offset2 + 10));
            row3.add(new Edge(nodes.get(2),   nodes.get(6),  tram, offset + offset2, offset + offset2 + 13));
            row3.add(new Edge(nodes.get(2),   nodes.get(12), tram, offset + offset2, offset + offset2 + 17));
            row3.add(new Edge(nodes.get(2),   nodes.get(16), tram, offset + offset2, offset + offset2 + 21));
            row3.add(new Edge(nodes.get(2),   nodes.get(19), tram, offset + offset2, offset + offset2 + 24));
            row2.add(new Edge(nodes.get(1),   nodes.get(0),  tram, offset + offset2, offset + offset2 +  3));
            row2.add(new Edge(nodes.get(1),   nodes.get(7),  tram, offset + offset2, offset + offset2 +  6));
            row2.add(new Edge(nodes.get(1),   nodes.get(6),  tram, offset + offset2, offset + offset2 +  9));
            row2.add(new Edge(nodes.get(1),   nodes.get(12), tram, offset + offset2, offset + offset2 + 13));
            row2.add(new Edge(nodes.get(1),   nodes.get(16), tram, offset + offset2, offset + offset2 + 17));
            row2.add(new Edge(nodes.get(1),   nodes.get(19), tram, offset + offset2, offset + offset2 + 20));
            row1.add(new Edge(nodes.get(0),   nodes.get(7),  tram, offset + offset2, offset + offset2 +  3));
            row1.add(new Edge(nodes.get(0),   nodes.get(6),  tram, offset + offset2, offset + offset2 +  6));
            row1.add(new Edge(nodes.get(0),   nodes.get(12), tram, offset + offset2, offset + offset2 + 10));
            row1.add(new Edge(nodes.get(0),   nodes.get(16), tram, offset + offset2, offset + offset2 + 14));
            row1.add(new Edge(nodes.get(0),   nodes.get(19), tram, offset + offset2, offset + offset2 + 17));
            row8.add(new Edge(nodes.get(7),   nodes.get(6),  tram, offset + offset2, offset + offset2 +  3));
            row8.add(new Edge(nodes.get(7),   nodes.get(12), tram, offset + offset2, offset + offset2 +  7));
            row8.add(new Edge(nodes.get(7),   nodes.get(16), tram, offset + offset2, offset + offset2 + 11));
            row8.add(new Edge(nodes.get(7),   nodes.get(19), tram, offset + offset2, offset + offset2 + 14));
            row7.add(new Edge(nodes.get(6),   nodes.get(12), tram, offset + offset2, offset + offset2 +  4));
            row7.add(new Edge(nodes.get(6),   nodes.get(16), tram, offset + offset2, offset + offset2 +  8));
            row7.add(new Edge(nodes.get(6),   nodes.get(19), tram, offset + offset2, offset + offset2 + 11));
            row13.add(new Edge(nodes.get(12), nodes.get(16), tram, offset + offset2, offset + offset2 +  4));
            row13.add(new Edge(nodes.get(12), nodes.get(19), tram, offset + offset2, offset + offset2 +  7));
            row17.add(new Edge(nodes.get(16), nodes.get(19), tram, offset + offset2, offset + offset2 +  3));
        }
        // --------------------------------------------------------------

        // --- BUS LINIA 1 ------------------------------------------
        // 9 > 8 > 7 > 6 > 5 > 11 > 15 > 16 > 17 > 18
        offset1 = 5*60;
        offset2 = 12;
        interval = 15;
        last_one = 22*60;
        for(Integer offset = offset1; offset < last_one; offset+=interval) {

            row9.add(new Edge(nodes.get(8),   nodes.get(7),  bus, offset, offset + 3 ));
            row9.add(new Edge(nodes.get(8),   nodes.get(6),  bus, offset, offset + 6 ));
            row9.add(new Edge(nodes.get(8),   nodes.get(5),  bus, offset, offset + 9 ));
            row9.add(new Edge(nodes.get(8),   nodes.get(4),  bus, offset, offset + 12));
            row9.add(new Edge(nodes.get(8),   nodes.get(10), bus, offset, offset + 16));
            row9.add(new Edge(nodes.get(8),   nodes.get(14), bus, offset, offset + 20));
            row9.add(new Edge(nodes.get(8),   nodes.get(15), bus, offset, offset + 23));
            row9.add(new Edge(nodes.get(8),   nodes.get(16), bus, offset, offset + 26));
            row9.add(new Edge(nodes.get(8),   nodes.get(17), bus, offset, offset + 29));
            row8.add(new Edge(nodes.get(7),   nodes.get(6),  bus, offset, offset + 3 ));
            row8.add(new Edge(nodes.get(7),   nodes.get(5),  bus, offset, offset + 6 ));
            row8.add(new Edge(nodes.get(7),   nodes.get(4),  bus, offset, offset + 9 ));
            row8.add(new Edge(nodes.get(7),   nodes.get(10), bus, offset, offset + 13));
            row8.add(new Edge(nodes.get(7),   nodes.get(14), bus, offset, offset + 17));
            row8.add(new Edge(nodes.get(7),   nodes.get(15), bus, offset, offset + 20));
            row8.add(new Edge(nodes.get(7),   nodes.get(16), bus, offset, offset + 23));
            row8.add(new Edge(nodes.get(7),   nodes.get(17), bus, offset, offset + 26));
            row7.add(new Edge(nodes.get(6),   nodes.get(5),  bus, offset, offset + 3 ));
            row7.add(new Edge(nodes.get(6),   nodes.get(4),  bus, offset, offset + 6 ));
            row7.add(new Edge(nodes.get(6),   nodes.get(10), bus, offset, offset + 10));
            row7.add(new Edge(nodes.get(6),   nodes.get(14), bus, offset, offset + 14));
            row7.add(new Edge(nodes.get(6),   nodes.get(15), bus, offset, offset + 17));
            row7.add(new Edge(nodes.get(6),   nodes.get(16), bus, offset, offset + 20));
            row7.add(new Edge(nodes.get(6),   nodes.get(17), bus, offset, offset + 23));
            row6.add(new Edge(nodes.get(5),   nodes.get(4),  bus, offset, offset + 3 ));
            row6.add(new Edge(nodes.get(5),   nodes.get(10), bus, offset, offset + 7 ));
            row6.add(new Edge(nodes.get(5),   nodes.get(14), bus, offset, offset + 11));
            row6.add(new Edge(nodes.get(5),   nodes.get(15), bus, offset, offset + 14));
            row6.add(new Edge(nodes.get(5),   nodes.get(16), bus, offset, offset + 17));
            row6.add(new Edge(nodes.get(5),   nodes.get(17), bus, offset, offset + 20));
            row5.add(new Edge(nodes.get(4),   nodes.get(10), bus, offset, offset + 4 ));
            row5.add(new Edge(nodes.get(4),   nodes.get(14), bus, offset, offset + 8 ));
            row5.add(new Edge(nodes.get(4),   nodes.get(15), bus, offset, offset + 11));
            row5.add(new Edge(nodes.get(4),   nodes.get(16), bus, offset, offset + 14));
            row5.add(new Edge(nodes.get(4),   nodes.get(17), bus, offset, offset + 17));
            row11.add(new Edge(nodes.get(10), nodes.get(14), bus, offset, offset + 4 ));
            row11.add(new Edge(nodes.get(10), nodes.get(15), bus, offset, offset + 7 ));
            row11.add(new Edge(nodes.get(10), nodes.get(16), bus, offset, offset + 10));
            row11.add(new Edge(nodes.get(10), nodes.get(17), bus, offset, offset + 13));
            row15.add(new Edge(nodes.get(14), nodes.get(15), bus, offset, offset + 3 ));
            row15.add(new Edge(nodes.get(14), nodes.get(16), bus, offset, offset + 6 ));
            row15.add(new Edge(nodes.get(14), nodes.get(17), bus, offset, offset + 9 ));
            row16.add(new Edge(nodes.get(15), nodes.get(16), bus, offset, offset + 3 ));
            row16.add(new Edge(nodes.get(15), nodes.get(17), bus, offset, offset + 6 ));
            row17.add(new Edge(nodes.get(16), nodes.get(17), bus, offset, offset + 3 ));

            row18.add(new Edge(nodes.get(17), nodes.get(16), bus, offset + offset2, offset + offset2 + 3 ));
            row18.add(new Edge(nodes.get(17), nodes.get(15), bus, offset + offset2, offset + offset2 + 6 ));
            row18.add(new Edge(nodes.get(17), nodes.get(14), bus, offset + offset2, offset + offset2 + 9 ));
            row18.add(new Edge(nodes.get(17), nodes.get(10), bus, offset + offset2, offset + offset2 + 13));
            row18.add(new Edge(nodes.get(17), nodes.get(4),  bus, offset + offset2, offset + offset2 + 17));
            row18.add(new Edge(nodes.get(17), nodes.get(5),  bus, offset + offset2, offset + offset2 + 20));
            row18.add(new Edge(nodes.get(17), nodes.get(6),  bus, offset + offset2, offset + offset2 + 23));
            row18.add(new Edge(nodes.get(17), nodes.get(7),  bus, offset + offset2, offset + offset2 + 26));
            row18.add(new Edge(nodes.get(17), nodes.get(8),  bus, offset + offset2, offset + offset2 + 29));
            row17.add(new Edge(nodes.get(16), nodes.get(15), bus, offset + offset2, offset + offset2 + 3 ));
            row17.add(new Edge(nodes.get(16), nodes.get(14), bus, offset + offset2, offset + offset2 + 6 ));
            row17.add(new Edge(nodes.get(16), nodes.get(10), bus, offset + offset2, offset + offset2 + 10));
            row17.add(new Edge(nodes.get(16), nodes.get(4),  bus, offset + offset2, offset + offset2 + 14));
            row17.add(new Edge(nodes.get(16), nodes.get(5),  bus, offset + offset2, offset + offset2 + 17));
            row17.add(new Edge(nodes.get(16), nodes.get(6),  bus, offset + offset2, offset + offset2 + 20));
            row17.add(new Edge(nodes.get(16), nodes.get(7),  bus, offset + offset2, offset + offset2 + 23));
            row17.add(new Edge(nodes.get(16), nodes.get(8),  bus, offset + offset2, offset + offset2 + 26));
            row16.add(new Edge(nodes.get(15), nodes.get(14), bus, offset + offset2, offset + offset2 + 3 ));
            row16.add(new Edge(nodes.get(15), nodes.get(10), bus, offset + offset2, offset + offset2 + 7 ));
            row16.add(new Edge(nodes.get(15), nodes.get(4),  bus, offset + offset2, offset + offset2 + 11));
            row16.add(new Edge(nodes.get(15), nodes.get(5),  bus, offset + offset2, offset + offset2 + 14));
            row16.add(new Edge(nodes.get(15), nodes.get(6),  bus, offset + offset2, offset + offset2 + 17));
            row16.add(new Edge(nodes.get(15), nodes.get(7),  bus, offset + offset2, offset + offset2 + 20));
            row16.add(new Edge(nodes.get(15), nodes.get(8),  bus, offset + offset2, offset + offset2 + 23));
            row15.add(new Edge(nodes.get(14), nodes.get(10), bus, offset + offset2, offset + offset2 + 4 ));
            row15.add(new Edge(nodes.get(14), nodes.get(4),  bus, offset + offset2, offset + offset2 + 8 ));
            row15.add(new Edge(nodes.get(14), nodes.get(5),  bus, offset + offset2, offset + offset2 + 11));
            row15.add(new Edge(nodes.get(14), nodes.get(6),  bus, offset + offset2, offset + offset2 + 14));
            row15.add(new Edge(nodes.get(14), nodes.get(7),  bus, offset + offset2, offset + offset2 + 17));
            row15.add(new Edge(nodes.get(14), nodes.get(8),  bus, offset + offset2, offset + offset2 + 20));
            row11.add(new Edge(nodes.get(10), nodes.get(4),  bus, offset + offset2, offset + offset2 + 4 ));
            row11.add(new Edge(nodes.get(10), nodes.get(5),  bus, offset + offset2, offset + offset2 + 7 ));
            row11.add(new Edge(nodes.get(10), nodes.get(6),  bus, offset + offset2, offset + offset2 + 10));
            row11.add(new Edge(nodes.get(10), nodes.get(7),  bus, offset + offset2, offset + offset2 + 13));
            row11.add(new Edge(nodes.get(10), nodes.get(8),  bus, offset + offset2, offset + offset2 + 16));
            row5.add(new Edge(nodes.get(4),   nodes.get(5),  bus, offset + offset2, offset + offset2 + 3 ));
            row5.add(new Edge(nodes.get(4),   nodes.get(6),  bus, offset + offset2, offset + offset2 + 6 ));
            row5.add(new Edge(nodes.get(4),   nodes.get(7),  bus, offset + offset2, offset + offset2 + 9 ));
            row5.add(new Edge(nodes.get(4),   nodes.get(8),  bus, offset + offset2, offset + offset2 + 12));
            row6.add(new Edge(nodes.get(5),   nodes.get(6),  bus, offset + offset2, offset + offset2 + 3 ));
            row6.add(new Edge(nodes.get(5),   nodes.get(7),  bus, offset + offset2, offset + offset2 + 6 ));
            row6.add(new Edge(nodes.get(5),   nodes.get(8),  bus, offset + offset2, offset + offset2 + 9 ));
            row7.add(new Edge(nodes.get(6),   nodes.get(7),  bus, offset + offset2, offset + offset2 + 3 ));
            row7.add(new Edge(nodes.get(6),   nodes.get(8),  bus, offset + offset2, offset + offset2 + 6 ));
            row8.add(new Edge(nodes.get(7),   nodes.get(8),  bus, offset + offset2, offset + offset2 + 3 ));
        }
        // --------------------------------------------------------------

        // --- BUS LINIA 2 ------------------------------------------
        // 9 > 8 > 7 > 6 > 12 > 16 > 19 > 20
        offset1 = 5*60+5;
        offset2 = 15;
        interval = 15;
        last_one = 22*60;
        for(Integer offset = offset1; offset < last_one; offset+=interval) {

            row9.add(new Edge(nodes.get(8),   nodes.get(7),  bus, offset, offset + 3 ));
            row9.add(new Edge(nodes.get(8),   nodes.get(6),  bus, offset, offset + 6 ));
            row9.add(new Edge(nodes.get(8),   nodes.get(5),  bus, offset, offset + 9 ));
            row9.add(new Edge(nodes.get(8),   nodes.get(11), bus, offset, offset + 13));
            row9.add(new Edge(nodes.get(8),   nodes.get(15), bus, offset, offset + 17));
            row9.add(new Edge(nodes.get(8),   nodes.get(18), bus, offset, offset + 20));
            row9.add(new Edge(nodes.get(8),   nodes.get(19), bus, offset, offset + 23));
            row8.add(new Edge(nodes.get(7),   nodes.get(6),  bus, offset, offset + 3 ));
            row8.add(new Edge(nodes.get(7),   nodes.get(5),  bus, offset, offset + 6 ));
            row8.add(new Edge(nodes.get(7),   nodes.get(11), bus, offset, offset + 10));
            row8.add(new Edge(nodes.get(7),   nodes.get(15), bus, offset, offset + 14));
            row8.add(new Edge(nodes.get(7),   nodes.get(18), bus, offset, offset + 17));
            row8.add(new Edge(nodes.get(7),   nodes.get(19), bus, offset, offset + 20));
            row7.add(new Edge(nodes.get(6),   nodes.get(5),  bus, offset, offset + 3 ));
            row7.add(new Edge(nodes.get(6),   nodes.get(11), bus, offset, offset + 7 ));
            row7.add(new Edge(nodes.get(6),   nodes.get(15), bus, offset, offset + 11));
            row7.add(new Edge(nodes.get(6),   nodes.get(18), bus, offset, offset + 14));
            row7.add(new Edge(nodes.get(6),   nodes.get(19), bus, offset, offset + 17));
            row6.add(new Edge(nodes.get(5),   nodes.get(11), bus, offset, offset + 4 ));
            row6.add(new Edge(nodes.get(5),   nodes.get(15), bus, offset, offset + 8 ));
            row6.add(new Edge(nodes.get(5),   nodes.get(18), bus, offset, offset + 11));
            row6.add(new Edge(nodes.get(5),   nodes.get(19), bus, offset, offset + 14));
            row12.add(new Edge(nodes.get(11), nodes.get(15), bus, offset, offset + 4 ));
            row12.add(new Edge(nodes.get(11), nodes.get(18), bus, offset, offset + 7 ));
            row12.add(new Edge(nodes.get(11), nodes.get(19), bus, offset, offset + 10));
            row16.add(new Edge(nodes.get(15), nodes.get(18), bus, offset, offset + 3 ));
            row16.add(new Edge(nodes.get(15), nodes.get(19), bus, offset, offset + 6 ));
            row19.add(new Edge(nodes.get(18), nodes.get(19), bus, offset, offset + 3 ));

            row20.add(new Edge(nodes.get(19), nodes.get(18), bus, offset + offset2, offset + offset2 + 3 ));
            row20.add(new Edge(nodes.get(19), nodes.get(15), bus, offset + offset2, offset + offset2 + 6 ));
            row20.add(new Edge(nodes.get(19), nodes.get(11), bus, offset + offset2, offset + offset2 + 10));
            row20.add(new Edge(nodes.get(19), nodes.get(5),  bus, offset + offset2, offset + offset2 + 14));
            row20.add(new Edge(nodes.get(19), nodes.get(6),  bus, offset + offset2, offset + offset2 + 17));
            row20.add(new Edge(nodes.get(19), nodes.get(7),  bus, offset + offset2, offset + offset2 + 20));
            row20.add(new Edge(nodes.get(19), nodes.get(8),  bus, offset + offset2, offset + offset2 + 23));
            row19.add(new Edge(nodes.get(18), nodes.get(15), bus, offset + offset2, offset + offset2 + 3 ));
            row19.add(new Edge(nodes.get(18), nodes.get(11), bus, offset + offset2, offset + offset2 + 7 ));
            row19.add(new Edge(nodes.get(18), nodes.get(5),  bus, offset + offset2, offset + offset2 + 11));
            row19.add(new Edge(nodes.get(18), nodes.get(6),  bus, offset + offset2, offset + offset2 + 14));
            row19.add(new Edge(nodes.get(18), nodes.get(7),  bus, offset + offset2, offset + offset2 + 17));
            row19.add(new Edge(nodes.get(18), nodes.get(8),  bus, offset + offset2, offset + offset2 + 20));
            row16.add(new Edge(nodes.get(15), nodes.get(11), bus, offset + offset2, offset + offset2 + 4 ));
            row16.add(new Edge(nodes.get(15), nodes.get(5),  bus, offset + offset2, offset + offset2 + 8 ));
            row16.add(new Edge(nodes.get(15), nodes.get(6),  bus, offset + offset2, offset + offset2 + 11));
            row16.add(new Edge(nodes.get(15), nodes.get(7),  bus, offset + offset2, offset + offset2 + 14));
            row16.add(new Edge(nodes.get(15), nodes.get(8),  bus, offset + offset2, offset + offset2 + 17));
            row12.add(new Edge(nodes.get(11), nodes.get(5),  bus, offset + offset2, offset + offset2 + 4 ));
            row12.add(new Edge(nodes.get(11), nodes.get(6),  bus, offset + offset2, offset + offset2 + 7 ));
            row12.add(new Edge(nodes.get(11), nodes.get(7),  bus, offset + offset2, offset + offset2 + 10));
            row12.add(new Edge(nodes.get(11), nodes.get(8),  bus, offset + offset2, offset + offset2 + 13));
            row6.add(new Edge(nodes.get(5),   nodes.get(6),  bus, offset + offset2, offset + offset2 + 3 ));
            row6.add(new Edge(nodes.get(5),   nodes.get(7),  bus, offset + offset2, offset + offset2 + 6 ));
            row6.add(new Edge(nodes.get(5),   nodes.get(8),  bus, offset + offset2, offset + offset2 + 9 ));
            row7.add(new Edge(nodes.get(6),   nodes.get(7),  bus, offset + offset2, offset + offset2 + 3 ));
            row7.add(new Edge(nodes.get(6),   nodes.get(8),  bus, offset + offset2, offset + offset2 + 6 ));
            row8.add(new Edge(nodes.get(7),   nodes.get(8),  bus, offset + offset2, offset + offset2 + 3 ));
        }
        // --------------------------------------------------------------

        // --- BUS LINIA 3 ------------------------------------------
        // 1 > 8 > 14 > 13 > 12 > 11 > 10
        offset1 = 7*60;
        offset2 = 5;
        interval = 25;
        last_one = 20*60;
        for(Integer offset = offset1; offset < last_one; offset+=interval) {

            row1.add(new Edge(nodes.get(0),   nodes.get(7),  bus, offset, offset + 3 ));
            row1.add(new Edge(nodes.get(0),   nodes.get(13), bus, offset, offset + 7 ));
            row1.add(new Edge(nodes.get(0),   nodes.get(12), bus, offset, offset + 10));
            row1.add(new Edge(nodes.get(0),   nodes.get(11), bus, offset, offset + 13));
            row1.add(new Edge(nodes.get(0),   nodes.get(10), bus, offset, offset + 16));
            row1.add(new Edge(nodes.get(0),   nodes.get(9),  bus, offset, offset + 19));
            row8.add(new Edge(nodes.get(7),   nodes.get(13), bus, offset, offset + 4 ));
            row8.add(new Edge(nodes.get(7),   nodes.get(12), bus, offset, offset + 7 ));
            row8.add(new Edge(nodes.get(7),   nodes.get(11), bus, offset, offset + 10));
            row8.add(new Edge(nodes.get(7),   nodes.get(10), bus, offset, offset + 13));
            row8.add(new Edge(nodes.get(7),   nodes.get(9),  bus, offset, offset + 16));
            row14.add(new Edge(nodes.get(13), nodes.get(12), bus, offset, offset + 3 ));
            row14.add(new Edge(nodes.get(13), nodes.get(11), bus, offset, offset + 6 ));
            row14.add(new Edge(nodes.get(13), nodes.get(10), bus, offset, offset + 9 ));
            row14.add(new Edge(nodes.get(13), nodes.get(9),  bus, offset, offset + 12));
            row13.add(new Edge(nodes.get(12), nodes.get(11), bus, offset, offset + 3 ));
            row13.add(new Edge(nodes.get(12), nodes.get(10), bus, offset, offset + 6 ));
            row13.add(new Edge(nodes.get(12), nodes.get(9),  bus, offset, offset + 9 ));
            row12.add(new Edge(nodes.get(11), nodes.get(10), bus, offset, offset + 3 ));
            row12.add(new Edge(nodes.get(11), nodes.get(9),  bus, offset, offset + 6 ));
            row11.add(new Edge(nodes.get(10), nodes.get(9),  bus, offset, offset + 3 ));

            row10.add(new Edge(nodes.get(9),  nodes.get(10), bus, offset + offset2, offset + offset2 + 3 ));
            row10.add(new Edge(nodes.get(9),  nodes.get(11), bus, offset + offset2, offset + offset2 + 6 ));
            row10.add(new Edge(nodes.get(9),  nodes.get(12), bus, offset + offset2, offset + offset2 + 9 ));
            row10.add(new Edge(nodes.get(9),  nodes.get(13), bus, offset + offset2, offset + offset2 + 12));
            row10.add(new Edge(nodes.get(9),  nodes.get(7),  bus, offset + offset2, offset + offset2 + 16));
            row10.add(new Edge(nodes.get(9),  nodes.get(0),  bus, offset + offset2, offset + offset2 + 19));
            row11.add(new Edge(nodes.get(10), nodes.get(11), bus, offset + offset2, offset + offset2 + 3 ));
            row11.add(new Edge(nodes.get(10), nodes.get(12), bus, offset + offset2, offset + offset2 + 6 ));
            row11.add(new Edge(nodes.get(10), nodes.get(13), bus, offset + offset2, offset + offset2 + 9 ));
            row11.add(new Edge(nodes.get(10), nodes.get(7),  bus, offset + offset2, offset + offset2 + 13));
            row11.add(new Edge(nodes.get(10), nodes.get(0),  bus, offset + offset2, offset + offset2 + 16));
            row12.add(new Edge(nodes.get(11), nodes.get(12), bus, offset + offset2, offset + offset2 + 3 ));
            row12.add(new Edge(nodes.get(11), nodes.get(13), bus, offset + offset2, offset + offset2 + 6 ));
            row12.add(new Edge(nodes.get(11), nodes.get(7),  bus, offset + offset2, offset + offset2 + 10));
            row12.add(new Edge(nodes.get(11), nodes.get(0),  bus, offset + offset2, offset + offset2 + 13));
            row13.add(new Edge(nodes.get(12), nodes.get(13), bus, offset + offset2, offset + offset2 + 3 ));
            row13.add(new Edge(nodes.get(12), nodes.get(7),  bus, offset + offset2, offset + offset2 + 7 ));
            row13.add(new Edge(nodes.get(12), nodes.get(0),  bus, offset + offset2, offset + offset2 + 10));
            row14.add(new Edge(nodes.get(13), nodes.get(7),  bus, offset + offset2, offset + offset2 + 4 ));
            row14.add(new Edge(nodes.get(13), nodes.get(0),  bus, offset + offset2, offset + offset2 + 7 ));
            row8.add(new Edge(nodes.get(7),   nodes.get(0),  bus, offset + offset2, offset + offset2 + 3 ));
        }
        // --------------------------------------------------------------

        // --- BUS LINIA 4 ------------------------------------------
        // 14 > 18 > 17 > 20 > 19 > 16 > 15
        offset1 = 7*60+3;
        offset2 = 10;
        interval = 25;
        last_one = 20*60;
        for(Integer offset = offset1; offset < last_one; offset+=interval) {

            row14.add(new Edge(nodes.get(13), nodes.get(17), bus, offset, offset + 4 ));
            row14.add(new Edge(nodes.get(13), nodes.get(16), bus, offset, offset + 7 ));
            row14.add(new Edge(nodes.get(13), nodes.get(19), bus, offset, offset + 10));
            row14.add(new Edge(nodes.get(13), nodes.get(18), bus, offset, offset + 13));
            row14.add(new Edge(nodes.get(13), nodes.get(15), bus, offset, offset + 16));
            row14.add(new Edge(nodes.get(13), nodes.get(14), bus, offset, offset + 19));
            row18.add(new Edge(nodes.get(17), nodes.get(16), bus, offset, offset + 3 ));
            row18.add(new Edge(nodes.get(17), nodes.get(19), bus, offset, offset + 6 ));
            row18.add(new Edge(nodes.get(17), nodes.get(18), bus, offset, offset + 9 ));
            row18.add(new Edge(nodes.get(17), nodes.get(15), bus, offset, offset + 12));
            row18.add(new Edge(nodes.get(17), nodes.get(14), bus, offset, offset + 15));
            row17.add(new Edge(nodes.get(16), nodes.get(19), bus, offset, offset + 3 ));
            row17.add(new Edge(nodes.get(16), nodes.get(18), bus, offset, offset + 6 ));
            row17.add(new Edge(nodes.get(16), nodes.get(15), bus, offset, offset + 9 ));
            row17.add(new Edge(nodes.get(16), nodes.get(14), bus, offset, offset + 12));
            row20.add(new Edge(nodes.get(19), nodes.get(18), bus, offset, offset + 3 ));
            row20.add(new Edge(nodes.get(19), nodes.get(15), bus, offset, offset + 6 ));
            row20.add(new Edge(nodes.get(19), nodes.get(14), bus, offset, offset + 9 ));
            row19.add(new Edge(nodes.get(18), nodes.get(15), bus, offset, offset + 3 ));
            row19.add(new Edge(nodes.get(18), nodes.get(14), bus, offset, offset + 6 ));
            row16.add(new Edge(nodes.get(15), nodes.get(14), bus, offset, offset + 3 ));

            row15.add(new Edge(nodes.get(14), nodes.get(15), bus, offset + offset2, offset + offset2 + 3 ));
            row15.add(new Edge(nodes.get(14), nodes.get(18), bus, offset + offset2, offset + offset2 + 6 ));
            row15.add(new Edge(nodes.get(14), nodes.get(19), bus, offset + offset2, offset + offset2 + 9 ));
            row15.add(new Edge(nodes.get(14), nodes.get(16), bus, offset + offset2, offset + offset2 + 12));
            row15.add(new Edge(nodes.get(14), nodes.get(17), bus, offset + offset2, offset + offset2 + 15));
            row15.add(new Edge(nodes.get(14), nodes.get(13), bus, offset + offset2, offset + offset2 + 19));
            row16.add(new Edge(nodes.get(15), nodes.get(18), bus, offset + offset2, offset + offset2 + 3 ));
            row16.add(new Edge(nodes.get(15), nodes.get(19), bus, offset + offset2, offset + offset2 + 6 ));
            row16.add(new Edge(nodes.get(15), nodes.get(16), bus, offset + offset2, offset + offset2 + 9 ));
            row16.add(new Edge(nodes.get(15), nodes.get(17), bus, offset + offset2, offset + offset2 + 12));
            row16.add(new Edge(nodes.get(15), nodes.get(13), bus, offset + offset2, offset + offset2 + 16));
            row19.add(new Edge(nodes.get(18), nodes.get(19), bus, offset + offset2, offset + offset2 + 3 ));
            row19.add(new Edge(nodes.get(18), nodes.get(16), bus, offset + offset2, offset + offset2 + 6 ));
            row19.add(new Edge(nodes.get(18), nodes.get(17), bus, offset + offset2, offset + offset2 + 9 ));
            row19.add(new Edge(nodes.get(18), nodes.get(13), bus, offset + offset2, offset + offset2 + 13));
            row20.add(new Edge(nodes.get(19), nodes.get(16), bus, offset + offset2, offset + offset2 + 3 ));
            row20.add(new Edge(nodes.get(19), nodes.get(17), bus, offset + offset2, offset + offset2 + 6 ));
            row20.add(new Edge(nodes.get(19), nodes.get(13), bus, offset + offset2, offset + offset2 + 10));
            row17.add(new Edge(nodes.get(16), nodes.get(17), bus, offset + offset2, offset + offset2 + 3 ));
            row17.add(new Edge(nodes.get(16), nodes.get(13), bus, offset + offset2, offset + offset2 + 7 ));
            row18.add(new Edge(nodes.get(17), nodes.get(13), bus, offset + offset2, offset + offset2 + 4 ));
        }
        // --------------------------------------------------------------


        // STEP 4. creating network
        List<List<Edge>> network = Arrays.asList(row1, row2, row3, row4, row5, row6, row7, row8, row9, row10,
                row11, row12, row13, row14, row15, row16, row17, row18, row19, row20);


        return new Network(network);
    }

    public static Network getNetworkNine() {
        // STEP 1. creating 9 nodes
        List<Node> nodes = new ArrayList<Node>();
        nodes.add(new Node(1, 6, 6));
        nodes.add(new Node(2, 3, 5));
        nodes.add(new Node(3, 0, 4));
        nodes.add(new Node(4, 5, 4));
        nodes.add(new Node(5, 7, 4));
        nodes.add(new Node(6, 1, 2));
        nodes.add(new Node(7, 5, 2));
        nodes.add(new Node(8, 3, 1));
        nodes.add(new Node(9, 5, 0));

        // STEP 2. creating 9 rows for network
        List<Edge> row1 = new ArrayList<Edge>();
        List<Edge> row2 = new ArrayList<Edge>();
        List<Edge> row3 = new ArrayList<Edge>();
        List<Edge> row4 = new ArrayList<Edge>();
        List<Edge> row5 = new ArrayList<Edge>();
        List<Edge> row6 = new ArrayList<Edge>();
        List<Edge> row7 = new ArrayList<Edge>();
        List<Edge> row8 = new ArrayList<Edge>();
        List<Edge> row9 = new ArrayList<Edge>();

        // STEP 3. creating edges and adding them into rows
        // --- PARAMETRY LINII ------------------------------------------
        MeanOfTransport tram = new Tram();
        MeanOfTransport bus = new Bus();
        Integer offset1;    // offset1 - czas wystartowania pierwszego kursu
        Integer offset2;    // offset1 + offset2 - czas wystartowania pierwszego kursu w kierunku przeciwnym
        Integer interval;   // czas miedzy kursami
        Integer last_one;   // last_one (i last_one + offset2) - czas, po którym nie startują kursy
        // --- uproszczenie - parametry wspolne dla kazdej linii ---
        offset1 = 5*60;
        offset2 = 5;
        interval = 10;
        last_one = 22*60;
        // Line 1:      1 <-> 2
        for(Integer offset = offset1; offset < last_one; offset+=interval){
            row1.add(new Edge(nodes.get(0), nodes.get(1), bus, offset, offset + 4 ));
            row2.add(new Edge(nodes.get(1), nodes.get(0), bus, offset + offset2, offset + offset2 + 4 ));
        }
        // Line 2:      2 <-> 6
        for(Integer offset = offset1; offset < last_one; offset+=interval){
            row2.add(new Edge(nodes.get(1), nodes.get(5), bus, offset, offset + 5 ));
            row6.add(new Edge(nodes.get(5), nodes.get(1), bus, offset + offset2, offset + offset2 + 5 ));
        }
        // Line 3:      2 <-> 7
        for(Integer offset = offset1; offset < last_one; offset+=interval){
            row2.add(new Edge(nodes.get(1), nodes.get(6), bus, offset, offset + 5 ));
            row7.add(new Edge(nodes.get(6), nodes.get(1), bus, offset + offset2, offset + offset2 + 5 ));
        }
        // Line 4:      3 <-> 6
        for(Integer offset = offset1; offset < last_one; offset+=interval){
            row3.add(new Edge(nodes.get(2), nodes.get(5), tram, offset, offset + 3 ));
            row6.add(new Edge(nodes.get(5), nodes.get(2), tram, offset + offset2, offset + offset2 + 3 ));
        }
        // Line 5:      4 <-> 5
        for(Integer offset = offset1; offset < last_one; offset+=interval){
            row4.add(new Edge(nodes.get(3), nodes.get(4), bus, offset, offset + 2 ));
            row5.add(new Edge(nodes.get(4), nodes.get(3), bus, offset + offset2, offset + offset2 + 2 ));
        }
        // Line 6:      4 <-> 7
        for(Integer offset = offset1; offset < last_one; offset+=interval){
            row4.add(new Edge(nodes.get(3), nodes.get(6), bus, offset, offset + 2 ));
            row7.add(new Edge(nodes.get(6), nodes.get(3), bus, offset + offset2, offset + offset2 + 2 ));
        }
        // Line 7:      5 <-> 7
        for(Integer offset = offset1; offset < last_one; offset+=interval){
            row5.add(new Edge(nodes.get(4), nodes.get(6), bus, offset, offset + 4 ));
            row7.add(new Edge(nodes.get(6), nodes.get(4), bus, offset + offset2, offset + offset2 + 4 ));
        }
        // Line 8:      6 <-> 8
        for(Integer offset = offset1; offset < last_one; offset+=interval){
            row6.add(new Edge(nodes.get(5), nodes.get(7), tram, offset, offset + 3 ));
            row8.add(new Edge(nodes.get(7), nodes.get(5), tram, offset + offset2, offset + offset2 + 3 ));
        }
        // Line 9:      7 <-> 8
        for(Integer offset = offset1; offset < last_one; offset+=interval){
            row7.add(new Edge(nodes.get(6), nodes.get(7), bus, offset, offset + 3 ));
            row8.add(new Edge(nodes.get(7), nodes.get(6), bus, offset + offset2, offset + offset2 + 3 ));
        }
        // Line 10:     8 <-> 9
        for(Integer offset = offset1; offset < last_one; offset+=interval){
            row8.add(new Edge(nodes.get(7), nodes.get(8), tram, offset, offset + 3 ));
            row9.add(new Edge(nodes.get(8), nodes.get(7), tram, offset + offset2, offset + offset2 + 3 ));
        }

        // STEP 4. creating network
        List<List<Edge>> network = Arrays.asList(row1, row2, row3, row4, row5, row6, row7, row8, row9);
        return new Network(network);
    }

    public static Network getNetworkFifty() {
        // STEP 1. creating 50 nodes
        List<Node> nodes = new ArrayList<Node>();
        nodes.add(new Node( 1, 10, 27));
        nodes.add(new Node( 2,  0, 26));
        nodes.add(new Node( 3,  6, 26));
        nodes.add(new Node( 4, 13, 26));
        nodes.add(new Node( 5, 15, 25));
        nodes.add(new Node( 6, 20, 24));
        nodes.add(new Node( 7, 25, 24));
        nodes.add(new Node( 8, 13, 22));
        nodes.add(new Node( 9,  3, 21));
        nodes.add(new Node(10,  8, 19));

        nodes.add(new Node(11, 13, 19));
        nodes.add(new Node(12, 22, 19));
        nodes.add(new Node(13, 16, 18));
        nodes.add(new Node(14,  4, 17));
        nodes.add(new Node(15, 18, 17));
        nodes.add(new Node(16, 27, 17));
        nodes.add(new Node(17,  1, 15));
        nodes.add(new Node(18, 11, 15));
        nodes.add(new Node(19,  4, 14));
        nodes.add(new Node(20,  9, 14));

        nodes.add(new Node(21, 18, 14));
        nodes.add(new Node(22, 24, 14));
        nodes.add(new Node(23, 15, 12));
        nodes.add(new Node(24, 22, 12));
        nodes.add(new Node(25, 11, 11));
        nodes.add(new Node(26, 29, 11));
        nodes.add(new Node(27,  2, 10));
        nodes.add(new Node(28,  7, 10));
        nodes.add(new Node(29, 13,  9));
        nodes.add(new Node(30,  5,  8));

        nodes.add(new Node(31, 19,  8));
        nodes.add(new Node(32, 26,  8));
        nodes.add(new Node(33,  0,  7));
        nodes.add(new Node(34, 10,  7));
        nodes.add(new Node(35, 15,  6));
        nodes.add(new Node(36,  4,  5));
        nodes.add(new Node(37, 21,  5));
        nodes.add(new Node(38, 30,  5));
        nodes.add(new Node(39,  2,  4));
        nodes.add(new Node(40, 11,  4));

        nodes.add(new Node(41, 25,  4));
        nodes.add(new Node(42, 18,  3));
        nodes.add(new Node(43,  0,  2));
        nodes.add(new Node(44,  6,  2));
        nodes.add(new Node(45, 14,  2));
        nodes.add(new Node(46,  3,  1));
        nodes.add(new Node(47, 22,  1));
        nodes.add(new Node(48,  9,  0));
        nodes.add(new Node(49, 17,  0));
        nodes.add(new Node(50, 26,  0));



        // STEP 2. creating 50 rows for network
        List<Edge> row1  = new ArrayList<Edge>();
        List<Edge> row2  = new ArrayList<Edge>();
        List<Edge> row3  = new ArrayList<Edge>();
        List<Edge> row4  = new ArrayList<Edge>();
        List<Edge> row5  = new ArrayList<Edge>();
        List<Edge> row6  = new ArrayList<Edge>();
        List<Edge> row7  = new ArrayList<Edge>();
        List<Edge> row8  = new ArrayList<Edge>();
        List<Edge> row9  = new ArrayList<Edge>();
        List<Edge> row10 = new ArrayList<Edge>();
        List<Edge> row11 = new ArrayList<Edge>();
        List<Edge> row12 = new ArrayList<Edge>();
        List<Edge> row13 = new ArrayList<Edge>();
        List<Edge> row14 = new ArrayList<Edge>();
        List<Edge> row15 = new ArrayList<Edge>();
        List<Edge> row16 = new ArrayList<Edge>();
        List<Edge> row17 = new ArrayList<Edge>();
        List<Edge> row18 = new ArrayList<Edge>();
        List<Edge> row19 = new ArrayList<Edge>();
        List<Edge> row20 = new ArrayList<Edge>();
        List<Edge> row21 = new ArrayList<Edge>();
        List<Edge> row22 = new ArrayList<Edge>();
        List<Edge> row23 = new ArrayList<Edge>();
        List<Edge> row24 = new ArrayList<Edge>();
        List<Edge> row25 = new ArrayList<Edge>();
        List<Edge> row26 = new ArrayList<Edge>();
        List<Edge> row27 = new ArrayList<Edge>();
        List<Edge> row28 = new ArrayList<Edge>();
        List<Edge> row29 = new ArrayList<Edge>();
        List<Edge> row30 = new ArrayList<Edge>();
        List<Edge> row31 = new ArrayList<Edge>();
        List<Edge> row32 = new ArrayList<Edge>();
        List<Edge> row33 = new ArrayList<Edge>();
        List<Edge> row34 = new ArrayList<Edge>();
        List<Edge> row35 = new ArrayList<Edge>();
        List<Edge> row36 = new ArrayList<Edge>();
        List<Edge> row37 = new ArrayList<Edge>();
        List<Edge> row38 = new ArrayList<Edge>();
        List<Edge> row39 = new ArrayList<Edge>();
        List<Edge> row40 = new ArrayList<Edge>();
        List<Edge> row41 = new ArrayList<Edge>();
        List<Edge> row42 = new ArrayList<Edge>();
        List<Edge> row43 = new ArrayList<Edge>();
        List<Edge> row44 = new ArrayList<Edge>();
        List<Edge> row45 = new ArrayList<Edge>();
        List<Edge> row46 = new ArrayList<Edge>();
        List<Edge> row47 = new ArrayList<Edge>();
        List<Edge> row48 = new ArrayList<Edge>();
        List<Edge> row49 = new ArrayList<Edge>();
        List<Edge> row50 = new ArrayList<Edge>();

        // STEP 3. creating edges and adding them into rows
        // --- PARAMETRY LINII ------------------------------------------
        MeanOfTransport bus = new Bus();
        MeanOfTransport tram = new Tram();

        Integer offset1;    // offset1 - czas wystartowania pierwszego kursu
        Integer interval;   // czas miedzy kursami
        Integer last_one;   // last_one (i last_one + offset2) - czas, po którym nie startują kursy

        // Linie czarne
        offset1 = 5*60;
        interval = 15;
        last_one = 22*60;
        for(Integer offset = offset1; offset < last_one; offset+=interval){
            row1.add( new Edge( nodes.get(0),  nodes.get(2), bus, offset, offset +  5));
            row3.add( new Edge( nodes.get(2),  nodes.get(0), bus, offset, offset +  5));

            row5.add( new Edge( nodes.get(4),  nodes.get(5), bus, offset, offset +  6));
            row6.add( new Edge( nodes.get(5),  nodes.get(4), bus, offset, offset +  6));

            row9.add( new Edge( nodes.get(8),  nodes.get(9), bus, offset, offset +  7));
            row10.add(new Edge( nodes.get(9),  nodes.get(8), bus, offset, offset +  7));

            row18.add(new Edge(nodes.get(17), nodes.get(19), bus, offset, offset +  3));
            row20.add(new Edge(nodes.get(19), nodes.get(17), bus, offset, offset +  3));

            row36.add(new Edge(nodes.get(35), nodes.get(38), bus, offset, offset +  3));
            row39.add(new Edge(nodes.get(38), nodes.get(35), bus, offset, offset +  3));

            row34.add(new Edge(nodes.get(33), nodes.get(39), bus, offset, offset +  4));
            row40.add(new Edge(nodes.get(39), nodes.get(33), bus, offset, offset +  4));

            row24.add(new Edge(nodes.get(23), nodes.get(34), bus, offset, offset + 13));
            row35.add(new Edge(nodes.get(34), nodes.get(23), bus, offset, offset + 13));

            row23.add(new Edge(nodes.get(22), nodes.get(24), bus, offset, offset +  5));
            row25.add(new Edge(nodes.get(24), nodes.get(22), bus, offset, offset +  5));

            row42.add(new Edge(nodes.get(41), nodes.get(46), bus, offset, offset +  6));
            row47.add(new Edge(nodes.get(46), nodes.get(41), bus, offset, offset +  6));

            row45.add(new Edge(nodes.get(44), nodes.get(47), bus, offset, offset +  7));
            row48.add(new Edge(nodes.get(47), nodes.get(44), bus, offset, offset +  7));

            row47.add(new Edge(nodes.get(46), nodes.get(49), bus, offset, offset +  5));
            row50.add(new Edge(nodes.get(49), nodes.get(46), bus, offset, offset +  5));

            row33.add(new Edge(nodes.get(32), nodes.get(38), bus, offset, offset +  5));
            row39.add(new Edge(nodes.get(38), nodes.get(32), bus, offset, offset +  5));

            row30.add(new Edge(nodes.get(29), nodes.get(33), bus, offset, offset +  6));
            row34.add(new Edge(nodes.get(33), nodes.get(29), bus, offset, offset +  6));

            row26.add(new Edge(nodes.get(25), nodes.get(31), bus, offset, offset +  6));
            row32.add(new Edge(nodes.get(31), nodes.get(25), bus, offset, offset +  6));
        }

        // Linie czerwone
        offset1 = 5*60;
        interval = 20;
        last_one = 22*60;
        for(Integer offset = offset1; offset < last_one; offset+=interval){
            row19.add(new Edge(nodes.get(18), nodes.get(26), bus, offset, offset +  6));
            row27.add(new Edge(nodes.get(26), nodes.get(18), bus, offset, offset +  6));

            row14.add(new Edge(nodes.get(13), nodes.get(19), bus, offset, offset +  8));
            row20.add(new Edge(nodes.get(19), nodes.get(13), bus, offset, offset +  8));

            row18.add(new Edge(nodes.get(17), nodes.get(22), bus, offset, offset +  7));
            row23.add(new Edge(nodes.get(22), nodes.get(17), bus, offset, offset +  7));

            row21.add(new Edge(nodes.get(20), nodes.get(22), bus, offset, offset +  5));
            row23.add(new Edge(nodes.get(22), nodes.get(20), bus, offset, offset +  5));

            row31.add(new Edge(nodes.get(30), nodes.get(31), bus, offset, offset +  7));
            row32.add(new Edge(nodes.get(31), nodes.get(30), bus, offset, offset +  7));

            row36.add(new Edge(nodes.get(35), nodes.get(43), bus, offset, offset +  5));
            row44.add(new Edge(nodes.get(43), nodes.get(35), bus, offset, offset +  5));

            row46.add(new Edge(nodes.get(45), nodes.get(47), bus, offset, offset +  7));
            row48.add(new Edge(nodes.get(47), nodes.get(45), bus, offset, offset +  7));

            row45.add(new Edge(nodes.get(44), nodes.get(48), bus, offset, offset +  5));
            row49.add(new Edge(nodes.get(48), nodes.get(44), bus, offset, offset +  5));

            row1.add( new Edge(nodes.get(0),  nodes.get(3),  bus, offset, offset +  4));
            row4.add( new Edge(nodes.get(3),  nodes.get(0),  bus, offset, offset +  4));

            row3.add( new Edge(nodes.get(2),  nodes.get(8),  bus, offset, offset +  8));
            row9.add( new Edge(nodes.get(8),  nodes.get(2),  bus, offset, offset +  8));

            row8.add( new Edge(nodes.get(7),  nodes.get(9),  bus, offset, offset +  8));
            row10.add(new Edge(nodes.get(9),  nodes.get(7),  bus, offset, offset +  8));

            row6.add( new Edge(nodes.get(5),  nodes.get(6),  bus, offset, offset +  5));
            row7.add( new Edge(nodes.get(6),  nodes.get(5),  bus, offset, offset +  5));

            row16.add(new Edge(nodes.get(15), nodes.get(21), bus, offset, offset +  6));
            row22.add(new Edge(nodes.get(21), nodes.get(15), bus, offset, offset +  6));

            row35.add(new Edge(nodes.get(34), nodes.get(39), bus, offset, offset +  6));
            row40.add(new Edge(nodes.get(39), nodes.get(34), bus, offset, offset +  6));
        }

        // Linie pomarańczowe
        offset1 = 5*60;
        interval = 12;
        last_one = 22*60;
        for(Integer offset = offset1; offset < last_one; offset+=interval) {
            row4.add( new Edge(nodes.get(3),  nodes.get(4),  bus, offset, offset +  3));
            row5.add( new Edge(nodes.get(4),  nodes.get(3),  bus, offset, offset +  3));

            row8.add( new Edge(nodes.get(7),  nodes.get(10), bus, offset, offset +  3));
            row11.add(new Edge(nodes.get(10), nodes.get(7),  bus, offset, offset +  3));

            row13.add(new Edge(nodes.get(12), nodes.get(14), bus, offset, offset +  3));
            row15.add(new Edge(nodes.get(14), nodes.get(12), bus, offset, offset +  3));

            row15.add(new Edge(nodes.get(14), nodes.get(20), bus, offset, offset +  3));
            row21.add(new Edge(nodes.get(20), nodes.get(14), bus, offset, offset +  3));

            row14.add(new Edge(nodes.get(13), nodes.get(16), bus, offset, offset +  5));
            row17.add(new Edge(nodes.get(16), nodes.get(13), bus, offset, offset +  5));

            row14.add(new Edge(nodes.get(13), nodes.get(18), bus, offset, offset +  3));
            row19.add(new Edge(nodes.get(18), nodes.get(13), bus, offset, offset +  3));

            row22.add(new Edge(nodes.get(21), nodes.get(23), bus, offset, offset +  4));
            row24.add(new Edge(nodes.get(23), nodes.get(21), bus, offset, offset +  4));

            row25.add(new Edge(nodes.get(24), nodes.get(28), bus, offset, offset +  4));
            row29.add(new Edge(nodes.get(28), nodes.get(24), bus, offset, offset +  4));

            row28.add(new Edge(nodes.get(27), nodes.get(29), bus, offset, offset +  4));
            row30.add(new Edge(nodes.get(29), nodes.get(27), bus, offset, offset +  4));

            row39.add(new Edge(nodes.get(38), nodes.get(42), bus, offset, offset +  4));
            row43.add(new Edge(nodes.get(42), nodes.get(38), bus, offset, offset +  4));

            row32.add(new Edge(nodes.get(31), nodes.get(40), bus, offset, offset +  5));
            row41.add(new Edge(nodes.get(40), nodes.get(31), bus, offset, offset +  5));

            row37.add(new Edge(nodes.get(36), nodes.get(46), bus, offset, offset +  5));
            row47.add(new Edge(nodes.get(46), nodes.get(36), bus, offset, offset +  5));

            row47.add(new Edge(nodes.get(46), nodes.get(48), bus, offset, offset +  6));
            row49.add(new Edge(nodes.get(48), nodes.get(46), bus, offset, offset +  6));
        }

        // Linie zielone
        offset1 = 5*60;
        interval = 30;
        last_one = 22*60;
        for(Integer offset = offset1; offset < last_one; offset+=interval) {
            row1.add( new Edge(nodes.get(0),   nodes.get(9),   tram, offset, offset + 10));
            row10.add(new Edge(nodes.get(9),   nodes.get(0),   tram, offset, offset + 10));

            row2.add( new Edge(nodes.get(1),   nodes.get(8),   tram, offset, offset +  8));
            row9.add( new Edge(nodes.get(8),   nodes.get(1),   tram, offset, offset +  8));

            row11.add(new Edge(nodes.get(10),  nodes.get(17),  tram, offset, offset +  6));
            row18.add(new Edge(nodes.get(17),  nodes.get(10),  tram, offset, offset +  6));

            row12.add(new Edge(nodes.get(11),  nodes.get(14),  tram, offset, offset +  6));
            row15.add(new Edge(nodes.get(14),  nodes.get(11),  tram, offset, offset +  6));

            row16.add(new Edge(nodes.get(15),  nodes.get(25),  tram, offset, offset +  8));
            row26.add(new Edge(nodes.get(25),  nodes.get(15),  tram, offset, offset +  8));

            row20.add(new Edge(nodes.get(19),  nodes.get(43),  tram, offset, offset + 15));
            row44.add(new Edge(nodes.get(43),  nodes.get(19),  tram, offset, offset + 15));

            row21.add(new Edge(nodes.get(20),  nodes.get(23),  tram, offset, offset +  6));
            row24.add(new Edge(nodes.get(23),  nodes.get(20),  tram, offset, offset +  6));

            row30.add(new Edge(nodes.get(29),  nodes.get(32),  tram, offset, offset +  6));
            row33.add(new Edge(nodes.get(32),  nodes.get(29),  tram, offset, offset +  6));

            row38.add(new Edge(nodes.get(37),  nodes.get(49),  tram, offset, offset +  9));
            row50.add(new Edge(nodes.get(49),  nodes.get(37),  tram, offset, offset +  9));
        }

        // Linie błękitne
        offset1 = 5*60+15;
        interval = 30;
        last_one = 22*60;
        for(Integer offset = offset1; offset < last_one; offset+=interval) {
            row2.add(new Edge(nodes.get(1), nodes.get(2), tram, offset, offset + 6));
            row3.add(new Edge(nodes.get(2), nodes.get(1), tram, offset, offset + 6));

            row6.add(new Edge(nodes.get(5), nodes.get(7), tram, offset, offset + 9));
            row8.add(new Edge(nodes.get(7), nodes.get(5), tram, offset, offset + 9));

            row6.add(new Edge(nodes.get(5), nodes.get(11), tram, offset, offset + 7));
            row12.add(new Edge(nodes.get(11), nodes.get(5), tram, offset, offset + 7));

            row7.add(new Edge(nodes.get(6), nodes.get(15), tram, offset, offset + 9));
            row16.add(new Edge(nodes.get(15), nodes.get(6), tram, offset, offset + 9));

            row17.add(new Edge(nodes.get(16), nodes.get(32), tram, offset, offset + 9));
            row33.add(new Edge(nodes.get(32), nodes.get(16), tram, offset, offset + 9));

            row19.add(new Edge(nodes.get(18), nodes.get(27), tram, offset, offset + 7));
            row28.add(new Edge(nodes.get(27), nodes.get(18), tram, offset, offset + 7));

            row24.add(new Edge(nodes.get(23), nodes.get(31), tram, offset, offset + 8));
            row32.add(new Edge(nodes.get(31), nodes.get(23), tram, offset, offset + 8));

            row29.add(new Edge(nodes.get(28), nodes.get(41), tram, offset, offset + 11));
            row42.add(new Edge(nodes.get(41), nodes.get(28), tram, offset, offset + 11));

            row34.add(new Edge(nodes.get(33), nodes.get(47), tram, offset, offset + 8));
            row48.add(new Edge(nodes.get(47), nodes.get(33), tram, offset, offset + 8));

            row38.add(new Edge(nodes.get(37), nodes.get(40), tram, offset, offset + 6));
            row41.add(new Edge(nodes.get(40), nodes.get(37), tram, offset, offset + 6));

            row42.add(new Edge(nodes.get(41), nodes.get(44), tram, offset, offset + 5));
            row45.add(new Edge(nodes.get(44), nodes.get(41), tram, offset, offset + 5));
        }

        // Linie niebieskie
        offset1 = 10*60+12;
        interval = 60;
        last_one = 18*60;
        for(Integer offset = offset1; offset < last_one; offset+=interval) {
            row4.add( new Edge(nodes.get(3),  nodes.get(7),  bus, offset, offset + 4));
            row8.add( new Edge(nodes.get(7),  nodes.get(3),  bus, offset, offset + 4));

            row9.add( new Edge(nodes.get(8),  nodes.get(13), bus, offset, offset + 5));
            row14.add(new Edge(nodes.get(13), nodes.get(8),  bus, offset, offset + 5));

            row11.add(new Edge(nodes.get(10), nodes.get(12), bus, offset, offset + 4));
            row13.add(new Edge(nodes.get(12), nodes.get(10), bus, offset, offset + 4));

            row24.add(new Edge(nodes.get(23), nodes.get(25), bus, offset, offset + 8));
            row26.add(new Edge(nodes.get(25), nodes.get(23), bus, offset, offset + 8));

            row27.add(new Edge(nodes.get(26), nodes.get(35), bus, offset, offset + 7));
            row36.add(new Edge(nodes.get(35), nodes.get(26), bus, offset, offset + 7));

            row31.add(new Edge(nodes.get(30), nodes.get(41), bus, offset, offset + 6));
            row42.add(new Edge(nodes.get(41), nodes.get(30), bus, offset, offset + 6));

            row44.add(new Edge(nodes.get(43), nodes.get(44), bus, offset, offset + 8));
            row45.add(new Edge(nodes.get(44), nodes.get(43), bus, offset, offset + 8));
        }


        // Linie fioletowe
        offset1 = 10*60+36;
        interval = 60;
        last_one = 18*60;
        for(Integer offset = offset1; offset < last_one; offset+=interval) {
            row10.add(new Edge(nodes.get(9),  nodes.get(17), bus, offset, offset +  7));
            row18.add(new Edge(nodes.get(17), nodes.get(9),  bus, offset, offset +  7));

            row23.add(new Edge(nodes.get(22), nodes.get(30), bus, offset, offset +  8));
            row31.add(new Edge(nodes.get(30), nodes.get(22), bus, offset, offset +  8));

            row25.add(new Edge(nodes.get(24), nodes.get(26), bus, offset, offset + 10));
            row27.add(new Edge(nodes.get(26), nodes.get(24), bus, offset, offset + 10));

            row35.add(new Edge(nodes.get(34), nodes.get(48), bus, offset, offset +  8));
            row49.add(new Edge(nodes.get(48), nodes.get(34), bus, offset, offset +  8));

            row41.add(new Edge(nodes.get(40), nodes.get(49), bus, offset, offset +  5));
            row50.add(new Edge(nodes.get(49), nodes.get(40), bus, offset, offset +  5));

            row43.add(new Edge(nodes.get(42), nodes.get(43), bus, offset, offset +  6));
            row44.add(new Edge(nodes.get(43), nodes.get(42), bus, offset, offset +  6));
        }

        // STEP 4. creating network
        List<List<Edge>> network = Arrays.asList(row1, row2, row3, row4, row5, row6, row7, row8, row9, row10,
                row11, row12, row13, row14, row15, row16, row17, row18, row19, row20,
                row21, row22, row23, row24, row25, row26, row27, row28, row29, row30,
                row31, row32, row33, row34, row35, row36, row37, row38, row39, row40,
                row41, row42, row43, row44, row45, row46, row47, row48, row49, row50);
        return new Network(network);
    }

}
