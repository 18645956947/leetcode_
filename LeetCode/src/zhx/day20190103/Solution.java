package zhx.day20190103; 

import zhx.day1224.ListNode;;
/** 
* @author lenovo
* @date 2019��1��3������9:36:12 
* @Description: ��������������ϲ�Ϊһ���µ������������ء�
* ��������ͨ��ƴ�Ӹ�����������������нڵ���ɵ�
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
 