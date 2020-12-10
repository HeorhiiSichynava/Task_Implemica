package com.implemica.task_2.node;

public class City extends Node {

    public City(String nameNode) {
        super(nameNode);
    }

    public City(int number) {
        super(number);
    }

    public void addCostNode(Node city, int cost) {
        super.setEdgeWeightForNode(city, cost);
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public String getName() {
        return super.getName();
    }
}
