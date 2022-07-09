package hard;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Id127 {

//	//Slow
//	//O(n^2*m+n+e), m=length of longest word, n=size of wordlist
	//n^2*m is just from init graph
//    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//        
//        //neighbors are words differing by 1 letter
//        Map<String,List<String>> graph = new HashMap<>();
//        
//        wordList.add(0,beginWord);
//        
//        //init graph
//        boolean endWordInList = false;
//        for(int base=0; base<=wordList.size()-1; base++){
//            if(wordList.get(base).equals(endWord))endWordInList=true;
//            
//            for(int comparedTo=base+1; comparedTo<=wordList.size()-1; comparedTo++){
//                if(differsBy1Letter(wordList.get(base),wordList.get(comparedTo))){
//                    graph.computeIfAbsent(wordList.get(base), _x->new ArrayList<>());
//                    graph.get(wordList.get(base)).add(wordList.get(comparedTo));
//                    
//                    graph.computeIfAbsent(wordList.get(comparedTo), _x->new ArrayList<>());
//                    graph.get(wordList.get(comparedTo)).add(wordList.get(base));
//                   
//                }
//            }
//        }
//        
//        if(!endWordInList)return 0;
//        
//        
//        Set<String> visited = new HashSet<>();
//        Map<String,String> predecessor = new HashMap<>();
//        
//        bfs(graph, beginWord, visited, predecessor, endWord);
//        int edgesInShortestSeq = shortestSeq(predecessor,endWord);
//        
//        return edgesInShortestSeq==0? 0: edgesInShortestSeq+1;
//        
//    }
//    
//    private void bfs(Map<String,List<String>> graph, String src, Set<String> visited,Map<String,String> predecessor, String endWord){
//        Deque<String> dq = new ArrayDeque<>();
//        List<String> neighbors;
//        
//        dq.offerLast(src);
//        visited.add(src);
//        
//        while(!dq.isEmpty()){
//            src = dq.pollFirst();
//
//            neighbors = graph.get(src);
//            if(neighbors==null)continue;
//            
//            for(String neighbor: neighbors){
//                if(visited.add(neighbor)){
//                    predecessor.put(neighbor,src);
//                    dq.offerLast(neighbor);
//                }
//            }
//        }
//
//    }
	
	//Faster
	//Instead of wasting n^2*m on constructing graph, construct neighbors of a vertex on the fly taking O(m^2)
	//Complexity = O(V+E) = O(n+m^2)
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {

		Set<String> wordSet = wordList.stream().collect(Collectors.toSet());
		if (!wordSet.contains(endWord))return 0;

		Set<String> visited = new HashSet<>();
		int edgesInShortestSeq = bfs(beginWord, visited, endWord, wordSet);

		return edgesInShortestSeq == 0 ? 0 : edgesInShortestSeq + 1;

	}

	private int bfs(String src, Set<String> visited, String endWord, Set<String> wordSet) {
		Deque<String> dq = new ArrayDeque<>();
		List<String> neighbors;

		dq.offerLast(src);
		visited.add(src);

		int nodesOnLevel = 0;
		int edgesToEndWord = 0;

		while (!dq.isEmpty()) {
			nodesOnLevel = dq.size();

			for (int i = 1; i <= nodesOnLevel; i++) {
				src = dq.pollFirst();

				neighbors = neighbors(src, wordSet);
				if (neighbors == null)continue;

				for (String neighbor : neighbors) {
					if (visited.add(neighbor)) {
						dq.offerLast(neighbor);
					}
				}
			}

			edgesToEndWord++;

			if (visited.contains(endWord))
				return edgesToEndWord;

		}

		return 0;
	}

	private List<String> neighbors(String src, Set<String> wordSet) {
		StringBuilder sb = new StringBuilder(src);
		String strForsb;
		List<String> neighbors = new ArrayList<>();

		for (int newLetterIdx = 0; newLetterIdx <= src.length() - 1; newLetterIdx++) {
			// Try out diff letters for each idx
			for (char c = 'a'; c <= 'z'; c++) {
				sb.setCharAt(newLetterIdx, c);
				strForsb = sb.toString();
				if (wordSet.contains(strForsb.toString()) && differsBy1Letter(strForsb, src))
					neighbors.add(strForsb);
			}
			// Reset sb
			sb.setCharAt(newLetterIdx, src.charAt(newLetterIdx));
		}

		return neighbors;
	}

	private int shortestSeq(Map<String, String> predecessor, String to) {
		if (predecessor.get(to) == null) {
			return 0;
		}

		return shortestSeq(predecessor, predecessor.get(to)) + 1;
	}

	private boolean differsBy1Letter(String s1, String s2) {
		return differsByXLetters(s1, s2, 1);
	}

	private boolean differsByXLetters(String s1, String s2, int x) {
		if (s1.equals(s2))
			return false;
		if (s1.length() != s2.length())
			return false;

		int lettersDiffered = 0;

		for (int i = 0; i <= s1.length() - 1; i++) {
			if (s1.charAt(i) != s2.charAt(i)) {
				lettersDiffered++;
			}
			if (lettersDiffered > x) {
				return false;
			}
		}

		return true;
	}
}
