package hard;

/*
Take n[0..mid] as baseForPalindrome

If n is already palindromic, there will be 2 palindromes that can be formed from baseForPalindrome:
Eg: For 12321 
    -> baseForPalindrome = 123 
    -> Possible palindromes from 123: 
       123+1=124 to form 12421 & 123-1=122 to form 12221

If n is not palindromic, there will be 3 palindromes that can be formed from baseForPalindrome:
Eg: For 12325
    -> baseForPalindrome = 123 
    -> Possible palindromes from 123:   
       123+1=124 to form 12421 and 123-1=122 to form 12221 and 12321

Edge cases are listed below
*/
public class Id564 {
    public String nearestPalindromic(String n) {        
        long num = Long.valueOf(n);
        
        //Single digit or num is 10,1000,100 etc
        double numberOfDivisionsBy10 = Math.log10(num);
        if(num<10 || numberOfDivisionsBy10==(long)numberOfDivisionsBy10)
            return num-1+"";
        
        //num is 11,1001,101 etc
        double numberOfDivisionsBy10ForNumMinus1 = Math.log10(num-1);
        if(numberOfDivisionsBy10ForNumMinus1==(long)numberOfDivisionsBy10ForNumMinus1)
            return num-2+"";
        
        if(all9Digits(n))
            return num+2+"";
        
       
        boolean isEvenDigits = n.length()%2==0;
        String baseForPalindrome  = isEvenDigits ? n.substring(0,n.length()/2)
                                                 : n.substring(0,n.length()/2 + 1);
        
        long sameBasepal = createPalindrome(baseForPalindrome,isEvenDigits);
        long diffSameBase = Math.abs(sameBasepal-num);
        
        long smallerBasePal = createPalindrome(Long.valueOf(baseForPalindrome)-1+"",isEvenDigits);
        long diffSmallerBase = Math.abs(smallerBasePal-num);
        
        long biggerBasePal = createPalindrome(Long.valueOf(baseForPalindrome)+1+"",isEvenDigits);
        long diffBiggerBase = Math.abs(biggerBasePal-num);
        
        
        long pal;
        long smallerDiff;
        //if tie, use smaller one
        if(diffSmallerBase <= diffBiggerBase){
                pal = smallerBasePal;
                smallerDiff = diffSmallerBase;
        }
        else{
            pal = biggerBasePal;
            smallerDiff = diffBiggerBase;
        }
                    
        
        if(diffSameBase!=0){
            if(diffSameBase==smallerDiff)
                pal = Math.min(sameBasepal,pal);
            if(diffSameBase < smallerDiff)
                pal = sameBasepal;
        }
        
        return pal+"";
        
    }
    
    private boolean all9Digits(String sb){
        for(int i=0; i<=sb.length()-1; i++){
            if(sb.charAt(i)!='9')return false;
        }
        return true;
    }
    
    private long createPalindrome(String baseForPalindrome, boolean isEvenDigits){
        int startIdx = isEvenDigits ? baseForPalindrome.length()-1 : baseForPalindrome.length()-2;
        StringBuilder palindrome = new StringBuilder(baseForPalindrome);
        for(int i=startIdx; i>=0; i--){
            palindrome.append(baseForPalindrome.charAt(i));
        }
        
        return Long.valueOf(palindrome.toString());
    }
}