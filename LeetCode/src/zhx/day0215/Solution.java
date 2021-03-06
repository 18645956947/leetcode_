package zhx.day0215;

import java.util.Arrays;

import javax.print.attribute.standard.MediaName;

/** 
* @author lenovo
* @date 2019年2月15日上午10:04:28 
* @Description: 合并两个有序数组
* 思路就是两个数组从后往前开始比较 大的就放在nums1数组的最后，以此类推，最后再判断下两个数组是否都为空，
* 因为数组是有序的，所以直接把剩下的放在nums1中即可
*/
public class Solution {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1;
        int j = n-1;
        int k = m+n-1;
        while(i>=0 && j >= 0) {
        	if(nums1[i] > nums2[j]) {
        		nums1[k] = nums1[i];
        		i--;
        		
        	}
        	else if(nums1[i] < nums2[j]) {
        		nums1[k] = nums2[j];
        		j--;
        	}
        	k--;
        }
        while(i>=0) {
        	nums1[k] = nums1[i];
        	i--;
        	k--;
        }
        while(j>=0) {
        	nums1[k] = nums2[j];
        	j--;
        	k--;
        }
        
    }
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] A = {1,2,3,0,0,0};
		int[] B = {4,5,6};
		solution.merge(A,3,B,3);
		System.out.println(Arrays.toString(A));
		
		
	}
}
 