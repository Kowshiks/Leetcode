class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        
        cache = {}
        
        for i in range(len(s)):
                
            cache[s[i]] = i
            
        output = []
        
        prev = 0
        
        max_val = 0
        
        for i in range(len(s)):
            
            max_val = max(max_val,cache[s[i]])
            
            if max_val == i:
                
                output.append(max_val+1-prev)
                
                prev += output[-1]
                
        return output
