package medium;

//Modifed from Codesignal Prac4 qn (For easy reference, i pasted model answer below)
class Id1010 {
    private static int SIXTY=60;
    public int numPairsDivisibleBy60(int[] time) {

        long[] remainderToFreq = new long[SIXTY];
        for(int timing:time)remainderToFreq[timing%SIXTY]++;

        long pairs = remainderToFreq[0]*(remainderToFreq[0]-1)/2;

        for(int i=1; i<=SIXTY/2 && i!=(SIXTY-i); i++)
            pairs+= remainderToFreq[i]*remainderToFreq[SIXTY-i];
        
        if(SIXTY%2==0)
            pairs+=remainderToFreq[SIXTY/2]*(remainderToFreq[SIXTY/2]-1)/2;
        
        return (int)pairs;
        
    }
    
    //From Codesignal Prac4 qn
    public static int countKdivPairs(int A[], int K) { 
        // remainderToFreq array
        int freq[] = new int[K]; 
        for (int i=0; i<=A.length-1; i++) 
            freq[A[i] % K]++; 
  
        //For numbers divisible by K, we just get the nC2 value
        int pairs= freq[0]*(freq[0]-1)/2; 
  
        //Get all possible pairs for a number with remainder i, and K-i
        //Remember the explanation said p+q=K or 0? It's this part
        //Ie cartesian product
        //1st end condition to prevent double counting, 2nd end condition is handled specially below
        for (int i=1; i<=K/2 && i!=(K-i); i++) 
            pairs+= freq[i]*freq[K-i]; 
        
        //Don't know why we nC2 numbers with K/2 remainder
        if (K%2==0) 
            pairs+= freq[K/2]*(freq[K/2]-1)/2;
        
        return pairs; 
    } 
}

