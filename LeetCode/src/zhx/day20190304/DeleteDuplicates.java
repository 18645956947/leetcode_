package zhx.day20190304; 

/** 
* @author lenovo
* @date 2019年3月4日下午4:27:02 
* @Description: 
*/
public class DeleteDuplicates {
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
 