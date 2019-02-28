package zhx.day20190228; 

/** 
* @author lenovo
* @date 2019年2月28日上午10:44:45 
* @Description: 72. 编辑距离
*/
public class Solution {
	/*
	 * 动态规划求解
	 */
	public static int minDistance(String word1, String word2) {
		int[][] d = new int [word1.length() + 1][word2.length() + 1];
        if(Math.min(word1.length(), word2.length()) == 0){
           return Math.max(word1.length(), word2.length());
        }
		//行赋值
		for(int i = 0;i<=word1.length();i++) {
			d[i][0] = i;
		}
		//列赋值
		for(int j = 0;j<=word2.length();j++) {
			d[0][j] = j;
		}
		for(int i = 1;i<=word1.length();i++) {
			for(int j = 1;j<=word2.length();j++) {
				if(word1.charAt(i-1) == word2.charAt(j-1)) {
					d[i][j] = d[i-1][j-1];
				}
				else {
					d[i][j] = Math.min(d[i-1][j], 
							Math.min(d[i][j-1], d[i-1][j-1])) + 1;
				}
			}
			
		}
		return d[word1.length()][word2.length()];
	}
	 
	
	
	
	
	/**
	 * 递归方法求解
	 * @param args
	 */
//	 public static int minDistance(String word1, String word2) {
//		 return minDistance_1(word1.toCharArray(), word1.length(), word2.toCharArray(), word2.length());
//
//	 }
//	 private static int minDistance_1(char[] word1, int word1len, char[] word2, int word2len) {
//		 if(Math.min(word1len, word2len) == 0) {
//			 return Math.max(word1len, word2len);
//		 }
//		 else if(word1[word1len-1] == word2[word2len-1]) {
//			 return minDistance_1(word1, word1len-1, word2, word2len-1);
//		 }
//		 
//		 else {
//			return Math.min(minDistance_1(word1, word1len-1, word2, word2len), 
//					Math.min(minDistance_1(word1, word1len-1, word2, word2len-1), 
//							minDistance_1(word1, word1len, word2, word2len-1))) + 1;
//		}
//	 }
	 public static void main(String[] args) {
		String s1 = "abcde";
		String s2 = "abcdefgh";
		System.out.println(Solution.minDistance(s1, s2));
	}
}
 