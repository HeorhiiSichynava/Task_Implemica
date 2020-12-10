package com.implemica.task_2.node;

import java.util.*;
import java.util.Map;

public class Node implements InterfaceNode {
    //Hostname
    private String name = "Node";
    //node number
    private int number = 1;
    //communication nodes and their weight
    private HashMap<Node, Integer> listNodes;

    public Node(String nameNode) {
        this.name = nameNode;
        if (listNodes == null)
            listNodes = new HashMap<Node, Integer>();
    }

    public Node(int number) {
        this.number = number;
        this.name += "_" + number;
        if (listNodes == null)
            listNodes = new HashMap<Node, Integer>();
    }

    public int getNumber() {
        return number;
    }

    @Override
    public void setEdgeWeightForNode(Node node, int weight) {
        if (!listNodes.containsKey(node))
            listNodes.put(node, weight);
        else {
            System.out.println("Node with the same name has already been added");
        }
    }

    @Override
    public Integer getEdgeWeightForNode(Node node) {
        return this.listNodes.get(node);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void showNode() {
        System.out.println(this.name + " to:");
        for (Map.Entry<Node, Integer> node : listNodes.entrySet()) {
            System.out.println("\t- " +
                    node.getKey().getName() + " (weight: " +
                    node.getValue() + ")"
            );
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public LinkedList<Node> getListNodes() {
        LinkedList list = new LinkedList();
        list.addAll(this.listNodes.keySet());
        //Provide a list of related nodes
        return list;
    }

    @Override
    public String toString() {
        return "" + name + "";
    }
}
