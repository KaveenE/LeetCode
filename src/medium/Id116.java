package medium;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.ArrayDeque;

class Id116 {
    public Node connect(Node root) {
        if(root==null)return null;
        //bfs(root);
        dfs(root,null);
        return root;
    }
    
    //O(n) space
    public void bfs(Node root){
        Deque<Node> q = new ArrayDeque<>();
        Deque<Node> qForCurrLevel = new ArrayDeque<>();
        q.offerLast(root);
        
        Node curr;
        int nodesOnCurrLevel=0;
        while(!q.isEmpty()){
            nodesOnCurrLevel = q.size();
            
            for(int i=1; i<=nodesOnCurrLevel; i++){
                curr = q.removeFirst();
                qForCurrLevel.offerLast(curr);

                if(curr.left!=null)q.offerLast(curr.left);
                if(curr.right!=null)q.offerLast(curr.right);
            }
            
            while(!qForCurrLevel.isEmpty())qForCurrLevel.removeFirst().next=qForCurrLevel.peekFirst();
            
        }
    }
    
    //O(1) space exlcuding rec stack
    public void dfs(Node curr, Node next){
        if(curr==null)return;
        
        curr.next=next;
        dfs(curr.left,curr.right);
        dfs(curr.right,curr.next==null ? null : curr.next.left);
    }
}

// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};