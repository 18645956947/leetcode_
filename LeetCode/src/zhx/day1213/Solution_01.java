package zhx.day1213;
/**
 * ����һ������ nums����дһ������������ 0 �ƶ��������ĩβ
 * ͬʱ���ַ���Ԫ�ص����˳��
 * @author zhx
 *ά��һ��INDEX ������¼����Ԫ��
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

