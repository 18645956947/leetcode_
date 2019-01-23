package zhx.day20190123; 

import static org.junit.Assert.assertNotNull;

import javax.print.attribute.standard.RequestingUserName;

import zhx.day20190108.TreeNode;
/** 
* @author lenovo
* @date 2019��1��23������9:48:59 
* @Description: ���Գƶ�����
*/
public class Solution {
	public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }  
        return check(root.left, root.right);
        
    }
	public boolean check(TreeNode lNode, TreeNode rNode) {
		if (lNode == null && rNode == null) {
			return true;
		}
		else if(lNode != null && rNode != null) {
			if(lNode.val != rNode.val) {
				return false;
			}
			else {
				return check(lNode.left, rNode.right)&&check(lNode.right, rNode.left);
			}
		}	
		return false;
	}
	
	
	
}
 