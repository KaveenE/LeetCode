package medium;

import requiredClassesForSome.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
public class Id236 {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		return lcaHelper(root, p, q);
	}

	public TreeNode lcaHelper(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null)
			return null;
		if (root == p || root == q)
			return root;

		TreeNode left = lcaHelper(root.left, p, q);
		TreeNode right = lcaHelper(root.right, p, q);

		// If the subtrees contain the p,q = this node is lca
		if (left != null && right != null)
			return root;
		// if one subtree is null, that means both p,q live in the other subtree and 
		// lca is in that subtree
		else if (left != null)
			return left;
		else
			return right;

	}
}
