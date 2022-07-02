package easy;

import requiredClassesForSome.TreeNode;

public/**
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
class Id543 {
    private int maxBranchesAroundRoot = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        findHeight(root);
        return maxBranchesAroundRoot;
    }
    
    public int findHeight(TreeNode root){
        if(root==null)return -1;
        
        int leftSubtreeBranches = findHeight(root.left);
        int rightSubtreeBranches = findHeight(root.right);
        
        int currBranchesAroundRoot = leftSubtreeBranches + 1 + rightSubtreeBranches + 1;
        maxBranchesAroundRoot = Math.max(maxBranchesAroundRoot,currBranchesAroundRoot);
        
        return Math.max(leftSubtreeBranches, rightSubtreeBranches) + 1;
        
    }
}
