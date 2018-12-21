package zhx.day1218;

import java.util.List;

import javax.swing.text.AbstractDocument.LeafElement;

import java.util.ArrayList;

public class Solution {
	
	public String longestCommonPrefix(String[] strs) {
		if(strs.length<=1) {
			return "";
		}
		String temp = strs[0];
		for(int i = 0;i<strs.length;i++) {
			if(temp.length()>strs[i].length()) {
				temp = strs[i];
			}
		}
		for(int i = temp.length();i>0;i--) {
			boolean mz = true;
			temp = temp.substring(0, i);
			for(int j = 0;j<strs.length;j++) {
				mz = mz&&strs[j].substring(0, j).equals(temp);
			}
			if(mz) {
				System.out.println("¹«¹²ÊÇ" + temp);
				return temp;
			}
		}
		return "";
    }
	public static void main(String[] args) {
		String[] str = new String[] {"flo", "fltty","fl8g"};
		Solution solution = new Solution();
		solution.longestCommonPrefix(str);
	}
}
