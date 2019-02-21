package zhx.day0221; 

/** 
* @author lenovo
* @date 2019年2月21日下午10:16:40 
* @Description: 爬楼梯
*/
public class Solution {
	
	 public int climbStairs(int n) {
	     if(n<1) {
	    	  return 0;
	     }
		 if(n == 1) {
			 return 1;
		 }
		 
		 if(n == 2) {
			 return 2;
		 }
		 int a = 1;
		 int b = 2;
		 int temp = 0;
		 for(int i = 3;i <= n;i++) {
			 temp = a+b;
			 a = b;
			 b = temp;
		 }
		 return temp;
	 }
}
 