class Solution {
    public int removeDuplicates(int[] nums) {
    	int number = 0;
        for(int i = 0;i<nums.length;i++){
        	if(nums[i]!=nums[number]){
        		number++;
        		nums[number] = nums[i];
        	}
        }
        number+=1;
		return number;
    }
    public static void main(String[] args){
        int []num = new int[]{1,5,0,0,1,2};
        Solution so = new Solution();
        System.out.println(so.removeDuplicates(num));
    }
}