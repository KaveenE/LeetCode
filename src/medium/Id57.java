package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Id57 {
	
	//Modified input to include the other interval -> Applied merge intervals algo
	public int[][] insert(int[][] intervals, int[] newInterval) {

		int[][] intervalsWithNew = Arrays.copyOf(intervals, intervals.length + 1);
		intervalsWithNew[intervalsWithNew.length - 1] = newInterval;
		Arrays.sort(intervalsWithNew, (first, second) -> first[0] - second[0]);

		List<int[]> mergedIntervals = new ArrayList<>();
		int[] mergedInterval = intervalsWithNew[0];

		for (int row = 0; row <= intervalsWithNew.length - 2; row++) {

			if (intervalsWithNew[row + 1][0] <= mergedInterval[1]) {
				mergedInterval[1] = Math.max(intervalsWithNew[row + 1][1], mergedInterval[1]);
			} else {
				mergedIntervals.add(mergedInterval);
				mergedInterval = intervalsWithNew[row + 1];
			}

		}

		mergedIntervals.add(mergedInterval);
		return mergedIntervals.toArray(new int[0][0]);
	}
}
