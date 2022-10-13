package medium;

import requiredClassesForSome.TreeNode;

import java.util.ArrayList;
import java.util.List;

//O(n) space is with inorder -> Store vals in arr -> modify it accordingly
//O(1) space by using revInorder.
class Id1038 {
    int postfixSum=0;
    public TreeNode bstToGst(TreeNode root) {
//        List<TreeNode> arr = new ArrayList<>();
//         inorder(root,arr);

//         int currPostfixSum=0, prevPostfixSum=0;
//         TreeNode curr;
//         for(int i=arr.size()-1; i>=0; i--){
//             curr = arr.get(i);
            
//             currPostfixSum=curr.val+prevPostfixSum;
//             curr.val=curr.val+prevPostfixSum;
//             prevPostfixSum=currPostfixSum;
//         }
        
        revInorder(root);
        return root;
    }
    
    public void inorder(TreeNode root, List<TreeNode> inorderArr){
        if(root==null)return;
        
        inorder(root.left,inorderArr);
        inorderArr.add(root);
        inorder(root.right,inorderArr);
    }
    
    public void revInorder(TreeNode root){
        if(root==null)return;
        
        revInorder(root.right);
        root.val+=postfixSum;
        postfixSum=root.val;
        revInorder(root.left);
    }
}