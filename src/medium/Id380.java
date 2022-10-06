package medium;

import java.util.*;

class Id380{}
class RandomizedSet {
    private final Map<Integer,Integer> valToIdx;
    private final List<Integer> valsInTheirIdx;
    private final Random randomIdx;

    public RandomizedSet() {
        valToIdx = new HashMap<>();
        valsInTheirIdx = new ArrayList<>();
        randomIdx = new Random();
        
    }
    
    public boolean insert(int val) {
        if(valToIdx.containsKey(val)){
            return false;
        }
        
        valsInTheirIdx.add(val);
        valToIdx.put(val,valsInTheirIdx.size()-1);
        return true;
    }
    
    public boolean remove(int val) {
        if(!valToIdx.containsKey(val)){
            return false;
        }
        
        //Swapping with last element before removing from the list for O(1) remove
        Integer idx = valToIdx.get(val);
        Collections.swap(valsInTheirIdx, idx, valsInTheirIdx.size()-1);
        
        //Update valToIdx map  idx position of the newly swapped elem in map
        Integer swappedElem = valsInTheirIdx.get(idx);
        valToIdx.put(swappedElem, idx);
        
        //Note order matters: modify map first  before removing from list or risk NPE
        valsInTheirIdx.remove(valsInTheirIdx.size()-1);
        valToIdx.remove(val);
        return true;
    }
    
    public int getRandom() {
        return valsInTheirIdx.get(randomIdx.nextInt(valsInTheirIdx.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */