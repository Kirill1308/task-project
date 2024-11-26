package com.popov.test.task2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Graph {
    private final Map<String, List<Edge>> adjList = new HashMap<>();

    // Adds a city to the graph
    public void addCity(String city) {
        adjList.putIfAbsent(city, new ArrayList<>());
    }

    // Adds a connection (edge) between two cities
    public void addConnection(String city1, String city2, int cost) {
        adjList.get(city1).add(new Edge(city2, cost));
    }

    // Dijkstra's algorithm to find the shortest path from source to destination
    public int findShortestPath(String source, String destination) {
        PriorityQueue<Edge> minHeap = new PriorityQueue<>(Comparator.comparingInt(e -> e.cost));
        Map<String, Integer> distances = new HashMap<>();
        Set<String> visited = new HashSet<>();

        // Initialize distances to infinity
        for (String city : adjList.keySet()) {
            distances.put(city, Integer.MAX_VALUE);
        }

        distances.put(source, 0);
        minHeap.add(new Edge(source, 0));

        while (!minHeap.isEmpty()) {
            Edge current = minHeap.poll();
            String currentCity = current.city;

            if (!visited.add(currentCity)) {
                continue;
            }

            if (currentCity.equals(destination)) {
                return current.cost;
            }

            for (Edge neighbor : adjList.getOrDefault(currentCity, new ArrayList<>())) {
                if (!visited.contains(neighbor.city)) {
                    int newCost = current.cost + neighbor.cost;
                    if (newCost < distances.get(neighbor.city)) {
                        distances.put(neighbor.city, newCost);
                        minHeap.add(new Edge(neighbor.city, newCost));
                    }
                }
            }
        }

        return -1;
    }


    // Represents an edge between two cities
    static class Edge {
        String city;
        int cost;

        Edge(String city, int cost) {
            this.city = city;
            this.cost = cost;
        }
    }

}
