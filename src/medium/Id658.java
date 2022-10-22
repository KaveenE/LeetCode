package medium;

import java.util.*;
import java.util.stream.Collectors;

class Id658 {
    
    //O(nlogk)
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> arr1 = Arrays.stream(arr)
                                   .mapToObj(num->(Integer)num)
                                   .collect(Collectors.toList());
        
        Comparator<Integer> comparator = Comparator.comparing((Integer num)-> Math.abs(num-x))
                                                   .thenComparing(num->num);
        
        Queue<Integer> pq = new PriorityQueue<>(comparator.reversed());
        
        for(int num:arr){
            pq.add(num);
            if(pq.size()>k){
                pq.poll();
            }
        }
        
        return pq.stream().sorted().collect(Collectors.toList());
    }
    
    //O(nlogn)
    public List<Integer> findClosestElements1(int[] arr, int k, int x) {
        Integer[] arr1 = Arrays.stream(arr).mapToObj(num->(Integer)num).toArray(Integer[]::new);
        Comparator<Integer> comparator = Comparator.comparing((Integer num)-> Math.abs(num-x))
                                                   .thenComparing(num->num);


        return Arrays.stream(arr1)
                     .sorted(comparator)
                     .limit(k)
                     .sorted()
                     .collect(Collectors.toList());
    }
}