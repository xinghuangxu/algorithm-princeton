package graph;

import generic.TestCaseWithResource;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

import junit.framework.Assert;
import junit.framework.TestCase;

public class KosarajuSharirSCCTest extends TestCaseWithResource {
	public KosarajuSharirSCCTest(){
		super("/graph/tinyDG.txt");
	}
	

	public void testAlgorithm() {
		KosarajuSharirSCC scc = new KosarajuSharirSCC();
		String line="";
		while((line = this.testResource.nextln())!=null){
			System.out.println(line);
		}
	}
}
