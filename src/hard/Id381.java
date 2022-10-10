package hard;

import java.util.*;

class Id381{}
class RandomizedCollection {
    private final Map<Integer, Set<Integer>> valToIndices;
    private final List<Integer> valsInTheirIdx;
    private final Random randomIdx;
    
    public RandomizedCollection() {
        valToIndices = new HashMap<>();
        valsInTheirIdx = new ArrayList<>();
        randomIdx = new Random();
    }
    
    public boolean insert(int val) {
        boolean isNotPresent = isNotPresent(val);
        
        valsInTheirIdx.add(val);
        valToIndices.computeIfAbsent(val, _key->new LinkedHashSet<>())
                    .add(valsInTheirIdx.size()-1);

        return isNotPresent;
    }
    
    public boolean remove(int val) {
        if(isNotPresent(val)){
            return false;
        }
        
        //Swapping with last element before removing from the list for O(1) remove
        int idx = valIdx(valToIndices.get(val));        
        Collections.swap(valsInTheirIdx, idx, valsInTheirIdx.size()-1);
        valsInTheirIdx.remove(valsInTheirIdx.size()-1);
        
        //Update valToIdices map's set of the newly swapped elem in map
        //If it's an empty list after removing elem, we would get NPE
        //If idx and last idx of valsInTheirIdx is same(b4 removing), accessing valsInTheirIdx get OutOfBoundsException
        if( !valsInTheirIdx.isEmpty() && idx!=valsInTheirIdx.size()){
            Set<Integer> indicesOfSwappedElem = valToIndices.get(valsInTheirIdx.get(idx));
            indicesOfSwappedElem.remove(valsInTheirIdx.size());
            indicesOfSwappedElem.add(idx);

        }

        return true;
    }
    
    public int getRandom() {
        return valsInTheirIdx.get(randomIdx.nextInt(valsInTheirIdx.size()));
    }
    
    private int valIdx(Set<Integer> set){
        Iterator<Integer> it = set.iterator();
        int idxToReturn=0;
        
        if(it.hasNext()){
            idxToReturn=it.next();
            it.remove();
        }
        return idxToReturn;
            
    }
    
    boolean isNotPresent(int val){
        return !valToIndices.containsKey(val) || valToIndices.get(val).isEmpty();
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */