class Solution:
    def numWays(self, steps: int, arrLen: int) -> int:
        
        mod = 10**9 + 7
        
        cache = {}
        
        def rec(index,count):
            
            if count == steps and index == 0:
    
                return 1
            
            if count > steps or index < 0 or index > arrLen - 1:
                
                return 0
            
            if (index,count) in cache.keys():
                
                return cache[(index,count)]
            
            stay = rec(index,count+1) % mod
            
            left = rec(index-1,count+1) % mod
            
            right = rec(index+1,count+1) % mod
            
            cache[(index,count)] = (stay + left + right) % mod
            
            return cache[(index,count)]
    
        rec(0,0)
        
        return cache[(0,0)]
