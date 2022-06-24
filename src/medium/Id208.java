package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Id208 {
	 class Trie {
		//Each node can have pointers to maximum of 26 characters
		private static final int CHAR_SIZE = 26;
	 
	    private boolean isKeyedImplString;
	    private List<Trie> children;
	    
	    public Trie() {
			this.isKeyedImplString = false;;
			this.children = new ArrayList<>(Collections.nCopies(CHAR_SIZE, null));
		}
	    
	    
	    public void insert(String word) {
	    	Trie current = this;
	    	int charId = 0;
	    	
	    	//Form implicit keyed string 
	    	//by traversing the children and inserting nodes appropriately
	    	for(int idx=0; idx<=word.length()-1; idx++) {
	    		charId = word.charAt(idx) - 'a';
	        	if(current.children.get(charId)==null) {
	        		current.children.set(charId, new Trie());
	        	}
	        	current = current.children.get(charId);
	        }
	    	
	    	//End of implicit key string
	        current.isKeyedImplString = true;
	    }
	    
	    public boolean search(String word, boolean searchPrefixOnly) {
	    	Trie current = this;
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
	    }
	    
	 
	}
}

/**
* Your Trie object will be instantiated and called as such:
* Trie obj = new Trie();
* obj.insert(word);
* boolean param_2 = obj.search(word);
* boolean param_3 = obj.startsWith(prefix);
*/
