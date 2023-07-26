class Solution:
    def findOriginalArray(self, changed: List[int]) -> List[int]:
        
        if len(changed) % 2 != 0:
            
            return []
        
        changed.sort()
        
        cache = {}
        
        index = len(changed)/2
                
        output = []
        
        for i in range(len(changed)):
            
            if changed[i]/2 in cache:
                
                cache[changed[i]/2] -= 1
                
                if cache[changed[i]/2] == 0:
                    
                    del cache[changed[i]/2]
            
            elif changed[i] in cache:
                
                cache[changed[i]] += 1
                
                output.append(changed[i])
                
            else:
                
                cache[changed[i]] = 1
                
                output.append(changed[i])

            if len(output) > index:
                
                return []
          
        return output
                
                
                
                
            
            
        
        
        
        
