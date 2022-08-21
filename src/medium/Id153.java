package medium;

public class Id153 {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        
        while(left<right){
            if(nums[right]>=nums[left])return nums[left];
            
            int mid = left + (right-left)/2;
            
            if(midSmallerThanPivot(mid,nums)){
                right = mid;
            }
            else{
                left=mid+1;
            }
        }
        
        return nums[left];
    }
    
    public boolean midSmallerThanPivot(int mid, int[] arr){
        return arr[mid]<arr[0];
    }
}
