package zhx.day20190102;

import zhx.day1224.ListNode;;
/** 
* @author lenovo
* @date 2019年1月2日上午9:52:45 
* @Description: 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，
* 你将只被给定要求被删除的节点。
*现有一个链表 -- head = [4,5,1,9]，它可以表示为:
*4 -> 5 -> 1 -> 9
*/
public class Solution {
	public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
 