class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        
        l = 1
        r = max(piles)
        ans = r
        
        while l <= r:
            
            mid = (l+r)//2        
            count = 0
            
            for i in piles:
                
                count += math.ceil(i/mid)
                
            if count <= h:
                
                ans = min(ans,mid)               
                r = mid-1
            
            else:
                
                l = mid+1
                 
        return ans
            
