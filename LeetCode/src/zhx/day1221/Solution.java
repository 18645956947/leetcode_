package zhx.day1221;

public class Solution {
	/**
	 * leetcode-字符串转换整数 (atoi)
	 * @param str
	 * @return 
	 * 1
	 */
	public int myAtoi(String str) {
		//判断第一个整数元素下标
		int index = 0;
		//正数为1 负数为-1
		int flag = 1;
		//转换后的数字
		int base = 0;
		//判断数字是否为空
		if (str.isEmpty()) return 0;
		while(index<str.length() && str.charAt(index) == ' ') {
			index++;
		}
		if (index < str.length() && (str.charAt(index) == '+' || str.charAt(index) == '-'))
			flag = str.charAt(index++) == '-' ? -1 : 1;
		
		while(index < str.length() && str.charAt(index) >= '0' && str.charAt(index) <= '9') {
			// 溢出判断，MAX_VALUE的个位为7
            if (base > Integer.MAX_VALUE / 10 || (base == Integer.MAX_VALUE / 10 && str.charAt(index) - '0' > 7))
                if (flag == 1)
                    return Integer.MAX_VALUE;
                else
                    return Integer.MIN_VALUE;
            //char-'0' 变成Int 类型
			base = base * 10 + str.charAt(index++) - '0';
		}
		System.out.println(base * flag);
		return base * flag;
	}
	public static void main(String[] args) {
		Solution solution =  new Solution();
		String str = "4193 with words";
		solution.myAtoi(str);

	}

}
