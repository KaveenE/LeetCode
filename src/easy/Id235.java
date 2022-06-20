package easy;

import requiredClassesForSome.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class Id235 {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		
		//Point which which p/q live of different sides of  root. ATP, root is LCA
		if ((p.val < root.val && q.val > root.val) || (q.val < root.val && p.val > root.val)) {

		}
		//If any root same as P/Q same, that's LCA
		else if(p.val == root.val || q.val == root.val) {
			
		}
		//Recurse left
		else if ((p.val < root.val && q.val < root.val)) {
			root = lowestCommonAncestor(root.left, p, q);
		} //Recurse right 
		else if ((p.val > root.val && q.val > root.val)) {
			root = lowestCommonAncestor(root.right, p, q);
		}

		return root;
	}
}
