package zhx.day20190225; 

/** 
* @author lenovo
* @date 2019年2月25日上午10:34:04 
* @Description: 198. 打家劫舍 备忘录方法
* 动态规划问题，初始化一个数组来记录所有记录为-1，如果当前index被算过，就记录下来。因此，每次判断该屋抢还是不抢后，都会得到一个index值。
* 这就是去冗余，用采用空间换时间的方法。因此当n-1房屋的最优解算过后，就能推导出n房屋的最优解。 
*/
public class Solution {
	 public static int result[];
	    public int solve(int index, int[] nums){
	        if(index < 0){
	            return 0;
	        }
	         if(result[index] >= 0){
	             return result[index];
	         }
	        result[index] = Math.max(nums[index] + solve(index - 2, nums), solve(index - 1, nums));
	        return result[index];
	    }

	    public int rob(int[] nums) {
	        result = new int[nums.length];
	        for(int i = 0;i< nums.length;i++){
	            result[i] = -1;
	        }
	        return solve(nums.length-1, nums);
	    }
}
 