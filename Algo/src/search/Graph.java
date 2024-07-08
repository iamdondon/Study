package search;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

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
    
    public void dfsUtil(int cur, boolean visited[]) {
    	visited[cur] = true;
    	System.out.print(cur+" ");
    	for(int next : adjList[cur]) {
    		if(!visited[next]) dfsUtil(next, visited);
    	}
    }
    
    public void dfs() {
    	boolean visited[] = new boolean[numVertices];
    	for(int i=0; i<numVertices; i++) {
    		if(!visited[i]) dfsUtil(i, visited);
    	}
    }
    
    public void dfs(int start) {
    	boolean visited[] = new boolean[numVertices];
    	dfsUtil(start, visited);
    }
    
    public void bfs(int start) {
    	boolean visited[] = new boolean[numVertices];
    	Queue<Integer> queue = new ArrayDeque<Integer>();
    	queue.add(start);
    	
    	while(!queue.isEmpty()) {
    		int cur = queue.poll();
    		visited[cur] = true;
    		System.out.print(cur+" ");
    		for(int next : adjList[cur]) {
    			if(!visited[next]) queue.add(next);
    		}
    	}
    }
}
