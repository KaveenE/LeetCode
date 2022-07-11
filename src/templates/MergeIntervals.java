package templates;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
	public List<int[]> merge(int[][] intervals) {
		Arrays.sort(intervals, (first, second) -> first[0] - second[0]);

		List<int[]> mergedIntervals = new ArrayList<>();
		// first element in intervals as baseline
		int[] mergedInterval = intervals[0];

		for (int row = 1; row <= intervals.length - 1; row++) {

			if (mergedInterval[1] >= intervals[row][0]) {
				mergedInterval[1] = Math.max(intervals[row][1], mergedInterval[1]);
			} else {
				mergedIntervals.add(mergedInterval);
				mergedInterval = intervals[row];
			}

		}

		mergedIntervals.add(mergedInterval);
		return mergedIntervals;
	}
}
