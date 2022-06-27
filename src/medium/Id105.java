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
public class Id105 {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeRecursive(preorder,0 ,preorder.length-1, inorder,0 ,inorder.length-1);
    }
    
    public TreeNode buildTreeRecursive(int[] preorder,int preStart, int preEnd, int[] inorder,int inStart, int inEnd) {
        if(preStart>preEnd || inStart>inEnd)return null;
        
        TreeNode root = new TreeNode(preorder[preStart]);
        int rootIdxInOrder = 0;
        for(int i=inStart; i<=inEnd; i++){
            if(inorder[i]==root.val){
                rootIdxInOrder=i;
                break;
            }
        }
        
        int leftSubTreeSize = rootIdxInOrder - inStart;
        
        root.left = buildTreeRecursive(preorder,preStart+1,preStart+leftSubTreeSize,inorder,inStart,rootIdxInOrder-1);
        root.right = buildTreeRecursive(preorder,preStart+leftSubTreeSize+1,preEnd,inorder,rootIdxInOrder+1,inEnd);
        
        return root;
    }
}
