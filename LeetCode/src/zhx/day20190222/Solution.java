package zhx.day20190222;

import static org.junit.jupiter.api.Assumptions.assumingThat;

import java.util.Arrays;

/** 
* @author lenovo
* @date 2019年2月22日上午10:12:21 
* @Description: 数组的最大子序和
*/
public class Solution {
	static int max = Integer.MIN_VALUE;
	public int maxSubArray(int[] nums) {
		int sum;
		for(int i = 0;i<nums.length;i++) {
			for(int j = i;j<nums.length;j++) {
				sum = 0;
				for(int k = i;k<=j;k++) {
					sum += nums[k];
				}
				if(sum > max) {
					max = sum;
				}
			}
		}
		return max;
    }
	
	public int maxSubArray_01(int[] nums) {
		int n = nums[0];
		int sum = nums[0];
		for(int i = 1;i<nums.length;i++) {
			if(n > 0) {
				n += nums[i];
			}
			else {
				n = nums[i];
			}
			if(sum < n) {
				sum = n;
			}
		}
		return sum;
		
		
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] nums = new int[] {-2,1,-3,4,-1,2,1,-5,4};

		System.out.println(solution.maxSubArray_01(nums));
	}
}
 