package medium;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


public class Id146 {}

//Using LinkedHashMap
class LRUCache1 {
    private LinkedHashMap<Integer,Integer> lhm;
    public LRUCache1(int capacity) {
        lhm = new LinkedHashMap<>(capacity, 0.75f, true){
            @Override
            //eldest here refers to last accessed since we using access order
            protected boolean removeEldestEntry(Map.Entry<Integer,Integer> eldest){
                return size() > capacity;
            }
        };
    }
    
    public int get(int key) {
        return lhm.getOrDefault(key, -1);
    }
    
    public void put(int key, int value) {
        lhm.put(key,value);
    }
}

//Intended Implementation:
//1. Using a hashmap with values being doubly linked nodes. 
//2. Nodes refer to other nodes that are values of the hashmap
//3. Tail node is the last accessed node
class LRUCache2 {
    //Dummy nodes
    final Node head = new Node(0, 0);
    final Node tail = new Node(0, 0);
    final Map<Integer, Node> map;
    final int capacity;
    
    public LRUCache2(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
      if(map.containsKey(key)){
        Node n = map.get(key);
        remove(n);
        insertToHead(n);
        return n.value;
      }
      return -1;   
    }
    
    public void put(int key, int value) {
      if(map.containsKey(key)){
        Node n = map.get(key);
        n.value = value;
        remove(n);
        insertToHead(n);
        
        
      } else {
        
        if(map.size() == capacity){
           map.remove(tail.prev.key); 
           remove(tail.prev);
        } 
        
        Node n = new Node(key, value);
        insertToHead(n);
        map.put(key, n);
      }  
    }
    
    private void remove(Node n){
      n.prev.next = n.next;
      n.next.prev = n.prev;
    }
    
    private void insertToHead(Node n){
      Node headNext = head.next;
      head.next = n;
      headNext.prev = n;
      n.prev = head;
      n.next = headNext;
    }
    
    class Node{
      Node prev, next;
      int key, value;
      Node(int k, int v){
        key = k;
        value = v;
      }
    }
}