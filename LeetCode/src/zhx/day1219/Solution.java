package zhx.day1219;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Solution {
	
	public int firstUniqChar(String s) {
		Map<Character,Integer> map = new LinkedHashMap<Character,Integer>();
		char[] ch=s.toCharArray();
		for(int i = 0;i<ch.length;i++) {
			if(!map.containsKey(ch[i])) {
				map.put(ch[i], i);
			}
			map.put(ch[i], -1);
		}
		for(Map.Entry<Character,Integer> entry : map.entrySet()) {
			if(entry.getValue() != -1) {
				System.out.println(entry.getKey());
				return entry.getKey();
			}
		}
		return -1;    
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "leetcode";
		Solution solution = new Solution();
		solution.firstUniqChar(str);
	}

}
