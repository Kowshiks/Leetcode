class Solution {
    public String reverseWords(String s) {
        
        String cur = "";
        
        String output = "";
        
        for (int i=0; i<s.length(); i++) {
            
            if (s.charAt(i) == ' ') {
                
                if (!cur.isEmpty()){
                    
                    output = cur+" "+output;
                    
                }
                
                cur = "";
                
            }
            
            else {
                
                cur+= String.valueOf(s.charAt(i));
            }
        }
        
        if (!cur.isEmpty()){
                    
            output = cur+" "+output;
                    
        }
        
        return output.substring(0,output.length()-1);
        
    }
}
