package easy;

public class Id169 {
    public int majorityElement(int[] nums) {
        int majority = 0;
        int count =0;
        for(int num:nums){
            if(majority==num){
                count++;
            } 
            else if(count==0){
                majority=num;
                count++;
            }
            //Paired out by non-majority so count needs to drop
            else {
                count--;
            }
        }
        
        return majority;
    }
}