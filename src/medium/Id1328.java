package medium;

class Id1328 {
    public String breakPalindrome(String pal) {
        if(pal.length()==1)return "";
        
        StringBuilder sb = new StringBuilder(pal);
        
        for(int i=0; i<=pal.length()-1; i++){
            //Dont bother with middle char
            if(pal.length()%2==1 && i==(pal.length()-1)/2)continue;
            
            if(pal.charAt(i)!='a'){
                sb.setCharAt(i,'a');
                return sb.toString();
            }
            
        }
        
         sb.setCharAt(sb.length()-1,'b');
         return sb.toString();
    }
}