package medium;

public class Id198 {
    public int rob(int[] nums) {
        Integer[] maxRobbedStartingFromHse = new Integer[nums.length];
        return maxRobbed(0, nums, maxRobbedStartingFromHse);
    }

    public int maxRobbed(int toRobHseIdx, int[] nums, Integer[] maxRobbedStartingFromHse){
        if(toRobHseIdx>nums.length-1){
            return 0;
        }

        if(maxRobbedStartingFromHse[toRobHseIdx]!=null)return maxRobbedStartingFromHse[toRobHseIdx];

        int moneyRobbedAdjHse1 = nums[toRobHseIdx] + maxRobbed(toRobHseIdx+2, nums, maxRobbedStartingFromHse);
        int moneyRobbedAdjHse2 = 0;
        if(toRobHseIdx+1<=nums.length-1){
            moneyRobbedAdjHse2 = nums[toRobHseIdx+1] + maxRobbed(toRobHseIdx+3, nums, maxRobbedStartingFromHse);
        }


        return maxRobbedStartingFromHse[toRobHseIdx] = Math.max(moneyRobbedAdjHse1,moneyRobbedAdjHse2);
    }
}