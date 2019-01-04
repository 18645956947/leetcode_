package zhx.day20190104; 

import java.util.Stack;

import zhx.day1224.ListNode;
/** 
* @author lenovo
* @date 2019年1月4日上午10:55:35 
* @Description: 回文链表 
*/
public class Solution {
	
	public boolean isPalindrome(ListNode head) {
		Stack<ListNode> stack = new Stack<ListNode>();
		if(head==null||head.next==null) {
			return true;
		}
		ListNode p = head;
		while(p != null) {
			stack.push(p);
			p = p.next;
		}
		ListNode qListNode = head;
		while(qListNode != null) {
			if (qListNode.val != stack.pop().val) {
				return false;
			}
			qListNode = qListNode.next;
		}
		return true;
        
    }
}
 