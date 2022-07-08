package hard.Id224;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Set;

public class Id224 {
    private static final Set<Character> operators = Set.of('+','-','*','/');
    
	public int calculate(String s) {
        return calcRec(s,0)[1];
      
    }
    
    public int[] calcRec(String s, int currIdx) {
        //See readme, for what the stack stores
        Deque<Integer> stack = new ArrayDeque<>();
        
        int number=0, polarity=0;
        char prevOperator='+';
        char currChar='0';
        
        int i;
        for(i=currIdx; i<= s.length()-1; i++){
            currChar = s.charAt(i);

            if(Character.isDigit(currChar)){
                number = number*10 + currChar-'0';
            }
            else if(operators.contains(currChar)){
                eval(prevOperator, number, stack);
                prevOperator = currChar;
                number = 0;
            }
            else if(currChar=='('){
                //Calculate the substring
                int[] endIdxAndResultOfSubstring = calcRec(s,i + 1);
                i = endIdxAndResultOfSubstring[0];
                number = endIdxAndResultOfSubstring[1];
            }
            else if(currChar==')'){
                //Done with substring, compute and return result for substring (and idx to know whr we ended)
                eval(prevOperator, number, stack);
                return new int[] {i, stack.stream().mapToInt(x->x).sum()};
            }
        }
        
        eval(prevOperator, number, stack);
        return new int[] {i, stack.stream().mapToInt(x->x).sum()};
      
    }
    
    public void eval(char prevOperator,int number, Deque<Integer> stack){
        if(prevOperator=='+'){
            stack.offerLast(number);
        }
        else if(prevOperator=='-'){
            stack.offerLast(-number);
        }
        else if(prevOperator=='*'){
            stack.offerLast(stack.pollFirst()*number);
        }
        else if(prevOperator=='/'){
            stack.offerLast(stack.pollFirst()/number);
        }
    }

}