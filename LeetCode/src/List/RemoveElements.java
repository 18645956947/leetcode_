package List; 

/** 
* @author lenovo
* @date 2019年3月11日下午6:37:44 
* @Description: 
*/
public class RemoveElements {
	public ListNode removeElements(ListNode head, int val) {
        ListNode newNode = new ListNode(-1);
        ListNode p = newNode;
        newNode.next = head;
        while(p.next != null){
            if(p.next.val == val){
                p.next = p.next.next;
            }
            else
                p = p.next;
        }
        return newNode.next;
        
    }
}
 