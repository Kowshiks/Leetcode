class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {
        
        int cache[amount+1];
        
        std::fill(cache,cache+(amount+1),amount+1);
        
        cache[0] = 0;
        
        for (int i {1}; i < amount+1; i++){
            
            for(int each: coins) {
                
                if (i - each >= 0) {
                
                    cache[i] = std::min(cache[i],cache[i-each]+1);
                    
                }  
            } 
        }
        
        if (cache[amount] != amount+1)
        
            return cache[amount];
        
        return -1;
        
    }
};
