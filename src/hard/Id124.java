package hard;

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
class Id124 {
    int maxPathSum=Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        currMaxPathSum(root);
        return maxPathSum;
    }
    
    //Variation of kadane algo
    //Since this is a tree rather than array, there isn't only a maxSumPrevIdx (ie left subtree)
    //there is also right subtree, and both subtrees
    private int currMaxPathSum(TreeNode root){
        if(root==null)return 0;
        
        int leftSubTreeSum = currMaxPathSum(root.left);
        int rightSubTreeSum = currMaxPathSum(root.right);
        
        int currMax=max(root.val, leftSubTreeSum+root.val, rightSubTreeSum+root.val, leftSubTreeSum+rightSubTreeSum+root.val);
        maxPathSum=Math.max(maxPathSum,currMax);
        
        //I don't include leftSubTreeSum+rightSubTreeSum+root.val as that will violate definition of path 
        //when computing maxPathSum in the parent node, the root node will be traversed twice
        return max(root.val, leftSubTreeSum+root.val, rightSubTreeSum+root.val);
    }
    private int max(int... arr){
        int max=arr[0];
        for(int i=1; i<= arr.length-1;i++){
            max=Math.max(max,arr[i]);
        }
        return max;
    }
}