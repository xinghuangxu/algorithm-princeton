package generic;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

import TestUtil.In;


public class TestResource implements In{
	
	private BufferedReader bf;

	public TestResource(String resourcePath){
		URL url = this.getClass().getResource(resourcePath);
		try {
			FileReader testWsdl = new FileReader(url.getFile());
			this.bf=new BufferedReader(testWsdl);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String nextln(){
		try {
			return this.bf.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
