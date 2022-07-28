package medium;

public class Id33 {
    public int search(int[] nums, int target) {

        int left = 0, right = nums.length - 1;
        int mid = 0;
        while (right > left) {
            mid = left + (right - left) / 2;

            //If both target and nums[mid] on same side of rotation, do standard binary search
            if ((nums[mid] - nums[nums.length - 1]) * (target - nums[nums.length - 1]) > 0) {
                if (targetLessEqualMid(mid, target, nums))
                    right = mid;
                else
                    left = mid + 1;

            }
            //target on left left, so ignore right half
            else if (targetOnLeftHalf(target, nums)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return (nums[left] == target) ? left : -1;
    }

    public boolean targetLessEqualMid(int mid, int target, int[] nums) {
        return target <= nums[mid];
    }

    public boolean targetOnLeftHalf(int target, int[] nums) {
        return target > nums[nums.length - 1];
    }
}
