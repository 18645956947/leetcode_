package zhx.day20190304; 

/** 
* @author lenovo
* @date 2019��3��4������4:27:02 
* @Description: 83. ɾ�����������е��ظ�Ԫ��
* ���������ȥ�أ�ǰһ�����һ���໥�Ƚϣ�
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
 