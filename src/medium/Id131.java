package medium;

import java.util.ArrayList;
import java.util.List;

class Id131 {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        
        partitionBT(res, new ArrayList<>(), s, 0);
        
        return res;
    }
    
    public void partitionBT(List<List<String>> res, List<String> state, String input, int stackIdx){
        if(stackIdx==input.length()){
            res.add(List.copyOf(state));
            return;
        }
        
        for(int i=stackIdx; i<=input.length()-1; i++){
            if(!isPal(input,stackIdx,i))continue;
            
            state.add(input.substring(stackIdx,i+1));
            partitionBT(res, state, input, i+1);
            state.remove(state.size()-1);
        }
    }
    
    private boolean isPal(String str, int start, int end){
        while(start<end){
            if(str.charAt(start)!=str.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        
        return true;
    }
}