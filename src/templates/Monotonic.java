package templates;

import java.util.*;

public class Monotonic {

    public int[] slidingWindowPartialTemplate_number(int[] arr, int windowSize) {
        int[] firstElemLargerEqualToRight = new int[arr.length];
        int[] firstElemLargerToLeft = new int[arr.length];
        int[] firstElemSmallerEqualToRight = new int[arr.length];
        int[] firstElemSmallerToLeft = new int[arr.length];
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

            //Updating firstElemLargerEqualToRight, firstElemLargerEqualToLeft
            //This happens when we violate MDS
            //NOTE: When MDS is not strictly decreasing, ie checking for arr[window.peekLast()]<arr[currIdx]
            //We get firstElemLargerToRight, firstElemLargerEqualToLeft instead
            while(!window.isEmpty() && arr[window.peekLast()]<=arr[currIdx]){
                firstElemLargerEqualToRight[window.pollLast()]=arr[currIdx];
            }
            if(!window.isEmpty()){
                firstElemLargerToLeft[currIdx]=arr[window.peekLast()];
            }
            window.offerLast(currIdx); // Window is MDS

            //Updating firstElemSmallerEqualToRight, firstElemSmallerEqualToLeft
            //This happens when we violate MIS
            //NOTE: When MIS is not strictly increasing, ie checking for arr[window.peekLast()]>arr[currIdx]
            //We get firstElemSmallerToRight, firstElemSmallerEqualToLeft instead
            while(!window.isEmpty() && arr[window.peekLast()]>=arr[currIdx]){
                firstElemSmallerEqualToRight[window.pollLast()]=arr[currIdx];
            }
            if(!window.isEmpty()){
                firstElemSmallerToLeft[currIdx]=arr[window.peekLast()];
            }
            window.offerLast(currIdx); // Window is MIS

            // save / update the result for each window ONCE FIRST window forms
            if (currIdx + 1 >= windowSize) {
                // Your logic
            }
        }
        return results.stream().mapToInt(x->x).toArray();
    }
    public int largestRectangleAreaViaMonotonicity(int[] heights) {
        int[] firstIdxLessThanFromLeft = new int[heights.length];
        int[] firstIdxLessThanFromRight = new int[heights.length];
        //If no smaller values on left/right, give default values
        Arrays.fill(firstIdxLessThanFromLeft,-1);
        Arrays.fill(firstIdxLessThanFromRight,heights.length);
        Deque<Integer> window = new ArrayDeque<>();

        for(int i=0; i<=heights.length-1; i++){
            while(!window.isEmpty() && heights[window.peekLast()]>=heights[i]){
                window.pollLast();
            }
            if(!window.isEmpty())firstIdxLessThanFromLeft[i]=window.peekLast();

            window.offerLast(i);
        }

        window = new ArrayDeque<>();
        for(int i=0; i<=heights.length-1; i++){
            while(!window.isEmpty() && heights[window.peekLast()]>heights[i]){
                firstIdxLessThanFromRight[window.pollLast()]=i;
            }
            window.offerLast(i);
        }

        int maxArea = 0;
        for(int i=0; i<=heights.length-1; i++){
            maxArea = Math.max(maxArea, heights[i]*(firstIdxLessThanFromRight[i]-firstIdxLessThanFromLeft[i]-1));
        }

        return maxArea;
    }
}
