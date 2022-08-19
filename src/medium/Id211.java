package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Complexity
//addWord(word): O(k) , k number of letters in word
//search(word): O(26^k) -> Can be made tighter to O(m) where m is all the TrieNodes
class Id211 {
    TrieNode root;
    
    private class TrieNode{
        List<TrieNode> children;
        boolean isImplicitKeyedString;
        
        public TrieNode(){
            children = new ArrayList<>(Collections.nCopies(26, null));
            isImplicitKeyedString = false;
        }
    }
    public Id211() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode curr = root;
        int letterPos;
        for(int idx=0; idx<=word.length()-1; idx++){
            letterPos = word.charAt(idx) - 'a';
            
            if(curr.children.get(letterPos)==null){
                curr.children.set(letterPos, new TrieNode()); 
            }
            
            curr = curr.children.get(letterPos);
        }
        
        curr.isImplicitKeyedString=true;
    }
    
    public boolean search(String word) {
        return searchRec(word, 0, root);
    }
    
    public boolean searchRec(String word, int stackIdx, TrieNode curr){
        if(stackIdx == word.length())return curr.isImplicitKeyedString;
        
        if(word.charAt(stackIdx) == '.'){
            for(int letterPos=0; letterPos <= curr.children.size()-1; letterPos++){
                if(curr.children.get(letterPos)!=null 
                   && searchRec(word, stackIdx+1, curr.children.get(letterPos))){
                    return true; 
                }
            }
        }
        else{
            int letterPos = word.charAt(stackIdx) - 'a';
            return curr.children.get(letterPos)!=null 
                && searchRec(word, stackIdx+1, curr.children.get(letterPos));
        }
        
        return false;
    }
    
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */