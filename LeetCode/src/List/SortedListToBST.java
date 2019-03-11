package List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import javax.security.auth.callback.LanguageCallback;

/** 
* @author lenovo
* @date 2019年3月11日下午2:44:24 
* @Description: 109. 有序链表转换二叉搜索树
*/
public class SortedListToBST {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) {
        	return null;
        }
        else return toBST(head, null);
    }
    private TreeNode toBST(ListNode head, ListNode tail) {
    	ListNode slow = head;
    	ListNode fast = head;
    	if(head == tail) {
    		return null;
    	}
    	//利用快慢指针 查找链表中间节点
    	while(fast != tail && fast.next != tail) {
    		fast = fast.next.next;
    		slow = slow.next;
    	}
    	//树的先序遍历
    	TreeNode tNode = new TreeNode(slow.val);
    	tNode.left = toBST(head, slow);
    	tNode.right = toBST(slow.next, tail);
    	return tNode;
    }
}
 