package graph;

import java.util.Iterator;

import TestUtil.In;

public class Digraph {

	private final int V;
	private int E;
	private Bag<Integer>[] adj;

	public Digraph(int V) {
		this.V = V;
		adj = (Bag<Integer>[]) new Bag[V];
		for (int i = 0; i < V; i++) {
			adj[i] = new Bag<Integer>();
		}
	}

	public Digraph(In in) {
		V = Integer.parseInt(in.nextln());
		adj = (Bag<Integer>[]) new Bag[V];
		for (int i = 0; i < V; i++) {
			adj[i] = new Bag<Integer>();
		}
		int E = Integer.parseInt(in.nextln());
		String line = null;
		for (int i = 0; i < E; i++) {
			line = in.nextln();
			String[] splits = line.trim().split("\\s+");
			this.addEdge(Integer.parseInt(splits[0]),
					Integer.parseInt(splits[1]));
		}
	}

	public int V() {
		return V;
	}

	public int E() {
		return E;
	}

	public void addEdge(int v, int w) {
		adj[v].add(w);
		E++;
	}

	public Iterable<Integer> adj(int v) {
		return adj[v];
	}

	public int outdegree(int v) {
		return adj[v].size();
	}

	public Digraph reverse() {
		Digraph reverse = new Digraph(this.V);
		for (int v = 0; v < V; v++) {
			for(int w: adj(v)){
				reverse.addEdge(w, v);
			}
		}
		return reverse;
	}

	public String toString() {
		StringBuilder sb=new StringBuilder();
		String NEWLINE=System.getProperty("line.separator");
		sb.append(V+" vertices, "+E+" edges "+NEWLINE);
		for(int v=0;v<V;v++){
			sb.append(String.format("%d: ",v));
			for(int w:adj(v)){
				sb.append(String.format("%d ",w));
			}
			sb.append(NEWLINE);
		}
		return sb.toString();
	}
}
