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

public class Id110 {
	private int notBalancedFlag = -2;
    public boolean isBalanced(TreeNode root) {
        if(root==null){
            return true;
        }
        
        return height(root)!= notBalancedFlag;

    }
    
     public int height(TreeNode root) {
        if(root==null){
            return -1;
        }
        else{
            int leftHeight = height(root.left);
            int rightHeight = height(root.right);
            
            if(Math.abs(leftHeight-rightHeight) > 1){
                return notBalancedFlag;
            }
            
            if(leftHeight == notBalancedFlag|| rightHeight == notBalancedFlag){
                return notBalancedFlag;
            }
            
            return Math.max(leftHeight,rightHeight)+1;
        }
        
    }
}
