package divide_and_conquer;

import java.util.Arrays;

import junit.framework.Assert;
import junit.framework.TestCase;

public class MaximumSubArrayTest extends TestCase {

	public void testAlgorithm() {
		int[] anArray = { -1, 2, 5, -1, 3, -2, 1 };
		MaximumSubArray maximumSubArray = new MaximumSubArray(anArray);
		int[] result = maximumSubArray.solve();

		int[] expectedResult = { 2, 5, -1, 3 };
		Assert.assertTrue(Arrays.equals(expectedResult, result));
	}
}
