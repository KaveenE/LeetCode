package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Id621 {
    /* 
    Eg:3A, 2B, 1C and we have n=2.
    So put A at slots 0,3,6 with 2 slots of gaps between them: A??A??A
    Similarly, arrange B and C: ABCAB#A
    #=idle

    But we don't need to waste time arranging as they only ask for least time.
    Least time = number of idles + number of tasks

    To find number of number of idles:
    1) Find number of partitions after arranging task of highest frequency, partitions = highestFreq - 1
    2) Total empty slots, emptySlots = partitions * (n - (numOfhighestFreqTasks - 1)). See below diagram why last 2 operators are needed
    3) Remaining number of letters, remainingTasks = numTasks - highestFreq*numOfhighestFreqTasks
    4) Number of idles by comparing remaingTasks and emptySlots, idles=max(emptySlots-remainingTasks,0)

    */
    public int leastInterval1(char[] tasks, int n) {
        Map<Character,Integer> charToFreq = new HashMap<>();
        
        int highestFreq=0;
        int numOfHighestFreq=0;
        for(char task:tasks){
            charToFreq.put(task, charToFreq.getOrDefault(task,0)+1);
            if(highestFreq < charToFreq.get(task)){
                highestFreq = charToFreq.get(task);
                numOfHighestFreq=1;
            }
            else if(highestFreq == charToFreq.get(task)){
                numOfHighestFreq++;
            }
        }
        
        int partitions = highestFreq - 1;
        int emptySlots = partitions * (n - (numOfHighestFreq - 1));
        int remainingTasks = tasks.length - highestFreq*numOfHighestFreq;
        int idles=Math.max(emptySlots-remainingTasks,0);
        
        return idles + tasks.length;
        
    }
    
    //Apply greedy template with cycle. Cycle here is the letter of highest freq followed by n slots. len(cycle)=n+1.
    //Note if I used Queue<Map.Entry> instead of Queue<Integer> I can get actual arrangement of letters
    //Refer https://leetcode.com/problems/task-scheduler/discuss/104493/C%2B%2B-Java-Clean-Code-Priority-Queue
    public int leastInterval(char[] tasks, int n) {
        Map<Character,Integer> charToFreq = new HashMap<>();
        for(char task:tasks)charToFreq.put(task, charToFreq.getOrDefault(task,0)+1);
        
        //need a max heap to return highestFreq character
        Queue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        pq.addAll(charToFreq.values());
        
        int cycles= n+1;
        int leastTime = 0;
        int leastTime1 = 0;
        while(!pq.isEmpty()){
            List<Integer> tempList = new ArrayList<>();
            int i=1;
            while(i<=cycles && !pq.isEmpty()){
                tempList.add(pq.poll());
                i++;
            }
            leastTime1 += i > cycles ? cycles:tempList.size();
            //System.out.print(!pq.isEmpty()+"\n");
            System.out.print(leastTime1+" ");
            for(Integer reducedFreq: tempList){
                reducedFreq--;
                if(reducedFreq!=0)pq.offer(reducedFreq);
            }
            
            leastTime += !pq.isEmpty() ? cycles:tempList.size();
            System.out.print(leastTime+"\n");
            //System.out.print(tempList+"\n\n");
        }

        return leastTime;
    }
    
}