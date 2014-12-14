package graph;

public class KosarajuSharirSCC {
	private boolean[] marked; // reached vertices
	private int[] id; // component identifier
	private int count; // number of components

	public KosarajuSharirSCC(Digraph G) {
		
	}

	private void dfs(Digraph G, int v) {
		
	}

	public boolean stronglyConnected(int v, int w) {
		return id[v] == id[w];
	}
	
	public int id(int v){
		return id[v];
	}
	
	public int count(){
		return this.count;
	}
}
