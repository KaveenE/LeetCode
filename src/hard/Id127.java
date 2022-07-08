package hard;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Id127 {
	
	//Slow
	//O(n^2*m+n+e), m=length of longest word, n=size of wordlist
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        //neighbors are words differing by 1 letter
        Map<String,List<String>> graph = new HashMap<>();
        
        wordList.add(0,beginWord);
        
        //init graph
        boolean endWordInList = false;
        for(int base=0; base<=wordList.size()-1; base++){
            if(wordList.get(base).equals(endWord))endWordInList=true;
            
            for(int comparedTo=base+1; comparedTo<=wordList.size()-1; comparedTo++){
                if(differsBy1Letter(wordList.get(base),wordList.get(comparedTo))){
                    graph.computeIfAbsent(wordList.get(base), _x->new ArrayList<>());
                    graph.get(wordList.get(base)).add(wordList.get(comparedTo));
                    
                    graph.computeIfAbsent(wordList.get(comparedTo), _x->new ArrayList<>());
                    graph.get(wordList.get(comparedTo)).add(wordList.get(base));
                   
                }
            }
        }
        
        if(!endWordInList)return 0;
        
        
        Set<String> visited = new HashSet<>();
        Map<String,String> predecessor = new HashMap<>();
        
        bfs(graph, beginWord, visited, predecessor, endWord);
        int edgesInShortestSeq = shortestSeq(predecessor,endWord);
        
        return edgesInShortestSeq==0? 0: edgesInShortestSeq+1;
        
    }
    
    private void bfs(Map<String,List<String>> graph, String src, Set<String> visited,Map<String,String> predecessor, String endWord){
        Deque<String> dq = new ArrayDeque<>();
        List<String> neighbors;
        
        dq.offerLast(src);
        visited.add(src);
        
        while(!dq.isEmpty()){
            src = dq.pollFirst();

            neighbors = graph.get(src);
            if(neighbors==null)continue;
            
            for(String neighbor: neighbors){
                if(visited.add(neighbor)){
                    predecessor.put(neighbor,src);
                    dq.offerLast(neighbor);
                }
            }
        }

    }
    
    private int shortestSeq(Map<String,String> predecessor, String to){
        if(predecessor.get(to)==null){
            return 0;
        }
        
        return shortestSeq(predecessor,predecessor.get(to)) + 1;
    }
    
    private boolean differsBy1Letter(String s1, String s2){
        return differsByXLetters(s1,s2,1);
    }
    private boolean differsByXLetters(String s1, String s2, int x){
        if(s1.equals(s2))return false;
        if(s1.length()!=s2.length())return false;
        
        int lettersDiffered = 0;
        
        for(int i=0; i<=s1.length()-1; i++){
            if(s1.charAt(i)!=s2.charAt(i)){
                lettersDiffered++;
            }
            if(lettersDiffered > x){
                return false;
            }
        }
        
        return true;
    }
}
