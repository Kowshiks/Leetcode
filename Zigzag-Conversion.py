class Solution:
    def convert(self, s: str, numRows: int) -> str:
        
        if numRows == 1:
            
            return s
        
        output = ''
        increment = 1
        index = 0
        cache = {}
                
        for i in range(len(s)):
            
            if increment > 0:
            
                if index not in cache.keys():

                    cache[index] = ''
                    cache[index] = cache[index]+s[i]

                else:

                    cache[index] = cache[index]+s[i]
                
                index+=increment
                
            
            else:
              
                index+=increment
                cache[index] = cache[index]+s[i]
                
                if index == 1:
                    
                    increment = 1
                    index = 0

            
            if index == numRows:
                
                if numRows != 2:
                
                    increment = -1
                    index+=increment
                
                else:
                    
                    index = 0
                
        for key,value in cache.items():
            
            output = output + value
        
        return output
