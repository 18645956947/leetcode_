package zhx.day20190108; 

/** 
* @author lenovo
* @date 2019��1��8������4:57:35 
* @Description: 
*/
public class Solution {
	public int maxDepth(TreeNode root) {
		if(root == null) {
			return 0;
		}
		int results = Math.max(maxDepth(root.left), maxDepth(root.right))+1;
		
		return results;
        
    }
}
 