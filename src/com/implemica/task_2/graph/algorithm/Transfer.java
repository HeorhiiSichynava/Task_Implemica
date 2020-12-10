package com.implemica.task_2.graph.algorithm;

import com.implemica.task_2.node.Node;
//
//cost of passage from node A to node B
public class Transfer {
    private Node pointA, pointB;
    private Integer weight;

    public Transfer(Node node) {
        this.pointA = node;
        this.pointB = node;
        weight = Integer.MAX_VALUE;
    }

    public Transfer(Node pointA, Node pointB, Integer weight) {
        this.pointA = pointA;
        this.pointB = pointB;
        this.weight = weight;
    }

    public Transfer setTransfer(Node pointA, Node pointB, Integer weight) {
        this.pointA = pointA;
        this.pointB = pointB;
        this.weight = weight;
        return this;
    }

    public Integer getWeight() {
        return weight;
    }

    public Transfer getTransferStep() {
        return this;
    }

    public Node getPointA() {
        return pointA;
    }

    public Node getPointB() {
        return pointB;
    }

    public void info() {
        try {
            Transfer transfer = this;
            if (transfer == null)
                throw new NullPointerException();
            System.out.println("(" + pointA.getName() + " - " + pointB.getName() + ") weight: " + weight + "");
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "weight("+pointA.getEdgeWeightForNode(pointB)+") = { A:B (" + pointA + ":" + pointB +
                ") }";
    }
}
