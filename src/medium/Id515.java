package medium;

import requiredClassesForSome.TreeNode;

import java.util.*;

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
class Id515 {
    public List<Integer> largestValues(TreeNode root) {
        if(root==null)return Collections.emptyList();
        
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offerLast(root);
        List<Integer> largestValues = new ArrayList<>();
        
        TreeNode curr;
        int max=Integer.MIN_VALUE;
        
        while(!q.isEmpty()){
            int qSize = q.size();
            
            for(int node=1; node<=qSize; node++){
                curr = q.pollFirst();
                max=Math.max(max, curr.val);
                
                if(curr.left!=null)q.offerLast(curr.left);
                if(curr.right!=null)q.offerLast(curr.right);
            }
            
            largestValues.add(max);
            max=Integer.MIN_VALUE;
        }
        
        return largestValues;
    }
}