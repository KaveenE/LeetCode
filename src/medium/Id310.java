package medium;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

//"Toposort" with BFS but the leaves ie indegree 0
//BFS using the algo where you grp up nodes on each level
//Once tree has has 1 or 2 nodes left, those nodes are the MHTs
public class Id310 {
  public List<Integer> findMinHeightTrees(int n, int[][] edges) {
      if(n==1)return List.of(0);
      
      Map<Integer,Set<Integer>> graph = new HashMap<>();
      int[] indegrees = new int[n];
      
      for(int[] edge: edges){
          graph.computeIfAbsent(edge[0], _key->new HashSet<>()).add(edge[1]);
          indegrees[edge[1]]++;
          graph.computeIfAbsent(edge[1], _key->new HashSet<>()).add(edge[0]);
          indegrees[edge[0]]++;
      }
      
      Deque<Integer> dq = new ArrayDeque<>();
      //Push the leaves in
      for(int i=0; i<=indegrees.length-1; i++)if(indegrees[i]==1)dq.offerLast(i);
      if(dq.size()==n)return List.copyOf(dq);
      
      int curr=0;
      int numNodesOnLevel=0;
      int nodesLeft=n;
      while(!dq.isEmpty()){
          numNodesOnLevel = dq.size();
          for(int i=1; i<= numNodesOnLevel; i++){
              curr = dq.pollFirst();
              nodesLeft--;
              
              for(Integer neighbor: graph.get(curr)){
                  indegrees[neighbor]--;
                  if(indegrees[neighbor]==1){
                      dq.offerLast(neighbor);
                  }
              }   
          }
          
          if(nodesLeft<=2)break;
      }
     
      return List.copyOf(dq);
  }
}