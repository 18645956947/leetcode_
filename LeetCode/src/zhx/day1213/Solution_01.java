package zhx.day1213;
/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾
 * 同时保持非零元素的相对顺序。
 * @author zhx
 *维护一个INDEX 用来记录非零元素
 *1
 */
public class Solution_01 {
	
	public void moveZeroes(int[] nums) {
		int index = 0;
		for(int i = 0;i<nums.length;i++) {
			if(nums[i] != 0) {
				nums[index] = nums[i];
				index++;
			}
		}
		while(index<nums.length) {
			nums[index++]= 0; 
		}
	}
	public static void main(String[] args) {
		int[] num = new int[] {0,1,0,3,12};
		Solution_01 d2 = new Solution_01();
		d2.moveZeroes(num);
	}

}

