package graph;

import generic.TestCaseWithResource;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.ResourceBundle;

import TestUtil.StdOut;
import junit.framework.Assert;
import junit.framework.TestCase;

public class KosarajuSharirSCCTest extends TestCaseWithResource {
	public KosarajuSharirSCCTest(){
		super("/graph/tinyDG.txt");
	}

	public void testAlgorithm() {
		Digraph g=new Digraph(this.testResource);
		KosarajuSharirSCC scc = new KosarajuSharirSCC(g);
		int M=scc.count(); //number of connected components;
		assertEquals(M,5);
		
		// compute list of vertices in each strong component
        Queue<Integer>[] components = (Queue<Integer>[]) new Queue[M];
        for (int i = 0; i < M; i++) {
            components[i] = new ArrayDeque<Integer>();
        }
        for (int v = 0; v < g.V(); v++) {
            components[scc.id(v)].add(v);
        }

        // print results
        for (int i = 0; i < M; i++) {
            for (int v : components[i]) {
                StdOut.print(v + " ");
            }
            StdOut.println();
        }

//		String line="";
//		while((line = this.testResource.nextln())!=null){
//			System.out.println(line);
//		}
	}
}
