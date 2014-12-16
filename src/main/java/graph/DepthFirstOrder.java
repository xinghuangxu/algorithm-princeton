package graph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class DepthFirstOrder {

	private boolean[] marked;

	private int[] pre;
	private int[] post;

	private Queue<Integer> preorder;
	private Queue<Integer> postorder;

	private int preCounter;
	private int postCounter;

	public DepthFirstOrder(Digraph G) {
		marked = new boolean[G.V()];
		pre = new int[G.V()];
		post = new int[G.V()];
		preorder = new ArrayDeque<Integer>();
		postorder = new ArrayDeque<Integer>();
		for (int v = 0; v < G.V(); v++) {
			if (!marked[v]) {
				dfs(G, v);
			}
		}
	}

	private void dfs(Digraph G, int v) {
		marked[v] = true;
		preorder.add(v);
		pre[v] = preCounter++;
		for (int w : G.adj(v)) {
			if (!marked[w]) {
				dfs(G, w);
			}
		}
		postorder.add(v);
		post[v] = postCounter++;

	}

	public Iterable<Integer> reversePost() {
		Deque<Integer> reverse = new ArrayDeque<Integer>();
		for (int v : postorder) {
			reverse.push(v);
		}
		return reverse;
	}

	public Integer pre(int v) {
		return pre[v];
	}

	public Integer post(int v) {
		return post[v];
	}

	public Iterable<Integer> pre() {
		return preorder;
	}

	public Iterable<Integer> post() {
		return postorder;
	}

}
