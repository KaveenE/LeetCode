package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Same as Id31.Next Permutation except instead of array, it's a num
//Separate num into array -> Apply algo -> Concatenate array into num again
class Id556 {
    public int nextGreaterElement(int n) {
        List<Integer> arr = new ArrayList<>();
        
        while(n!=0){
            arr.add(n%10);
            n/=10;
        }
        
        Collections.reverse(arr);
        return nextPermutation(arr);
        
    }
    
    public int nextPermutation(List<Integer> nums) {
        
        int rightMostIdxWithLargerRightNeighbor = -1;
        for(int idx=nums.size()-2; idx>=0; idx--){
            if(nums.get(idx+1)>nums.get(idx)){
                rightMostIdxWithLargerRightNeighbor =idx;
                break;
            }
        }
        if(rightMostIdxWithLargerRightNeighbor == -1){
            return -1;
        }
        else{
            int rightMostIdxOfElemLargerThanElemAbove = -1;
            for(int idx=nums.size()-2; idx>=0; idx--){
                if(nums.get(idx+1)>nums.get(rightMostIdxWithLargerRightNeighbor)){
                    rightMostIdxOfElemLargerThanElemAbove =idx+1;
                    break;
                }
            }
            
            Collections.swap(nums, rightMostIdxWithLargerRightNeighbor, rightMostIdxOfElemLargerThanElemAbove);

            int offsetFromEnd = 0;
            for(int i=rightMostIdxWithLargerRightNeighbor+1
                ;i<= (nums.size()-1 + rightMostIdxWithLargerRightNeighbor+1)/2 
                ;i++){
                Collections.swap(nums, i, nums.size()-1-offsetFromEnd);
                offsetFromEnd++;
            }
            
        }
        
        return concatNum(nums);
        
    }
    
    private void swap(int idx1, int idx2, int[] arr){
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
        
    }
    
    private int concatNum(List<Integer> nums){
        int num=0;
        for(int digit:nums){
            if(num<Integer.MAX_VALUE/10 || num==Integer.MAX_VALUE/10 && digit==Integer.MAX_VALUE%10){
                num=num*10+digit;
            }else{
                return -1;
            }
        }
        
        return num;
    }
    
}