package com.implemica.task_2.node;

import java.util.LinkedList;

public interface InterfaceNode {
    void setEdgeWeightForNode(Node node, int weight);

    Integer getEdgeWeightForNode(Node node);

    String getName();

    void showNode();

    LinkedList<Node> getListNodes();
}
