package graph;

import java.util.ArrayDeque;
import java.util.Queue;

public class BreadthFirstDirectedPaths {

	private static final int INFINITY = Integer.MAX_VALUE;
	private boolean[] marked;
	private int[] edgeTo;
	private int[] distTo;

	public BreadthFirstDirectedPaths(Digraph G, int s) {
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		distTo = new int[G.V()];
		for (int v = 0; v < G.V(); v++) {
			distTo[v] = INFINITY;
		}
		bfs(G,s);
	}

	private void bfs(Digraph G, int s) {
		Queue<Integer> queue=new ArrayDeque<Integer>();
		marked[s]=true;
		distTo[s]=0;
		queue.add(s);
		while(queue.peek()!=null){
			int v=queue.poll();
			for(int w: G.adj(v)){
				if(!marked[w]){
					queue.add(w);
					marked[w]=true;
					distTo[w]=distTo[v]+1;
					edgeTo[w]=v;
				}
			}
		}
	}
}
