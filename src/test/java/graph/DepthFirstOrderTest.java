package graph;

import TestUtil.StdOut;
import generic.TestCaseWithResource;
import junit.framework.TestCase;

public class DepthFirstOrderTest extends TestCaseWithResource {
	
	public DepthFirstOrderTest() {
		super("/graph/tinyDAG.txt");
		// TODO Auto-generated constructor stub
	}

	public void testMain(){
		Digraph G = new Digraph(this.testResource);

        DepthFirstOrder dfs = new DepthFirstOrder(G);
        StdOut.println("   v  pre post");
        StdOut.println("--------------");
        for (int v = 0; v < G.V(); v++) {
            StdOut.printf("%4d %4d %4d\n", v, dfs.pre(v), dfs.post(v));
        }

        StdOut.print("Preorder:  ");
        for (int v : dfs.pre()) {
            StdOut.print(v + " ");
        }
        StdOut.println();

        StdOut.print("Postorder: ");
        for (int v : dfs.post()) {
            StdOut.print(v + " ");
        }
        StdOut.println();

        StdOut.print("Reverse postorder: ");
        for (int v : dfs.reversePost()) {
            StdOut.print(v + " ");
        }
        StdOut.println();

	}
}
