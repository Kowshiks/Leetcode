class Solution:
    def constrainedSubsetSum(self, nums: List[int], k: int) -> int:
        
        ans = max(nums)
        
        heap = []
                
        for j in range(len(nums)):
            
            if heap:
                
                val = heapq.heappop(heap)
                
                while j - val[1] > k:
                    
                    val = heapq.heappop(heap)
                    
                heapq.heappush(heap,val)
                
                cur_val = max(nums[j]+(val[0]*(-1)),nums[j])
                    
                heapq.heappush(heap,((-1*cur_val),j))
                
                ans = max(ans,cur_val)
            
            else:
                
                heapq.heappush(heap,((-1)*nums[j],j))
                
        return ans
