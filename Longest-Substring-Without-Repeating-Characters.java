class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int output = 0;
        
        int l = 0;
        
        HashSet<Character> cache = new HashSet<>();
        
        for(int r=0; r< s.length(); r++) {
            
            if (cache.contains(s.charAt(r))){
                
                while (s.charAt(l) != s.charAt(r)){
                    
                    cache.remove(s.charAt(l));
                    l+=1;
                }
                
                l+=1;
                
            }
            
            else{
                
                cache.add(s.charAt(r));
                
            }
                
            output = Math.max(output,r-l+1);
            
        }
        
        return output;
        
    }
}
