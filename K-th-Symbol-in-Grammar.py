class Solution:
    def kthGrammar(self, n: int, k: int) -> int:
        
        left = 1
        
        right = 2**(n-1)
        
        output = 0
        
        index = 1
        
        while index < n:
            
            mid = (left + right)//2
            
            if k <= mid:
                
                right = mid
                
            else:
                left = mid+1
                
                if output == 0:
                    
                    output = 1
                    
                elif output == 1:
                    
                    output = 0
                    
            index+=1
            
        return output
