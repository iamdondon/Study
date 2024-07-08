package search;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph graph = new Graph(6);
		graph.addEdge(0, 1);
		graph.addEdge(0, 3);
		graph.addEdge(1, 4);
		graph.addEdge(3, 2);
		graph.addEdge(3, 5);
		
		graph.printGraph();
		
		graph.dfs();
		System.out.println();
		graph.dfs(1);
		System.out.println();
		graph.bfs(0);
	}
}
