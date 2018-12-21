package zhx.day1213;

import java.util.HashSet;
/**
 * 用HashSet判断数组是否重复
 * @author zhouhaixin
 *@version1.0
 *1
 */
public class Solution {
	public boolean containsDuplicate(int[] nums) {
		HashSet<Integer> h1 = new HashSet<Integer>();
		for(int i = 0;i<nums.length;i++) {
			if(h1.contains(nums[i])) {
				return true;
			}
			else {
				h1.add(nums[i]);
			}
		}
		return false;
	}
	public static void main(String[] args) {
		Solution s1 = new Solution();
		int[] num = new int[] {1,1,1,3,3,4,3,2,4,2};//true
		s1.containsDuplicate(num);
	}

}
