package medium;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Id981 {

	private Map<String, TreeMap<Integer, String>> keyToTimeStampValMap;

	// To improve runtime lol, ik q pathetic bunching
	private TreeMap<Integer, String> timeStampValMap;
	private Integer floorKey;

	public Id981() {
	        keyToTimeStampValMap= new HashMap<>();
	    }

	public void set(String key, String value, int timestamp) {
		timeStampValMap = keyToTimeStampValMap.getOrDefault(key, new TreeMap<>());
		timeStampValMap.put(timestamp, value);
		keyToTimeStampValMap.put(key, timeStampValMap);
	}

	public String get(String key, int timestamp) {
		timeStampValMap = keyToTimeStampValMap.get(key);
		if (timeStampValMap == null)
			return "";

		floorKey = timeStampValMap.floorKey(timestamp);
		return floorKey == null ? "" : timeStampValMap.get(floorKey);

	}
}

/**
 * Your TimeMap object will be instantiated and called as such: TimeMap obj =
 * new TimeMap(); obj.set(key,value,timestamp); String param_2 =
 * obj.get(key,timestamp);
 */
