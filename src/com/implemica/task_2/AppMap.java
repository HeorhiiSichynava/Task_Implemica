package com.implemica.task_2;

import com.implemica.task_2.node.City;
import com.implemica.task_2.node.Node;

import java.util.Arrays;

public class AppMap {
    public static void main(String[] args) {
        BuildMap buildMap = new BuildMap();
        buildMap.loadMap("C:/Users/georg/IdeaProjects/Tasks_Implemica/src/com/implemica/task_2/map.txt");
    }
}

