package divide_and_conquer;

import java.util.Arrays;

public class MaximumSubArray {

	private int[] problemArray;

	public MaximumSubArray(int[] anArray) {
		this.problemArray = anArray;
	}

	/*
	 * 
	 * return (left-max,right-max,sum)
	 */
	public int[] findMaximumSubArray(int low,int high){
		if(low==high){
			return new int[]{low,high,this.problemArray[low]};
		}else{
			int mid=(high+low)/2;
			int[] leftSide=this.findMaximumSubArray(low, mid);
			int[] rightSide=this.findMaximumSubArray(mid+1, high);
			int[] cross=this.findMaximumCrossSubArray(low,mid,high);
			if(leftSide[2]>=rightSide[2]&&leftSide[2]>=cross[2]){
				return leftSide;
			}else if(rightSide[2]>=leftSide[2]&&rightSide[2]>=cross[2]){
				return rightSide;
			}else{
				return cross;
			}
		}
	}
	


	private int[] findMaximumCrossSubArray(int low, int mid, int high) {
		int sum=0;
		int leftMax=mid;
		int leftSum=Integer.MIN_VALUE;
		for(int i=mid;i>=low;i--){
			sum+=this.problemArray[i];
			if(sum>leftSum){
				leftSum=sum;
				leftMax=i;
			}
		}
		sum=0;
		int rightSum=Integer.MIN_VALUE;
		int rightMax=mid+1;
		for(int i=mid+1;i<=high;i++){
			sum+=this.problemArray[i];
			if(sum>rightSum){
				rightSum=sum;
				rightMax=i;
			}
		}
		return new int[]{leftMax,rightMax,leftSum+rightSum};
	}

	public int[] solve() {
		// TODO Auto-generated method stub
		int[] result= this.findMaximumSubArray(0,this.problemArray.length-1);
		return Arrays.copyOfRange(this.problemArray, result[0],result[1]+1);
	}

}
