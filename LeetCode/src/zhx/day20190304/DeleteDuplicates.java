package zhx.day20190304; 

/** 
* @author lenovo
* @date 2019年3月4日下午4:27:02 
* @Description: 83. 删除排序链表中的重复元素
* 有序链表的去重（前一个与后一个相互比较）
*/
public class DeleteDuplicates {
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode p = head;
        while(p.next!=null){
            if(p.val == p.next.val){
                p.next = p.next.next;
            }
            else{
                p = p.next;
            }
        }
        return head;
    }
}
 