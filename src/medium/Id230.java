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
//Instead of doing O(n) to collect elements in array while inorder
//Just track the number of elements visited in inorder
//Once this number == k, we got our element
public class Id230 {
    private int numElemVisited = 0;
    private int ans = 0;
    public int kthSmallest(TreeNode root, int k) {
        inorder(root,k);
        return ans;
    }
    
    public void inorder(TreeNode root, int k) {
       if(root==null)return;
        
        inorder(root.left,k);
        numElemVisited++;
        
        if(numElemVisited==k){
            ans = root.val;
            return;
        }
        
        inorder(root.right,k);
    }
}