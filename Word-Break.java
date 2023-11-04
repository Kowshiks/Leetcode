class Solution {
    
    String s;
    List<String> wordDict;
    
    HashMap<Integer,Boolean> cache = new HashMap<>();    
    
    public boolean rec(int index) {
        
        if (index == s.length()) {
                                    
            return true;
        }
        
        if (index > s.length()) {
            
            return false;
        }
        
        if (cache.containsKey(index)) {
            
            return cache.get(index);
        }
        
        Boolean ans = false;
        
        for (String each:wordDict) {
            
            if ((index+each.length()) <= s.length()) {
            
                if (s.substring(index,index+each.length()).equals(each)){

                    ans = ans || rec(index+each.length());

                }
                
            }
            
        }
        
        cache.put(index,ans);
        
        return ans;
        
    }
    
    public boolean wordBreak(String s, List<String> wordDict) {
        
        this.s = s;
        this.wordDict = wordDict;
        
        return rec(0);
        
    }
}
