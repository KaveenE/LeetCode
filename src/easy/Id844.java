package easy;

class Id844 {
    public boolean backspaceCompare(String s, String t) {
        StringBuilder sbFors = new StringBuilder();
        for(int i=0; i<=s.length()-1; i++){
            if(s.charAt(i)!='#'){
               sbFors.append(s.charAt(i)); 
            } 
            else{
                if(sbFors.length()!=0)sbFors.deleteCharAt(sbFors.length()-1);
            }
        }
        
        StringBuilder sbFort = new StringBuilder();
        for(int i=0; i<=t.length()-1; i++){
            if(t.charAt(i)!='#'){
               sbFort.append(t.charAt(i)); 
            } 
            else{
                if(sbFort.length()!=0)sbFort.deleteCharAt(sbFort.length()-1);
            }
        }

        return sbFors.toString().equals(sbFort.toString());
    }
}