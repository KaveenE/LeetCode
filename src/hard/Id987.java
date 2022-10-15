package hard;

import requiredClassesForSome.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Id987 {
    private int offsetFromZeroIdx;

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, List<NodeInfo>> vertTraversal = new HashMap<>();
        inorder(root, vertTraversal, 0, 0);
        
        //Convert map to list ordered by the key
        List<List<NodeInfo>> list = vertTraversal.entrySet().stream()
                                                 .sorted((e1,e2)->e1.getKey()-e2.getKey())
                                                 .map(entry->entry.getValue())
                                                 .collect(Collectors.toList());
        
        //Sort the List<NodeInfo> within list
        for (List<NodeInfo> colOfNodes : list) {
            Collections.sort(colOfNodes, Comparator.comparing((NodeInfo node) -> node.row)
                                                   .thenComparing((node) -> node.val));
        }

        return list.stream()
                   .map(colOfNodes->colOfNodes.stream()
                                              .map(nodeInfo -> nodeInfo.val)
                                              .collect(Collectors.toList()))
                   .collect(Collectors.toList());

    }

    public void inorder(TreeNode root, Map<Integer, List<NodeInfo>> vertTraversal, int row, int col) {
        if (root == null) return;

        inorder(root.left, vertTraversal, row + 1, col - 1);
        updateList(vertTraversal, new NodeInfo(row, col, root.val));
        inorder(root.right, vertTraversal, row + 1, col + 1);
    }

    //Initially used a list and not a map. Along with a list, an offSet variable was used
    //Eg: if first node's col was -2 or 3, offset was 2 or -3. This ensures the index in list was 0.
    //Subsequent offset was added to subsequent node's col to be used as index
    //This approach fails when u get a node's col that is lower than the first node's col
    public void updateList(Map<Integer, List<NodeInfo>> vertTraversal, NodeInfo currNode) {
        vertTraversal.computeIfAbsent(currNode.col, _key->new ArrayList<>())
                     .add(currNode);
    }
}

class NodeInfo {
    int row;
    int col;
    int val;

    NodeInfo(int row, int col, int val) {
        this.row = row;
        this.col = col;
        this.val = val;
    }
}