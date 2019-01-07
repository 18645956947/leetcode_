package zhx.day1224;


public class ListNode {
	public int val;
	public ListNode next;
	public ListNode(int data) { this.val = data; }
	public void printListNode(ListNode head) {
		if(head==null) {
			return;
		}
		ListNode cur = head;
		System.out.println("原链表数据为：");
		System.out.println("---------");
		while(cur != null) {
			System.out.print(cur.val);
			cur = cur.next;
		}
		System.out.println();
		System.out.println("---------");
	}
	/*
	 * @Override public String toString() { return String.valueOf(this.val); }
	 */

}
