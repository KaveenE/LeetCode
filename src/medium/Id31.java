package medium;

import java.util.*;

/*
To find next lexigraphically larger perm

1. I need to find idx of rightmost elem,i whose right neighbor is larger
	1i. If no such idx:
	-> we already have the lexiographically largest perm (descending)
	-> thus we rotate back to lexiographically smallest permutation (ascending)
	
	1ii. Else:
	-> Find idx of rightmost elem, r s.t arr[r]>arr[i] && r>i
	-> Swap arr[r] and arr[i]
        -> Swap elements from i+1 to arr.length-1
*/
public class Id31 {
    public void nextPermutation(int[] nums) {
        
        int rightMostIdxWithLargerRightNeighbor = -1;
        for(int idx=nums.length-2; idx>=0; idx--){
            if(nums[idx+1]>nums[idx]){
                rightMostIdxWithLargerRightNeighbor =idx;
                break;
            }
        }
        
        if(rightMostIdxWithLargerRightNeighbor == -1){
            Arrays.sort(nums);
        }
        else{
            int rightMostIdxOfElemLargerThanElemAbove = -1;
            for(int idx=nums.length-2; idx>=0; idx--){
                if(nums[idx+1]>nums[rightMostIdxWithLargerRightNeighbor]){
                    rightMostIdxOfElemLargerThanElemAbove =idx+1;
                    break;
                }
            }
            
            swap(rightMostIdxWithLargerRightNeighbor, rightMostIdxOfElemLargerThanElemAbove, nums);

            int offsetFromEnd = 0;
            for(int i=rightMostIdxWithLargerRightNeighbor+1
                ;i<= (nums.length-1 + rightMostIdxWithLargerRightNeighbor+1)/2 
                ;i++){
                swap(i,nums.length-1-offsetFromEnd, nums);
                offsetFromEnd++;
            }
            
        }
        
    }
    
    private void swap(int idx1, int idx2, int[] arr){
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
        
    }
}
