package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Id56 {
	public int[][] merge(int[][] intervals) {
		Arrays.sort(intervals, (arr1, arr2) -> arr1[0] - arr2[0]);
		int[] mergedInterval = intervals[0];
		List<int[]> mergedIntervals = new ArrayList<>();

		for (int i = 1; i <= intervals.length - 1; i++) {
			if (intervals[i][0] <= mergedInterval[1]) {
				mergedInterval[1] = Math.max(intervals[i][1], mergedInterval[1]);
			} else {
				mergedIntervals.add(mergedInterval);
				mergedInterval = intervals[i];
			}
		}

		mergedIntervals.add(mergedInterval);
		return mergedIntervals.toArray(int[][]::new);
	}
}
