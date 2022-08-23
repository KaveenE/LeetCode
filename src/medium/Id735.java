package medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class Id735 {
    private int[] asteroids;
    public int[] asteroidCollision(int[] asteroids) {
        this.asteroids = asteroids;
        Deque<Integer> window = new ArrayDeque<>();
        
        for(int i=0; i<=asteroids.length-1;){
            while(i<=asteroids.length-1 
                  && !window.isEmpty()
                  && willCollide(window.peekLast(), i)){
                
                if(rock1BiggerThanRock2(i,window.peekLast())){
                    window.pollLast();
                }
                else if(rock1BiggerThanRock2(window.peekLast(),i)){
                    i++;
                }
                else{
                    window.pollLast();
                    i++;
                }
            }
            
            if(i<=asteroids.length-1){
                window.offerLast(i);
                i++;
            } 
        }
        
        return window.stream().mapToInt(idx->asteroids[idx]).toArray();
    }
    
    public boolean willCollide(int windowRock, int incomingRock){
        //Ignore asteroids[windowRock]<0 && asteroids[incomingRock]>0) 
        //as they have already passed each other
        return asteroids[incomingRock]<0 && asteroids[windowRock]>0;
    }
    
    public boolean rock1BiggerThanRock2(int rock1, int rock2){
        return Math.abs(asteroids[rock1]) > Math.abs(asteroids[rock2]);
    }
    
}