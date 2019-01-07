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
		while(tem != null) {
			len++;
			tem = tem.next;
		}
		if(head==null) {
			return null;
		}
		//计算正向的位置m
		int m = len-n+1;
		if(m==1) {
			return head.next;
		}
		tem = head;
		int k = 0;
		while(tem!=null) {
			k++;
			if(k==m-1) {
				tem.next = tem.next.next;
			}
            
			tem = tem.next;
		}
		return head;
    }
}
 