package medium;

import java.util.ArrayDeque;
import java.util.Deque;

class Id946 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new ArrayDeque<>();
        int poppedIdx=0;
        
        for(int pushedNum:pushed){
            while(!stack.isEmpty() && stack.peekLast()==popped[poppedIdx]){
                stack.removeLast();
                poppedIdx++;
                
            }
            stack.offerLast(pushedNum);
        }
        
        while(!stack.isEmpty() && stack.peekLast()==popped[poppedIdx]){
                stack.removeLast();
                poppedIdx++;
                
        }
        
        return stack.isEmpty() && poppedIdx==popped.length;
    }
}