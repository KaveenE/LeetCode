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
public class Id106 {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
        int[] postorderRev = new int[postorder.length];
        for(int i=0; i<=postorder.length-1; i++){
            postorderRev[i]=postorder[postorder.length-1-i];
        }
        return buildTreeRecursive(postorderRev,0 ,postorderRev.length-1, inorder,0 ,inorder.length-1);
    }
    
    public TreeNode buildTreeRecursive(int[] postorderRev,int postStart, int preEnd, int[] inorder,int inStart, int inEnd) {
        if(postStart>preEnd || inStart>inEnd)return null;
        
        TreeNode root = new TreeNode(postorderRev[postStart]);
        int rootIdxInOrder = 0;
        for(int i=inStart; i<=inEnd; i++){
            if(inorder[i]==root.val){
                rootIdxInOrder=i;
                break;
            }
        }
        
        int rightSubTreeSize = inEnd - rootIdxInOrder;
        
        root.right = buildTreeRecursive(postorderRev,postStart+1,postStart+rightSubTreeSize,inorder,rootIdxInOrder+1,inEnd);
        root.left = buildTreeRecursive(postorderRev,postStart+rightSubTreeSize+1,preEnd,inorder,inStart,rootIdxInOrder-1);
        
        return root;
    }
}
