package hard;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class Id295 {

}
class MedianFinder {
	//Can be of size n/2 or (n/2)+1 if size is odd
	private Queue<Integer> largerRight;
	//Only size n/2
	private Queue<Integer> smallerLeft;
	boolean isEven;
	
    public MedianFinder() {
        largerRight = new PriorityQueue<>();
		smallerLeft = new PriorityQueue<>(Collections.<Integer>reverseOrder());
		isEven = true; //0 is even
    }
    
    public void addNum(int num) {
    	//Add to largerRight since now we become odd
        if(isEven){
			smallerLeft.offer(num);
			largerRight.offer(smallerLeft.poll());
		}
      //Add to smallerLeft since now we become even and thus need to keep size(smallerLeft)==size(largerRight)
		else{
			largerRight.offer(num);
			smallerLeft.offer(largerRight.poll());
		}
		
		isEven=!isEven;
    }
    
    public double findMedian() {
        if(isEven){
			return ( (double)largerRight.peek()+ smallerLeft.peek() )/2;
		}
		return (double)largerRight.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
