package easy;

import java.util.ArrayDeque;
import java.util.Deque;

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

public class Id226 {
	public TreeNode invertTree(TreeNode root) {
		if (root == null)
			return root;

		TreeNode tempLeft = null;
		TreeNode currNode = null;

		Deque<TreeNode> dq = new ArrayDeque<>();
		dq.offerLast(root);

		while (!dq.isEmpty()) {
			currNode = dq.pollFirst();

			tempLeft = currNode.left;
			currNode.left = currNode.right;
			currNode.right = tempLeft;

			if (currNode.left != null) {
				dq.offerLast(currNode.left);
			}

			if (currNode.right != null) {
				dq.offerLast(currNode.right);
			}
		}

		return root;
	}
	
	public TreeNode invertTree1(TreeNode root) {
		if (root == null)
			return root;
		else {
			TreeNode tempRight = root.right;
			root.right = invertTree(root.left);
			root.left = invertTree(tempRight);
			return root;
		}
		

	}
}
