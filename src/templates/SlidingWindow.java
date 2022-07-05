package templates;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SlidingWindow {
	public List<Integer> slidingWindowPartialTemplate_substring(String src, String tgt) {
		// init collection<T> or just T to save the result according to question.
		List<Integer> result = new ArrayList<>();
		if (tgt.length() > src.length())
			return result;

		// Character <-> Frequency of the Characters in target
		Map<Character, Integer> targetMap = new HashMap<>();
		for (char c : tgt.toCharArray()) {
			targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
		}

		// Character <-> Frequency of the Characters in window that in targetMap too
		// For caching
		Map<Character, Integer> windowMap = new HashMap<>();

		// start/end = left/right pointer of window
		int start = 0, end = 0;
		// To know if we have scanned enough of source, s to contain target, t
		int counter = 0;

		// some length to update usually when windon has scanned enuf to contain target.Not needed in every template
		//int len = Integer.MAX_VALUE OR 0;

		// scan source
		while (end < src.length()) {

			char c = src.charAt(end);

			if (targetMap.containsKey(c)) {
				// plus or minus one according to qn
				windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);

				if (windowMap.get(c).equals(targetMap.get(c))) {
					counter++;// modify the counter according to requirement (thus actual statement differs)
				}
			}
			end++;

			// ATP, window has scanned enough of source to contain target
			// increase begin pointer to make it invalid/valid again
			while (counter == targetMap
					.size() /* counter condition. different question may have different condition */) {

				char tempc = src.charAt(start);

				if (targetMap.containsKey(tempc)) {
					// plus or minus one according to qn
					windowMap.put(tempc, windowMap.get(tempc) - 1);

					// window does not contain target anymore
					if (windowMap.get(tempc) < targetMap.get(tempc)) {
						counter--;// modify the counter according to requirement (thus actual statement differs).
					}
				}

				// Insert code to save / update the result accordingly 
				
				//Shift window to right
				start++;
			}
		}
		return result;
	}

	public int[] slidingWindowPartialTemplate_number(int[] arr, int windowSize) {
		if (arr == null || windowSize <= 0) {
			return new int[0];
		}

		// store index
		Deque<Integer> window = new ArrayDeque<>();

		// init collection<T> or just T to save the result (actual content) according to
		// question.
		List<Integer> results = new ArrayList<>();

		for (int currIdx = 0; currIdx < arr.length; currIdx++) {
			// remove numbers out of range
			// currIdx-range+1 is the lowest possible index of window (ie head index)
			//Only if have FIXED window size
			while (!window.isEmpty() && window.peekFirst() < currIdx - windowSize + 1) {
				window.pollFirst();
			}
			//

			window.offerLast(currIdx);

			// save / update the result for each window ONCE FIRST window forms
			if (currIdx + 1 >= windowSize) {
				// Your logic
			}
		}
		return results.stream().mapToInt(x->x).toArray();
	}
	void swap(int[] arr, int i , int j) {}
}
