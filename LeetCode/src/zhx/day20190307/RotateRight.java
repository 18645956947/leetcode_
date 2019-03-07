package zhx.day20190307; 

/** 
* @author lenovo
* @date 2019年3月7日上午10:22:26 
* @Description: 
*/
public class RotateRight {
	public ListNode rotateRight(ListNode head, int k) {
        ListNode p = head;
        int count=1;
        if(head == null || head.next == null){
            return head;
        }
        while(p.next != null){
            p = p.next;
            count++;
        }
        p.next = head;
        k %= count;
        for(int i = 0;i<count-k;i++){
            p = p.next;
        }
        head = p.next;
        p.next = null;
        return head;
    }
}
 