package zhx.day1216;


public class Solution {
	
	public String reverseString(String s) {
		if(s.length()<1 || s==null) return s;
		char[] s2 = s.toCharArray();
		char t1 = 0;
		for(int i = 0;i<s2.length/2;i++) {
			t1 = s2[i];
			s2[i] = s2[s2.length-i-1];
			s2[s2.length-i-1] = t1;
		}
		return String.valueOf(s2);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "A man, a plan, a canal: Panama";
		
		/*for(int i = 0;i<s2.length;i++) {
			System.out.println(s2[1]);
		}*/
		Solution s1 = new Solution();
		s1.reverseString(s);
	}

}
