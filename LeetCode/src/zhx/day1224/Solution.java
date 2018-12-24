package zhx.day1224;

public class Solution {
	public ListNode reverseList(ListNode head) {
		ListNode newHead = null;

	    // 不断取出和向后移动头节点
	    // 并将头节点连接到新头节点后面
	    while (head != null) {
	        // 单独取出下一个节点
	        ListNode next = head.next;
	        // 将头节点连接到新头节点后面
	        head.next = newHead;
	        newHead = head;
	        // 向后移动头节点
	        head = next;
	    }
	    return newHead;
	}
	public static void main(String[] args) {
		
	}
}
