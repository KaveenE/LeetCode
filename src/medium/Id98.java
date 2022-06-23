package medium;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

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

public class Id98 {
	 public boolean isValidBST(TreeNode root) {
	        List<Integer> inOrderTraveral = new ArrayList<>();
	        
	        inOrder(root,inOrderTraveral);

	        boolean notValid = IntStream
	            .range(1,inOrderTraveral.size())
	            .anyMatch(idx ->  inOrderTraveral.get(idx-1) >= inOrderTraveral.get(idx));
	        
	        return !notValid;

	    }
	    
	    public void inOrder (TreeNode root,List<Integer> inOrderTraveral) {
	        if(root == null) return;
	        
	        inOrder(root.left,inOrderTraveral);
	        inOrderTraveral.add(root.val);
	        inOrder(root.right,inOrderTraveral);
	    }
	    
	    
		/* 
		   //Leetcode solution where space is O(1)
		    
		   public boolean isValidBST1(TreeNode root) { 
		   	return isValidBST1Helper(root, Long.MIN_VALUE, Long.MAX_VALUE); 
		   }
		   
		   public boolean isValidBST1Helper(TreeNode root, long minVal, long maxVal) {
			   if (root == null) return true; 
			   if (root.val >= maxVal || root.val <= minVal) return false; 
			   return isValidBST1Helper(root.left, minVal, root.val) && isValidBST1Helper(root.right, root.val, maxVal); 
		   }
		 */
}
