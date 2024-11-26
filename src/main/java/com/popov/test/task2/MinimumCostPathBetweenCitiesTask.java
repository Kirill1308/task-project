package com.popov.test.task2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MinimumCostPathBetweenCitiesTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Graph graph = new Graph();

        // Read the number of test cases
        int testCases = Integer.parseInt(scanner.nextLine());

        while (testCases-- > 0) {
            int numberOfCities = Integer.parseInt(scanner.nextLine());
            Map<Integer, String> cityIndexMap = new HashMap<>();

            // Read city information with costs
            for (int i = 1; i <= numberOfCities; i++) {
                String cityName = scanner.nextLine();
                graph.addCity(cityName);
                cityIndexMap.put(i, cityName);

                int neighbors = Integer.parseInt(scanner.nextLine());
                for (int j = 0; j < neighbors; j++) {
                    String[] neighborData = scanner.nextLine().split(" ");
                    int neighborIndex = Integer.parseInt(neighborData[0]);
                    int cost = Integer.parseInt(neighborData[1]);
                    graph.addConnection(cityName, cityIndexMap.get(neighborIndex), cost);
                }
            }

            // Read the number of paths
            int numberOfPaths = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < numberOfPaths; i++) {
                String[] pathData = scanner.nextLine().split(" ");
                String source = pathData[0];
                String destination = pathData[1];
                System.out.println(graph.findShortestPath(source, destination));
            }
        }

        scanner.close();
    }
}
