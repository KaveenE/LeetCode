package easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Id217 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        return Arrays.stream(nums).anyMatch(num->!set.add(num));
     }
 }
