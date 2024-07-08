package search;

import java.util.LinkedList;

public class Graph {
    private int numVertices;
    private LinkedList<Integer>[]adjList;

    // Constructor
    public Graph(int numVertices) {
        this.numVertices = numVertices;
        adjList = new LinkedList[numVertices];
        for (int i = 0; i < numVertices; i++) {
            adjList[i]= new LinkedList<>();
        }
    }

    // Add an edge to the graph
    public void addEdge(int source, int destination) {
        adjList[source].add(destination);
        adjList[destination].add(source); // For undirected graph
    }

    // Remove an edge from the graph
    public void removeEdge(int source, int destination) {
        adjList[source].remove(Integer.valueOf(destination));
        adjList[destination].remove(Integer.valueOf(source));
    }

    // Print the graph
    public void printGraph() {
        for (int i = 0; i < numVertices; i++) {
            System.out.print("Vertex " + i + ":");
            for (Integer vertex : adjList[i]) {
                System.out.print(" -> " + vertex);
            }
            System.out.println();
        }
    }

}
