import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Trie {
	//Each node can have pointers to maximum of 26 characters
	private static final int CHAR_SIZE = 26;
	private TrieNode root;
	
	public Trie() {
		root = new TrieNode();
	}
	
	private class TrieNode {
		private boolean isKeyedImplString;
	    private List<TrieNode> children;
	    
	    public TrieNode() {
			this.isKeyedImplString = false;;
			this.children = new ArrayList<>(Collections.nCopies(CHAR_SIZE, null));
		}
	}
    
    
    
    public void insert(String word) {
    	TrieNode current = root;
    	int charId = 0;
    	
    	//Form implicit keyed string 
    	//by traversing the children and inserting nodes appropriately
    	for(int idx=0; idx<=word.length()-1; idx++) {
    		charId = word.charAt(idx) - 'a';
        	if(current.children.get(charId)==null) {
        		current.children.set(charId, new TrieNode());
        	}
        	current = current.children.get(charId);
        }
    	
    	//End of implicit key string
        current.isKeyedImplString = true;
    }
    
    public boolean search(String word, boolean searchPrefixOnly) {
    	TrieNode current = root;
    	int charId = 0;
    	
    	//Search implicit keyed string 
    	//by traversing the children
    	for(int idx=0; idx<=word.length()-1; idx++) {
    		charId = word.charAt(idx) - 'a';
        	if(current.children.get(charId)==null) {
        		return false;
        	}
        	current = current.children.get(charId);
        }
    	
    	return searchPrefixOnly ? true :current.isKeyedImplString;
    }
    
    public boolean search(String word) {
    	return search(word,false);
    }
    
    public boolean startsWith(String word) {
    	return search(word,true);
    }}
