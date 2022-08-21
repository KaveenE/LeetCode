package medium;

public class Id81 {
        public boolean search(int[] nums, int target) {

        int left=0, right=nums.length-1;
        int mid = 0;
        while(right>left){
            while(left<right && nums[left]==nums[left+1])left++;
            while(left<right && nums[right-1]==nums[right])right--;
            mid = left + (right-left)/2;

            //If both target and nums[mid] biggerEqual/smaller than pivot, they're on same side wrt pivot
            //Normal binary search
            if((nums[mid]>=nums[0] && target>=nums[0]) ||
               (nums[mid]<nums[0] && target<nums[0])){

                if(targetLessEqualMid(mid, target, nums))
                    right=mid;
                else
                    left=mid+1;

            }
            //target and mid diff sides wrt pivot
            //Reduce search space of target
            else if(target>=nums[0]){
                right=mid;
            }
            else{
                left=mid+1;
            }
        }

        return left >= nums.length ? false : (nums[left] == target);
    }

    public boolean targetLessEqualMid(int mid, int target, int[] nums){
        return target<=nums[mid];
    }
}