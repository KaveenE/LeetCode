package easy;

import java.util.Map;

class Id13 {
    private static Map<Character, Integer> romanToIntMap = Map.of(
                                                               'I',1,
                                                               'V',5,
                                                               'X',10,
                                                               'L',50,
                                                               'C',100,
                                                               'D',500,
                                                               'M',1000);
    public int romanToInt(String s) {
        int num=romanToIntMap.get(s.charAt(0));
        
        int prevNum;
        int currNum;
        for(int idx=1; idx<=s.length()-1; idx++){
            prevNum = romanToIntMap.get(s.charAt(idx-1));
            currNum = romanToIntMap.get(s.charAt(idx));
            
            if(prevNum>=currNum){
                num += currNum;
            }
            else{
                num -= prevNum;
                num += currNum - prevNum;
            }
        }
        
        return num;
    }
}