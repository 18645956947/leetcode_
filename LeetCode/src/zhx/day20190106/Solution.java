package zhx.day20190106; 

import java.awt.List;

import zhx.day1224.ListNode;
/** 
* @author lenovo
* @date 2019年1月6日下午12:38:17 
* @Description: 
*/
public class Solution {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		int len = 0;
		ListNode tem = head;
		while(tem.next != null) {
			len++;
			tem = tem.next;
		}
		if(head==null) {
			return null;
		}
		//计算正向的位置m
		int m = len-n+1;
		if(m==1&&len==1) {
			return null;
		}
		tem = head;
		int k = 1;
		while(tem!=null) {
			
			if(k==m) {
				tem.next = tem.next.next;
			}
            k++;
			tem = tem.next;
		}
		return head;
    }
}
 