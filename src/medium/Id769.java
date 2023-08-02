package medium;

/*
Input array arr is a permutation of the integers in the range [0, n-1], where n is the length of the array. 
This means that the elements of the array are distinct and include all integers from 0 to n-1, exactly once.

We want to split the array into chunks, sort each chunk, and then concatenate them to get the sorted array.

Key observation: 
In a sorted array of distinct integers from 0 to n-1, each element i will be at its correct index i. 
Eg: In [0, 1, 2, 3, 4], element 0 is at index 0, element 1 is at index 1, and so on.

Let's use this obeservation 
- Iterate array from left to right while keeping track of max val seen so far (maxValueSeen). 
- If the current index i is equal to the maxValueSeen, 
  - Means that all the elements from 0 to maxValueSeen have been encountered so far, and they are correctly placed at their corresponding indices. 
  - So, we have found a chunk that can be sorted
*/
class Id769 {
    public int maxChunksToSorted(int[] arr) {
        int maxChunks = 0;
        int maxValueSeen = 0;
        
        for (int i = 0; i < arr.length; i++) {
            maxValueSeen = Math.max(maxValueSeen, arr[i]);
            
            if(maxValueSeen == i) maxChunks++;
        }
        
        return maxChunks;
    }
}
