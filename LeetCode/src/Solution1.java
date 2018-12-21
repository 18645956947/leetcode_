
public class Solution1 {
	
	public int singleNumber(int[] nums) {
		int numb = 0;
		for(int i = 0;i<nums.length;i++){
			numb = numb ^ nums[i];
		}
		return numb;
    }
	public static void main(String[] args) {
		Solution1 s1 = new Solution1();
		int []num = new int[]{2,2,3,4,5,4,5,7,7};
		System.out.println(s1.singleNumber(num));//Êä³ö3

	}

}
