class Solution {
    
    HashMap<Integer,Integer> cache = new HashMap<>();
    
    int high;
    
    int low;
    
    int zero;
    
    int one;
    
    int maxval = (int) Math.pow(10,9) + 7;

    public int rec(int len) {
        
        int tmp = 0;
        
        if (len > high) {
            
            return 0;
        }
        
        if (cache.containsKey(len)){
            
            return cache.get(len);
        }
        
        if (len >= low) {
            
            tmp = 1;
            
        }
        
        tmp += rec(len+zero) + rec(len+one);
        
        tmp = tmp % maxval;
        
        cache.put(len,tmp);
            
        return cache.get(len);
        
    }
    
    public int countGoodStrings(int low, int high, int zero, int one) {
        
        this.high = high;
        
        this.low = low;
        
        this.zero = zero;
        
        this.one = one;
        
        return rec(0);
        
    }
}
