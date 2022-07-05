package medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

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
public class Id199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightSide = new ArrayList<>();
        if(root==null)return rightSide;
        
        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.offerLast(root);
        rightSide.add(dq.peekLast().val);
        
        int numOfNodesOnLevel = 0;
        
        while(!dq.isEmpty()){
            numOfNodesOnLevel = dq.size();
            
            for(int i=1; i<=numOfNodesOnLevel; i++){
                root = dq.pollFirst();
                if(root.left!=null)dq.offerLast(root.left);
                if(root.right!=null)dq.offerLast(root.right);
            }
            
            if(dq.peekLast()!=null)rightSide.add(dq.peekLast().val);
        }
        
        return rightSide;
    }
}