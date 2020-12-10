package com.implemica.task_2;

import com.implemica.task_2.graph.algorithm.AlgorithmDijkstra;
import com.implemica.task_2.node.Node;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

public final class Map {
    HashSet<Node> citySet;
    String nameMap = "Map";
    AlgorithmDijkstra algorithmDijkstra;

    public Map(String nameMap) {
        this.nameMap = nameMap;
        citySet = new HashSet<Node>();
    }

    public void addCity(Node city) {
        citySet.add(city);
    }

    public void setConnection(Node cityA, Node cityB, int cost) {
        cityA.setEdgeWeightForNode(cityB, cost);
        //you can add feedback immediately
//        cityB.setEdgeWeightForNode(cityA, cost);
    }

    public int printOptimalPass(Node pointA, Node pointB) {
        AlgorithmDijkstra algorithmDijkstra = new AlgorithmDijkstra(getCitySet());
        return algorithmDijkstra.graphPass(pointA, pointB);
    }

    public HashSet<Node> getCitySet() {
        return citySet;
    }

    public void printList() {
        System.out.println(Arrays.toString(getCitySet().toArray()));
    }

    public Node getNodeByName(String string) {
        for (Node node : getCitySet()) {
            if (node.getName().equals(string))
                return node;
        }
        return null; // exception
    }

    public Node getNodeByNumber(int numberNode) {
        for (Node node : getCitySet()) {
            if (node.getNumber() == numberNode)
                return node;
        }
        return null;
    }

    @Override
    public String toString() {
        return "Map{" +
                "citySet=" + citySet +
                ", nameMap='" + nameMap + '\'' +
                '}';
    }
}
