package medium;

import java.util.HashMap;
import java.util.Map;

import requiredClassesForSome.Node;

/*
//Definition for a Node.
class Node {
 public int val;
 public List<Node> neighbors;
 public Node() {
     val = 0;
     neighbors = new ArrayList<Node>();
 }
 public Node(int _val) {
     val = _val;
     neighbors = new ArrayList<Node>();
 }
 public Node(int _val, ArrayList<Node> _neighbors) {
     val = _val;
     neighbors = _neighbors;
 }
}
*/

public class Id133 {

	// BFS/DFS graph->As you traverse, clone every unvisited node
	// Clone only value NOT neighbors as they will get you reference
	// Update neighbor list as you traverse
	public Node cloneGraph(Node node) {
		if (node == null)
			return node;

		Map<Integer, Node> nodeValToNode = new HashMap<>();
		Node copy = new Node(node.val);

		dfs(node, copy, nodeValToNode);

		return copy;
	}

	public void dfs(Node node, Node copy, Map<Integer, Node> nodeValToNode) {
		nodeValToNode.put(copy.val, copy);

		Node neighborCopy = null;
		for (Node neighbor : node.neighbors) {

			if (nodeValToNode.containsKey(neighbor.val)) {
				copy.neighbors.add(nodeValToNode.get(neighbor.val));
			} else {
				neighborCopy = new Node(neighbor.val);
				copy.neighbors.add(neighborCopy);
				dfs(neighbor, neighborCopy, nodeValToNode);
			}
		}
	}
}
