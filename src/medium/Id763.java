package medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class Id763 {
    
    //O(n) time
    public List<Integer> partitionLabels(String s) {
        List<Integer> partitionSizes = new ArrayList<>();
        
        int[] charToLastIdx = new int[26];
        for(int idx=0; idx<=s.length()-1; idx++){
            charToLastIdx[s.charAt(idx)-'a']=idx;
        }
        
        int partitionEndIdx = 0;
        int partitionStartIdx = 0;
        for(int i = 0; i < s.length(); i++){
            partitionEndIdx = Math.max(partitionEndIdx, charToLastIdx[s.charAt(i)-'a']);
            
            if(partitionEndIdx == i){
                partitionSizes.add(partitionEndIdx - partitionStartIdx + 1);
                partitionStartIdx = partitionEndIdx + 1;
            }
        }
        return partitionSizes;
    }
    
    //O(n^2) time, O(n) space
    public List<Integer> partitionLabels1(String s) {
        
        int[] charToLastIdx = new int[26];
        for(int idx=0; idx<=s.length()-1; idx++){
            charToLastIdx[s.charAt(idx)-'a']=idx;
        }
        
        List<StringBuilder> partitions = new ArrayList<>();
        Set<Character> seen = new HashSet<>();
        
        char curr;
        for(int idx=0; idx<=s.length()-1; idx++){
            curr=s.charAt(idx);
            
            //Either add partition or add curr to current partition
            if(!seen.contains(curr)){
                
                if(partitions.isEmpty()){
                    partitions.add(new StringBuilder());
                    partitions.get(partitions.size()-1).append(curr);
                }
                else{
                    StringBuilder sb = partitions.get(partitions.size()-1);
                    boolean addInSamePartition=false;
                    for(int i=sb.length()-1; i>=0; i--){
                        //if got that particular letter later in string, 
                        //we have to add the curr letter in same partition
                        if(charToLastIdx[sb.charAt(i)-'a']>=idx){
                            partitions.get(partitions.size()-1).append(curr);
                            addInSamePartition=true;
                            break;
                        }
                    }

                    if(!addInSamePartition){
                        partitions.add(new StringBuilder());
                        partitions.get(partitions.size()-1).append(curr);
                    }
                
                }
                
                seen.add(curr);
            }
            else{
                partitions.get(partitions.size()-1).append(curr);
            }
  
        }
        
        return partitions.stream().map(sb->sb.length()).collect(Collectors.toList());
    }
}