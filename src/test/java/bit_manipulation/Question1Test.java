package bit_manipulation;

import junit.framework.TestCase;

public class Question1Test extends TestCase {

	public void test() {
		int n = Integer.parseInt("10000000000", 2);
		int m = Integer.parseInt("10101", 2);
		int i = 2, j = 6;
		int output = updateBits(n, m, i, j);
		assertTrue(output == Integer.parseInt("10001010100", 2));
	}

	public static int updateBits(int n, int m, int i, int j) {
		int max=~0;
		int left=max<<(j+1);
		int right=(1<<i)-1;
		
		int mask=left|right;
		
		return (n&mask)|m<<i;
	}
}
