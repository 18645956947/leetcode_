import java.sql.ResultSetMetaData;

public class Solution4 {
	
	public int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = digits.length - 1; i >= 0; --i) {
            if (digits[i] < 9) {
                ++digits[i];
                return digits;
            }
            digits[i] = 0;
        }
        int[] res = new int[n + 1];
        res[0] = 1;
        for(int i=0;i<res.length;i++) {
        	System.out.println(res[i]);
        }
        return res;
    }
	public static void main(String[] args) {
		Solution4 s1 = new Solution4();
		int[] num = new int[] {4,3,2,1};
		s1.plusOne(num);

	}

}
