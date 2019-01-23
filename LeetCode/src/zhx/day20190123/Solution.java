package zhx.day20190123; 

import static org.junit.Assert.assertNotNull;

import javax.print.attribute.standard.RequestingUserName;

import zhx.day20190108.TreeNode;
/** 
* @author lenovo
* @date 2019年1月23日上午9:48:59 
* @Description: 检查对称二叉树
* 首先了解对称(镜像)二叉树 是什么意思，其实就是左边放一棵树，中间放在一个镜子，
* 你去想像，在镜子里的树会是什么样子，假设根节点是root 那么root.left == 镜子里的 root.right
* root.left.left == 镜子里的 root.right.right  root.left.right == 镜子里的 root.right.left
* 然后就按照自己的逻辑去写代码咯
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
 