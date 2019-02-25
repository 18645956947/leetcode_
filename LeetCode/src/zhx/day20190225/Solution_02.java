package zhx.day20190225;

import org.omg.PortableServer.ID_ASSIGNMENT_POLICY_ID;

/** 
* @author lenovo
* @date 2019年2月25日上午10:37:27 
* @Description: 198. 打家劫舍  自底向上
* 我觉得自底向上的方法更好想些，主要是边界问题，然后就开始一步一步推导，找出以后的关系
*/
public class Solution_02 {
	public int rob(int[] nums) {
		if(nums.length == 0){
			return 0;
		}
		else if(nums.length == 1) {
			return nums[0];
		}
		else if(nums.length == 2) {
			return Math.max(nums[0], nums[1]);
		}
		
		int result[] = new int[nums.length];
		result[0] = nums[0];
		result[1] = Math.max(nums[0], nums[1]);
		
		for(int index= 2;index<nums.length;index++) {
			result[index] = Math.max(result[index-2] + nums[index], result[index-1]);
		}
		return result[nums.length-1];
	}
}
 