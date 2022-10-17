package hard;

class Id154 {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        
        if(nums[right]>nums[left])return nums[left];
        while(left<right){
            while(left+1<right && nums[left]==nums[left+1])left++;
            while(left<right-1& nums[right-1]==nums[right])right--;

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