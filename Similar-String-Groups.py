class Solution:
    def numSimilarGroups(self, strs: List[str]) -> int:
        
        visited = set()
        
        output = 0
        
        cache = {}
        
        for j in range(len(strs)):
            
            init_cache = {}
            
            for k in range(len(strs[j])):
                
                if strs[j][k] not in init_cache.keys():
                
                    init_cache[strs[j][k]] = [k]
                    
                else:
                    
                    val = init_cache[strs[j][k]]
                    
                    val.append(k)
                    
                    val.sort()
                    
                    init_cache[strs[j][k]] = val
                
            cache[j] = init_cache    
        
        for i in range(len(strs)):
            
            if i not in visited:
                                
                output += 1
                
                visited.add(i)
                
                fringe = []
                
                fringe.append(i)
                                
                while fringe:
                                        
                    index = fringe.pop()
                    
                    for each in range(len(strs)):
                        
                        if each not in visited:
                        
                            ans = 0

                            for key,value in cache[index].items():

                                if cache[index][key] != cache[each][key]:

                                    ans+=1

                            if ans <= 2:

                                visited.add(each)

                                fringe.append(each)
                                      
        return output
