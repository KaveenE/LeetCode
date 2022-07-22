package medium;

public class Id167 {
    public int[] twoSum(int[] nums, int target) {
        //Pointers to start/end of array
        int start= 0, end = nums.length-1;
        int sum = 0;
        while(end>=start){
            sum = nums[start] + nums[end];

            if(target == sum){
                break; 
            }
            else if(target > sum){
                start++;
            }
            else if(sum > target){
                end--;
            }
        }

        return new int[] {start+1,end+1};
    }
}
