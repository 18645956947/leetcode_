package zhx.day20190305;

import zhx.day1224.ListNode;

/** 
* @author lenovo
* @date 2019��3��5������10:21:28 
* @Description: 876. ������м���
* 
*/
public class MiddleNode {
	public ListNode middleNode(ListNode head) {
        ListNode p = head;
        int num = 0;
        if(head.next == null){
            return head;
        }
        while(p != null){
            num++;
            p = p.next;
        }
        ListNode q = head;
        for(int i = 0;i<num/2;i++){
            q = q.next;
        }
        return q;
    }
}
 