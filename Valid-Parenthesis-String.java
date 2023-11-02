class Solution {
    
    HashMap<ArrayList<Integer>,Boolean> cache = new HashMap<>();
    
    String s;
    
    public boolean rec(int index,int val) {
        
        boolean ans;
        
        if (val < 0) {
            
            return false;
        }
        
        if ((val == 0) && (index == s.length())){
            
            return true;
        }
        
        if (index >= s.length()) {
            
            return false;
        }
        
        ArrayList<Integer> tmp = new ArrayList<>();
        
        tmp.add(index);
        tmp.add(val);
        
        if (cache.containsKey(tmp)) {
            
            return cache.get(tmp);
        }
        
        if (s.charAt(index) == '(') {
            
            ans = rec(index+1,val+1);
            
        }
        
        else if (s.charAt(index) == ')') {
            
            ans = rec(index+1,val-1);
        }
        
        else {
            
            ans = rec(index+1,val+1) || rec(index+1,val-1) || rec(index+1,val);
        }
        
        cache.put(tmp,ans);
        
        return ans;
        
    }
    
    public boolean checkValidString(String s) {
        
        this.s = s;
        
        return rec(0,0);
        
    }
}
