package graph;

public class KosarajuSharirSCC {
	private boolean[] marked; // reached vertices
	private int[] id; // component identifier
	private int count; // number of components

	public KosarajuSharirSCC(Digraph G) {
		
		DepthFirstOrder dfs = new DepthFirstOrder(G.reverse());
		id = new int[G.V()];
		marked=new boolean[G.V()];
		for (int v : dfs.reversePost()) {
			if (!marked[v]) {
				dfs(G, v);
				count++;
			}
		}
	}

	private void dfs(Digraph G, int v) {
		marked[v]=true;
		id[v]=count;
		for(int w: G.adj(v)){
			if(!marked[w])dfs(G,w);
		}
	}

	public boolean stronglyConnected(int v, int w) {
		return id[v] == id[w];
	}

	public int id(int v) {
		return id[v];
	}

	public int count() {
		return this.count;
	}
}
