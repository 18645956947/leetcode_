package zhx.day20190306;

import java.util.HashSet;
import java.util.Set;

import zhx.day1224.ListNode;

/** 
* @author lenovo
* @date 2019��3��6������9:40:07 
* @Description: 141. ��������
*/
public class HasCycle {
	//�ⷨһ�����ÿ���ָ��ʱ��ĸ��Ӷ�O(1),�ռ临�Ӷ�O(n)
	public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow  = head;
        while(head == null|| head.next == null){
            return false;
        }
        while(fast.next != null&&fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            
            if(fast == slow){
                return true;
            }            
        }
        return false;
    }
	
	//�ⷨ��  ����set���� ʱ��ĸ��Ӷ�O(n),�ռ临�Ӷ�O(n)
	public boolean hasCycle_01(ListNode head) {
		Set<ListNode> set = new HashSet<>();
		ListNode node = head;
		if(head == null || head.next == null) {
			return false;
		}
		while(node != null) {
			if(set.contains(node)) {
				return true;
			}
			else {
				set.add(node);
			}
			node = node.next;
		}
		return false;
	}
}
 