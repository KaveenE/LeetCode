package medium;

public class Id167 {
    public int[] twoSum(int[] nums, int target) {

        int left=0, right=nums.length-1;
        int potentialTarget;
        while(left<right){
            potentialTarget = nums[left]+nums[right];
            if(potentialTarget==target){
                return new int[]{left+1,right+1};
            }
            else if(potentialTarget > target){
                right--;
                //for optimization
                while(left<right && nums[right]==nums[right+1])right--;
            }
            else{
                left++;
                //for optimization
                while(left<right && nums[left-1]==nums[left])left++;
            }
        }

        return null;
    }
}
