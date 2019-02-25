package zhx.day20190225; 

/** 
* @author lenovo
* @date 2019��2��25������10:34:04 
* @Description: 198. ��ҽ��� ����¼����
* ��̬�滮���⣬��ʼ��һ����������¼���м�¼Ϊ-1�������ǰindex��������ͼ�¼��������ˣ�ÿ���жϸ��������ǲ����󣬶���õ�һ��indexֵ��
* �����ȥ���࣬�ò��ÿռ任ʱ��ķ�������˵�n-1���ݵ����Ž�����󣬾����Ƶ���n���ݵ����Ž⡣ 
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
 