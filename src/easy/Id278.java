package easy;

/* The isBadVersion API is defined in the parent class VersionControl.
boolean isBadVersion(int version); */

//Similar idea to binary search
public class Id278 {
	public int firstBadVersion(int n) {
        int right = n;
        int left = 1;
        int mid = left + (right - left)/2;
        
        while(right>=left){
            if(isBadVersion(mid)){
                right = mid -1;
            }
            else{
                left = mid + 1;
            }
            
            mid = left + (right - left)/2;
        }
        
        return mid;
    }
	
}
