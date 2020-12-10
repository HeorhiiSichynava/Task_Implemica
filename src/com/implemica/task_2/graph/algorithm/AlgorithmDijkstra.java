package com.implemica.task_2.graph.algorithm;

import com.implemica.task_2.node.Node;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

//
//Graph traversal algorithm
public final class AlgorithmDijkstra {
    private HashMap<Node, Transfer> nodesPass;
    private LinkedList list;
    private Integer minSumWeightPass;

    public AlgorithmDijkstra(HashSet<Node> nodes) {
        this.nodesPass = new HashMap<Node, Transfer>();
        for (Node node : nodes) {
            nodesPass.put(node, new Transfer(node));
        }
        list = new LinkedList();
    }

    //to search, we set the start and end nodes
    public int graphPass(Node start, Node finish) {
        int weight = 0;
//      according to Deekstra's algorithm, the initial weight is equal to the largest number
        minSumWeightPass = Integer.MAX_VALUE;
//      the starting node has weight 0
        nodesPass.get(start).setTransfer(start, start, 0);
//      we write in the table the sum of the weights of the passage through all communication nodes
        graphPass(start, finish, 0);
//      we write down the minimum weight of the passage through the graph to the end point
        weight = nodesPass.get(finish).getWeight();
//      write down the shortest path
        for (Node node = finish; start != node; ) {
            list.addLast(nodesPass.get(node).getTransferStep());
            node = nodesPass.get(node).getPointA();
        }
//      display the shortest path
        System.out.println(Arrays.toString(list.toArray()));
        return weight;
    }
//  table with weights of the passage from the start node to the end
    private void graphPass(Node start, Node finish, int currentWeight) {
        int weight = 0;
        int weightPass = 0;

//      the passage along this path is completed
        if (start == finish) {
            minSumWeightPass = currentWeight;
        }

//      until we reach the final node, the sum of the traversed path should not exceed the sum of the minimum path
        else if (minSumWeightPass > currentWeight) {
//          get a list of available paths
            for (Node nextNode : start.getListNodes()) {
                weight = nodesPass.get(nextNode).getWeight();
                weightPass = start.getEdgeWeightForNode(nextNode) + currentWeight;
//              check the passage to the given node is optimal if yes then enter the result into the table
                if (weight > weightPass) {
                    nodesPass.get(nextNode).setTransfer(start, nextNode, weightPass);
                    graphPass(nextNode, finish, weightPass);
                }
            }
        }
        return;
    }
}