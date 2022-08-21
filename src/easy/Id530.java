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
public class Id530 { 
     public int getMinimumDifference(TreeNode root) {
        Pair prevAndMin = new Pair();
    	inorder(root, prevAndMin);
    	return prevAndMin.min;
    }
    
    private void inorder(TreeNode root, Pair prevAndMin) {
    	if (root == null) return;
    	
    	inorder(root.left, prevAndMin);
    	
        if (prevAndMin.prev != null) {
    		prevAndMin.min = Math.min(prevAndMin.min, 
                                      Math.abs(root.val - prevAndMin.prev.val));
    	}
        prevAndMin.prev = root;
    	
        inorder(root.right,prevAndMin);    	
    }
   
    private static class Pair {
        TreeNode prev;
        int min = Integer.MAX_VALUE;
    }
}

