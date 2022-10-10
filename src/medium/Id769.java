package medium;

/*
To get max chunks, we need to know max number of continuous sequence
IE 1 continuous sequeunce = 1 chunk

Eg:
array: [1, 0, 2, 4, 3]
cut :  [1, 0 | 2 | 4 | 3]
[1, 0], [2], [4], [3] give 4 continuous sequences and thus 4 chunks

A continuous sequence has formed when the maxNumSeen == numInCurrIdxOfSortedArray
Since arr's values lie in [0,n-1], numInCurrIdxOfSortedArray is same as the currIdx itself
*/
class Id769 {
    public int maxChunksToSorted(int[] arr) {
        int maxContSeq=0;
        int maxNumSeen = 0;
        
        for (int idx=0; idx<=arr.length-1; idx++) {
            maxNumSeen = Math.max(maxNumSeen, arr[idx]);
            if (maxNumSeen == idx) maxContSeq++;
            
        }
        
        return maxContSeq;
    }
}