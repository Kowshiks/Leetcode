class Solution {
    public int maxRepOpt1(String text) {
        
        HashMap<Character, int[]> cache = new HashMap<>();
        
        int q;
        
        for(int i=0; i<text.length(); i++) {
            
            if (cache.containsKey(text.charAt(i))) {
                
                q =  cache.get(text.charAt(i))[0];
                                
                cache.put(text.charAt(i),new int[] {q,i});
                
            }
            
            else {
                
                cache.put(text.charAt(i),new int[] {i,i});
                
            }
            
        }
        
        int output = 0;
        
        int index = 0;
        
        int check;
        
        while (index < text.length()) {
            
            int l = index;
            
            int first = cache.get(text.charAt(l))[0];
                                  
            int last = cache.get(text.charAt(l))[1];
            
            
            
            int cur = index+1;
            
            while ((cur < text.length()) && text.charAt(l) == text.charAt(cur)) {
                                
                cur+=1;
                
            }
            
            index = cur;
            
            if (last != cur - 1 || first != l) {
                
                
                if (first != l) {
                    
                    check = text.length();
                }
                
                else {
                    
                    check = last;
                }
                
                cur+=1;
                
                while ((cur < text.length()) && (text.charAt(l)) == text.charAt(cur) && (cur < check)) {
                                
                    cur+=1;                       
                
                }      
            }
                 
            output = Math.max(output, cur-l);
        }
        
        return output;
        
    }
}
