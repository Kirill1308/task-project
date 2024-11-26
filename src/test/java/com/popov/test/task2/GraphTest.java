package com.popov.test.task2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GraphTest {

    @Test
    void findShortestPath_example() {
        Graph graph = new Graph();
        graph.addCity("gdansk");
        graph.addCity("bydgoszcz");
        graph.addCity("torun");
        graph.addCity("warszawa");

        graph.addConnection("gdansk", "bydgoszcz", 1);
        graph.addConnection("gdansk", "torun", 3);
        graph.addConnection("bydgoszcz", "gdansk", 1);
        graph.addConnection("bydgoszcz", "torun", 1);
        graph.addConnection("bydgoszcz", "warszawa", 4);
        graph.addConnection("torun", "gdansk", 3);
        graph.addConnection("torun", "bydgoszcz", 1);
        graph.addConnection("torun", "warszawa", 1);
        graph.addConnection("warszawa", "bydgoszcz", 4);
        graph.addConnection("warszawa", "torun", 1);

        assertEquals(3, graph.findShortestPath("gdansk", "warszawa"));
        assertEquals(2, graph.findShortestPath("bydgoszcz", "warszawa"));
    }

    @Test
    void findShortestPath_noConnectionBetweenCities() {
        Graph graph = new Graph();
        graph.addCity("cityA");
        graph.addCity("cityB");

        // No connection between cityA and cityB
        assertEquals(-1, graph.findShortestPath("cityA", "cityB"));
    }

    @Test
    void findShortestPath_pathToItself() {
        Graph graph = new Graph();
        graph.addCity("cityA");

        // Path from a city to itself should be 0
        assertEquals(0, graph.findShortestPath("cityA", "cityA"));
    }

    @Test
    void findShortestPath_disconnectedGraph() {
        Graph graph = new Graph();
        graph.addCity("cityA");
        graph.addCity("cityB");
        graph.addCity("cityC");

        // No connections at all
        assertEquals(-1, graph.findShortestPath("cityA", "cityB"));
        assertEquals(-1, graph.findShortestPath("cityB", "cityC"));
    }

    @Test
    void findShortestPath_multiplePaths() {
        Graph graph = new Graph();
        graph.addCity("A");
        graph.addCity("B");
        graph.addCity("C");
        graph.addCity("D");

        graph.addConnection("A", "B", 2);
        graph.addConnection("A", "C", 5);
        graph.addConnection("B", "C", 1);
        graph.addConnection("C", "D", 1);
        graph.addConnection("B", "D", 4);

        // Path A -> B -> C -> D should be chosen (2 + 1 + 1 = 4)
        assertEquals(4, graph.findShortestPath("A", "D"));
    }

    @Test
    void findShortestPath_nonExistingCities() {
        Graph graph = new Graph();
        graph.addCity("cityA");
        graph.addCity("cityB");

        // Query for a non-existing city
        assertEquals(-1, graph.findShortestPath("cityA", "nonExistingCity"));
        assertEquals(-1, graph.findShortestPath("nonExistingCity", "cityB"));
    }

    @Test
    void findShortestPath_directPathShorterThanViaAnotherCity() {
        Graph graph = new Graph();
        graph.addCity("X");
        graph.addCity("Y");
        graph.addCity("Z");

        graph.addConnection("X", "Y", 10);
        graph.addConnection("X", "Z", 5);
        graph.addConnection("Z", "Y", 3);

        // Path X -> Z -> Y (5 + 3 = 8) is shorter than X -> Y (10)
        assertEquals(8, graph.findShortestPath("X", "Y"));
    }

    @Test
    void findShortestPath_complexGraph() {
        Graph graph = new Graph();
        graph.addCity("A");
        graph.addCity("B");
        graph.addCity("C");
        graph.addCity("D");
        graph.addCity("E");

        graph.addConnection("A", "B", 1);
        graph.addConnection("B", "C", 2);
        graph.addConnection("C", "D", 1);
        graph.addConnection("D", "E", 3);
        graph.addConnection("A", "E", 10);

        // Shortest path: A -> B -> C -> D -> E (1 + 2 + 1 + 3 = 7)
        assertEquals(7, graph.findShortestPath("A", "E"));
    }

}
