package medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

import requiredClassesForSome.TreeNode;

public class Id102 {
	public List<List<Integer>> levelOrder(TreeNode root) {
		if (root == null)return Collections.emptyList();
		
		Deque<TreeNode> queue = new ArrayDeque<>();
		TreeNode curr;
		int numNodesAtLevel;

		List<List<Integer>> nodesByLevel = new ArrayList<>();
		List<Integer> nodesOnCurrLevel = new ArrayList<>();

		queue.offerLast(root);

		while (!queue.isEmpty()) {
			numNodesAtLevel = queue.size();

			for (int i = 1; i <= numNodesAtLevel; i++) {
				curr = queue.pollFirst();
				nodesOnCurrLevel.add(curr.val);
				if (curr.left != null) {
					queue.offerLast(curr.left);
				}
				if (curr.right != null) {
					queue.offerLast(curr.right);
				}
			}

			nodesByLevel.add(nodesOnCurrLevel);
			nodesOnCurrLevel = new ArrayList<>();
		}

		return nodesByLevel;
	}
}
