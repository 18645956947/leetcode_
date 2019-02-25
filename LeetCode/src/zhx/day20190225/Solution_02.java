package zhx.day20190225;

import org.omg.PortableServer.ID_ASSIGNMENT_POLICY_ID;

/** 
* @author lenovo
* @date 2019��2��25������10:37:27 
* @Description: 198. ��ҽ���  �Ե�����
* �Ҿ����Ե����ϵķ���������Щ����Ҫ�Ǳ߽����⣬Ȼ��Ϳ�ʼһ��һ���Ƶ����ҳ��Ժ�Ĺ�ϵ
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
 