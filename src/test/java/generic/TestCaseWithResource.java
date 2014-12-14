package generic;
import junit.framework.TestCase;


public class TestCaseWithResource extends TestCase{
	protected String resourceName="";
	
	protected TestResource testResource;
	
	public TestCaseWithResource(String resourceName){
		super();
		this.resourceName=resourceName;
		this.testResource=new TestResource(this.resourceName);
	}
}
