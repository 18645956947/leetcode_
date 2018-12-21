package zhx.day1219;

import org.w3c.dom.CDATASection;

public class Solution_1 {
	
	public int firstUniqChar(String s) {
		char[] ch = s.toCharArray();
		
		for(int i = 0;i<ch.length;i++) {
			boolean isUnique = true;
			for(int j = 0;j<ch.length;j++) {
				if(i != j&&ch[i] == ch[j]) {
					isUnique = false;
					break;
				}
			}
			if(isUnique) {
				System.out.println(i); 
				return i;
			}
		}
		
		return -1;
	}
	public static void main(String[] args) {
		String str = "loveleetcode";
		Solution_1 solution = new Solution_1();
		solution.firstUniqChar(str);

	}

}
