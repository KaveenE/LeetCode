package easy;

/*
If there exists a valid gcd:
- should not only able to divide str1, str2 but also str1+str2

For a valid gcd to exist:
(str1+str2).equals(str2+str1) == true
*/
public class Id1071 {
    public String gcdOfStrings(String str1, String str2) {
        if(!(str1+str2).equals(str2+str1)) 
            return "";
        
        int gcdLength=1;
        
        if(str1.length()>=str2.length())
            gcdLength = gcd(str1.length(), str2.length());
        else
            gcdLength = gcd(str2.length(), str1.length());
            
        return str1.substring(0,gcdLength);
    }
    
    public int gcd(int p, int q){
        if(q==0)return p;
        return gcd(q, p%q);
    }
}