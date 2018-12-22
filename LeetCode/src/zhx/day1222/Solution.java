package zhx.day1222;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.print.attribute.HashAttributeSet;
/**
 *  µœ÷strStr()
 * @author lenovo
 *
 */
public class Solution {
	
	public int strStr(String haystack, String needle) {
		if(needle.isEmpty()){
            return 0;
        }
		else if(haystack.length() < needle.length()) {
        	return -1;
        }
		int dis = haystack.length() - needle.length();
        for(int i = 0;i<=dis;i++) {
        	if(haystack.substring(i, i+needle.length()).equals(needle)) {
        		System.out.println(i);//"mississippi", "pi"
        		return i;
        	}
        }
        return -1;
    }
	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.strStr("mississippi", "pi");

	}
}
