package zhx.day1224;

public class Solution {
	public ListNode reverseList(ListNode head) {
		ListNode newHead = null;

	    // ����ȡ��������ƶ�ͷ�ڵ�
	    // ����ͷ�ڵ����ӵ���ͷ�ڵ����
	    while (head != null) {
	        // ����ȡ����һ���ڵ�
	        ListNode next = head.next;
	        // ��ͷ�ڵ����ӵ���ͷ�ڵ����
	        head.next = newHead;
	        newHead = head;
	        // ����ƶ�ͷ�ڵ�
	        head = next;
	    }
	    return newHead;
	}
	public static void main(String[] args) {
		
	}
}
