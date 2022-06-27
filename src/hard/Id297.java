package hard;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

import requiredClassesForSome.TreeNode;

public class Id297 {
	// Encodes a tree to a single string.
    public String serialize1(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preorder(root,sb);
        return sb.toString();
    }
    
    private void preorder(TreeNode root,StringBuilder sb) {
        if(root==null){
            sb.append("null ");
        }
        else{
            sb.append(root.val+" ");
            preorder(root.left, sb);
            preorder(root.right, sb);
        }
    }
   
    // Decodes your encoded data to tree.
    public TreeNode deserialize1(String data) {
        Deque<String> dataDelimited = new LinkedList<>(Arrays.asList(data.split(" ")));
        //Collections.reverse(dataDelimited);
        
        return deserialize1Helper(dataDelimited);
        
    }
                                                       
    public TreeNode deserialize1Helper(Deque<String> dataDelimited) {
        String data = dataDelimited.pollFirst();
        
        if(data.equals("null"))return null;
        
        TreeNode root = new TreeNode(Integer.valueOf(data));
        root.left = deserialize1Helper(dataDelimited);
        root.right = deserialize1Helper(dataDelimited);
        
        return root;
        
    }
    
 // Encodes a tree to a single string.
    public String serialize2(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        
        Deque<TreeNode> dq = new LinkedList<>();
        dq.offerLast(root);
        TreeNode curr;
        while(!dq.isEmpty()){
            curr = dq.pollFirst();
            
            if(curr==null){
                sb.append("null ");
                continue;
            }
                
            sb.append(curr.val+" ");
            dq.offerLast(curr.left);
            dq.offerLast(curr.right);
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize2(String data) {
        String[] dataDelimited = data.split(" ");
        if(dataDelimited[0].equals("null")) return null;
        
        Deque<TreeNode> dq = new ArrayDeque<>();
        TreeNode root = new TreeNode(Integer.valueOf(dataDelimited[0]));
        dq.offerLast(root);
        
        TreeNode curr;
        int i=1;
        while(i<=dataDelimited.length-1){
            curr = dq.pollFirst();
            
            if(!dataDelimited[i].equals("null")){    
                TreeNode left = new TreeNode(Integer.valueOf(dataDelimited[i]));
                curr.left = left;
                dq.offerLast(left);                
            }
            i++;
            
            if(!dataDelimited[i].equals("null")){
                TreeNode right = new TreeNode(Integer.valueOf(dataDelimited[i]));
                curr.right = right;
                dq.offerLast(right);
            }
            i++;
        }
        
        return root;       
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));