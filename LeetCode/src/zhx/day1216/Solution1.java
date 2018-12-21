package zhx.day1216;

public class Solution1 {
	 public int reverse(int x) {
	       long x1 = 0L;
			while(x != 0){
				x1 = x1 * 10 + x % 10;
				x /= 10;
			}
			return x1 == (int) x1 ? (int) x1 :  0;
	    }
	public static void main(String[] args) {
		Solution1 s1 = new Solution1();
		int num = -123456789;
		System.out.println(s1.reverse(num));
	}
}
