package zhx.day20190102;

import zhx.day1224.ListNode;;
/** 
* @author lenovo
* @date 2019��1��2������9:52:45 
* @Description: ���дһ��������ʹ�����ɾ��ĳ�������и����ģ���ĩβ���ڵ㣬
* �㽫ֻ������Ҫ��ɾ���Ľڵ㡣
*����һ������ -- head = [4,5,1,9]�������Ա�ʾΪ:
*4 -> 5 -> 1 -> 9
*/
public class Solution {
	public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
 