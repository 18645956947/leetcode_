package zhx.day20190103; 

import zhx.day1224.ListNode;;
/** 
* @author lenovo
* @date 2019年1月3日上午9:36:12 
* @Description: 将两个有序链表合并为一个新的有序链表并返回。
* 新链表是通过拼接给定的两个链表的所有节点组成的
*/
public class Solution {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode head = null;
		if(l1 == null) {
			return l2;
		}
		if(l2 == null) {
			return l1;
		}
		if(l1.val <= l2.val) {
			head=l1;
			l1 = l1.next;
		}
		else {
			head = l2;
			l2 = l2.next;
		}
		ListNode temp = head;
		while(l1 != null && l2 != null) {
			if(l1.val <= l2.val) {
				temp.next = l1;
				l1 = l1.next;
			}
			else {
				temp.next = l2;
				l2 = l2.next;
			}
			temp = temp.next;
		}
		if(l1==null) {
			temp.next = l2;
		}
		if(l2==null) {
			temp.next = l1;
		}
		return head;  
	}
}
 