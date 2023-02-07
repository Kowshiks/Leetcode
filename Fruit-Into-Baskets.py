class Solution:
    def totalFruit(self, fruits: List[int]) -> int:
        
        if len(fruits) == 1:
            
            return 1
        
        if fruits[0] == fruits[1]:
        
            cache = [[fruits[0],0],[fruits[1],0]]
        
        else:
            
            cache = [[fruits[0],0],[fruits[1],1]]
            
        output = 2
        index = 0
        
        for i in range(2,len(fruits)):
            
            if fruits[i] != cache[0][0] and fruits[i] != cache[1][0]:
                
                cache[0] = cache[1]
                cache[1] = [fruits[i],i]
            
            elif fruits[i] == cache[0][0] and cache[0] != cache[1]:
                
                tmp = cache[0][0]
                cache[0][0] = cache[1][0] 
                cache[1] = [tmp,i]
            
            output = max(output,i-cache[0][1]+1)
                 
        return output
