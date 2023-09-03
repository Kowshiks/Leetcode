class Solution {
    
    // Dynamic Programming
    
    public int uniquePaths(int m, int n) {
        
        int[] cache = new int[n];
        
        for(int i=0; i<n; i++) {
            
            cache[i] = 1;
        }
        
        for(int i = m-2; i >=0; i--) {
            
            int cur[] = new int[n];
            
            cur[cur.length-1] = 1;
            
            for (int j = n-2; j >= 0; j--) {
                
                cur[j] = cur[j+1] + cache[j];
                
            }
            
            cache = cur;
            
        }
        
        return cache[0];
        
    }
    
    
    // Recursion Solution with Caching
    
    HashMap<Pair<Integer,Integer>,Integer> cache = new HashMap<>();
    
    int m;
    
    int n;
    
    private int rec(int r, int c) {
        
        Pair<Integer,Integer> cur_key = new Pair<>(r,c);
        
        if ((r == m-1) && (c == n-1)) {
            
            return 1;
            
        }
        
        if (cache.containsKey(cur_key)) {
            
            return cache.get(cur_key);
            
        }
        
        if ((r > m-1) || (c > n-1)){
            
            return 0;
        }
        
        int down = rec(r+1,c);
        
        int right = rec(r,c+1);
            
        int tot = down + right;
        
        cache.put(cur_key,tot);
        
        return tot;
        
        
    }
    
    public int uniquePaths(int m, int n) {
        
        this.m = m;
        
        this.n = n;
        
        return rec(0,0);
        
    }
    
}
