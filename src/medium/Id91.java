package medium;

import java.util.HashMap;
import java.util.Map;

//totalDecodings(i) = totalDecodings(i+1) [1 way at ith idx] 
//+ totalDecoding(i+2) ( 1 way at ith and (i+1)th idx if s[i]&&s[i+1] forms a substring <= "26")
//totalDecodings(i) refers to total decodings of string from index, i
//Base case is if(i==s.length())return 1; OR
public class Id91 {
	int totalWays = 0;

	public int numDecodings(String s) {
		if (s.startsWith("0"))return 0;
		return totalDecodings(0, s, new HashMap<>());
	}

	private int totalDecodings(int startIdx, String input, Map<Integer, Integer> idxToTotalWaysMemo) {
		if (startIdx == input.length()) {
			idxToTotalWaysMemo.computeIfAbsent(startIdx, _key -> 1);
			return 1;
		}

		if (idxToTotalWaysMemo.containsKey(startIdx))return idxToTotalWaysMemo.get(startIdx);

		//Avoid leading 0s
		if (input.charAt(startIdx) == '0')return 0;

		int decodingsFromNextIdx = totalDecodings(startIdx + 1, input, idxToTotalWaysMemo);
		int decodingsFromNextNextIdx = 0;
		if (startIdx + 2 <= input.length() && Integer.valueOf(input.substring(startIdx, startIdx + 2)) <= 26) {
			decodingsFromNextNextIdx = totalDecodings(startIdx + 2, input, idxToTotalWaysMemo);
		}

		idxToTotalWaysMemo.put(startIdx, decodingsFromNextIdx + decodingsFromNextNextIdx);
		return decodingsFromNextIdx + decodingsFromNextNextIdx;
	}
}