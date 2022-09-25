package medium;

import java.util.Arrays;

class Id923 {
    static int MOD = 1_00_00_00_00_7;
    public int threeSumMulti(int[] arr, int target) {
        Arrays.sort(arr);
        int left = 0, right = arr.length - 1;
        int tuples = 0;

        for (int i = 0; i <= arr.length - 2; i++) {
            left = i + 1;
            right = arr.length - 1;

            int potentialTarget = 0;
            while (left < right) {
                potentialTarget = arr[i] + arr[left] + arr[right];

                if (potentialTarget == target) {
                    if (arr[left] == arr[right]) {
                        //This window consists entirely of arr[left]/arr[right]
                        int windowSize = right - left + 1;
                        int allCombinationsOfVal = windowSize * (windowSize - 1) / 2;
                        tuples = (tuples + allCombinationsOfVal) % MOD;
                        //System.out.println("Equal: "+tuples);
                        break;
                    }

                    int leftDup = 1, rightDup = 1;
                    ;

                    while (left + 1 < right && arr[left] == arr[left + 1]) {
                        leftDup++;
                        left++;
                    }
                    // System.out.printf("Left:%d--",left);
                    // System.out.printf("Dup? arr[%d]=%d == arr[%d]=%d--",right, arr[right], right+1, arr[right+1]);
                    while (left < right - 1 && arr[right - 1] == arr[right]) {
                        rightDup++;
                        right--;
                    }
                    left++;
                    right--;

                    tuples = (tuples + (rightDup * leftDup)) % MOD;
                    //System.out.printf("Result:%d after adding %d*%d\n",tuples,leftDup,rightDup);
                } else if (potentialTarget > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        return tuples;
    }
}