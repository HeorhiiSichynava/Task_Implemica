package com.implemica.task_2;

import com.implemica.task_2.node.City;
import com.implemica.task_2.node.Node;

import java.io.*;
import java.util.Arrays;

public class BuildMap {
    private Map map;
    private int step = 0;
    private int s = 0;
    private int cityNumber = 0;
    private int numberConnection = 0;
    private boolean connection = true;
    private int find = 0;

    public BuildMap() {
    }

    public void loadMap(String nameFile) {
        try {
            int countCity = 0; // n
            File file = new File(nameFile);
            map = new Map(file.getName());

            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            // first count the first line
            String line = reader.readLine();
            switch (step) {
                case 0:
                    for (int i = 0; i < 2; i++) {
                        if (i == 0 && isDigit(line)) {
                            s = Integer.parseInt(line); // not used in this application
                        } else if (isDigit(line)) {
                            countCity = Integer.parseInt(line); // read the number of cities and create objects nodes
                            for (int j = 0; j < countCity; j++) {
                                map.addCity(new City(j + 1));
                            }
                            line = reader.readLine();
                        }
                    }
                case 1:
                    Node node;
//                  fill in the fields of the nodes
                    for (int i = 0; i < countCity; i++) {
//                      assign a name to the city (node)
                        map.getNodeByNumber(i + 1).setName(line);
                        node = map.getNodeByName(line);
//                      we write down the connections and the weights of the passage along them
                        cityConnect(node, reader);
                        line = reader.readLine();
                    }
                case 2:
//
//                  write down the number of queries to search
                    int numberOfRequests = Integer.parseInt(line);
                    String[] str;
                    for (int i = 0; i < numberOfRequests; i++) {
//                      we read the request to find the optimal path
                        str = reader.readLine().split(" ");
//                      check the correctness of the input data
                        if (map.getNodeByName(str[0]) != null && map.getNodeByName(str[1]) != null)
//                      we display the resulting weight of the optimal path
                            System.out.println("weight: " +
                                    map.printOptimalPass(map.getNodeByName(str[0]), map.getNodeByName(str[1])));
                        else System.err.println("Check the correctness of the input data!");
                    }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private void cityConnect(Node node, BufferedReader reader) throws IOException {
        String line = reader.readLine();
        int countConnect = Integer.parseInt(line);
        String[] str;
        for (int i = 0; i < countConnect; i++) {
            str = reader.readLine().split(" ");
            map.setConnection(node, map.getNodeByNumber(Integer.parseInt(str[0])), Integer.parseInt(str[1]));
        }
    }
}
