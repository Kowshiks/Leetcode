class Solution:
    def minOperations(self, nums: List[int], x: int) -> int:
        
        l = 0
        
        if sum(nums) < x:
            
            return -1
        
        if sum(nums) == x:
            
            return len(nums)
      
        output = float('inf')
        
        count = 0
        
        tot = sum(nums) - x
        
        for r in range(len(nums)):
            
            count += nums[r]                       
            
            if count >= tot:
                
                while count > tot:
                    
                    count-=nums[l]
                
                    l+=1
                    
                if count == tot:
                
                    val = l + (len(nums)-1) - r

                    output = min(output,val)

                    count-=nums[l]

                    l+=1 
                    
        return output if output != float('inf') else -1
                
                
                
            
        
