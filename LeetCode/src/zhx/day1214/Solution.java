package zhx.day1214;

public class Solution {
	/**
	 * Ðý×ªÍ¼Ïñ
	 * @param matrix
	 */
	public void rotate(int[][] matrix) {
        
    }
	public static void main(String[] args) {
		int[][] num1 = new int[3][3];
		int[][] num = new int[][] {
			{1,2,3},
			{4,5,6},
			{7,8,9}
		};
		for(int i = 0;i<num.length;i++) {
			for(int j = 0;j<num.length;j++) {
				System.out.print(num[i][j]);
			}
			System.out.println();
		}
		System.out.println("----------------");
		for(int i = 0;i<num.length;i++) {
			for(int j = 0;j<num.length;j++) {
				num1[j][i] = num[i][j];
			}
		}
		for(int i = 0;i<num.length;i++) {
			for(int j = 0;j<num.length;j++) {
				System.out.print(num1[i][j]);
			}
			System.out.println();
		}
		Solution s1 = new Solution();
		s1.rotate(num);
	}

}
