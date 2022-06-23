package easy;

import requiredClassesForSome.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class Id104 {
	public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        else{
            int leftHeight = maxDepth(root.left);
            int rightHeight = maxDepth(root.right);

            return Math.max(leftHeight,rightHeight)+1;
        }
        
    }
}
