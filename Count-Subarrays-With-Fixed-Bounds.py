class Solution:
    def countSubarrays(self, nums: List[int], minK: int, maxK: int) -> int:
        
        prev = 0
        
        outreach = {}
        
        minCount = 0
        maxCount = 0
        
        for r in range(len(nums)):
            
            if nums[r] == minK:
                
                minCount+=1
                
            if nums[r] == maxK:
        
                maxCount+=1
            
            if nums[r] < minK:
                
                if minCount > 0 and maxCount > 0:
                
                    outreach[prev] = r-1
                    
                    prev = r+1
                
                else:
                    
                    prev = r+1
                    
                minCount,maxCount = 0,0
            
            elif nums[r] > maxK:
                
                if minCount > 0 and maxCount > 0:
                
                    outreach[prev] = r-1
                    
                    prev = r+1
                    
                else:
                    
                    prev = r+1
                    
                minCount,maxCount = 0,0
                
            
            elif r == len(nums)-1 and (minCount > 0 and maxCount > 0):
                
                outreach[prev] = r
                
        if not outreach:
            
            return 0        
                    
        count = 0
        
        for start,end in outreach.items():
            
            minTmp,maxTmp = -1,-1
            
            for j in range(start,end+1):
                
                if nums[j] == minK:
                    
                    minTmp = j
                    
                if nums[j] == maxK:
                    
                    maxTmp = j
                    
                if minTmp != -1 and maxTmp != -1:
                    
                    tmp = min(minTmp,maxTmp)
                    
                    count += tmp - start + 1 
                    
        return count
