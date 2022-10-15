package medium;

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

//For any 2 nodes on same path from root-to-leaf, they must be anscestor-children
//Thus record max/min along a path and return the max absolute difference
//Return it on base case
class Id1026 {
    public int maxAncestorDiff(TreeNode root) {
        return maxDiffHelper(root,0,Integer.MAX_VALUE);
    }
    
    public int maxDiffHelper(TreeNode root, int currMax, int currMin){
        if(root==null)return Math.abs(currMax-currMin);
        
        int absRoot = Math.abs(root.val);
        
        currMax=Math.max(absRoot, currMax);
        currMin=Math.min(absRoot, currMin);
        
        int leftMaxDiff=maxDiffHelper(root.left, currMax, currMin);
        int rightMaxDiff=maxDiffHelper(root.right, currMax, currMin);
        
        return Math.max(leftMaxDiff,rightMaxDiff);
    }
}

