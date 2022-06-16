Below approach is FLAWED since we can have duplicate keys

Sort→2 pointers(front/end)→Once target reached→Use map to retrieve indices
    
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> valToIdx = new HashMap<>();
        
        for(int i=0;i<=nums.length-1;i++){
            valToIdx.put(nums[i],i);    
        }
        
        Arrays.sort(nums);
        
        //Pointers to start/end of array
        int start= 0, end = nums.length-1;
        int sum = 0;
        while(end>=start){
            sum = nums[start] + nums[end];
            
            if(target == sum){
                break; 
            }
            else if(target > sum){
                start++;
            }
            else if(sum > target){
                end--;
            }
        }
        
        return new int[] {valToIdx.get(nums[start]),valToIdx.get(nums[end])};
    }
    
I changed my approach to use the 2nd one:
1. The above approach is doable if you handle the duplicates. IDK how to. But you can refer [here if you can understand it](https://leetcode.com/problems/two-sum/discuss/1378064/C%2B%2BJavaPython-HashMap-Two-pointers-Solutions-Clean-and-Concise) 
    1.  Time: O(nlogn). Space:O(n<sup>2</sup>)
2. Don't sort → Iterate through array → Use map to see if complement exists 
	1.	Duplicates do **not** matter. Because of the **order** we are traversing array, the index of the complement we get is correct. (Imagine with an example)
	2.	Time: O(n). Space: O(n)	
