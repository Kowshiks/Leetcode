class Solution:
    def maximumDetonation(self, bombs: List[List[int]]) -> int:
        
        cache = {i:[] for i in range(len(bombs))}
        
        for i in range(len(bombs)):
            
            for j in range(i+1,len(bombs)):
                
                x1, y1, r1 = bombs[i]
                
                x2, y2, r2 = bombs[j]
                
                d = sqrt((x1 - x2)**2 + (y1 - y2)**2)
                
                if d <= r1:
                    
                    cache[i].append(j)
                    
                
                if d <= r2:
                    
                    cache[j].append(i)
        
        final = 0
        
        for key,value in cache.items():
            
            ans = 1
            
            visited = set()
                
            if value:

                fringe = [key]

                while fringe:

                    cur = fringe.pop()

                    visited.add(cur)

                    each_val = cache[cur]

                    for each in each_val:

                        if each not in visited:

                            fringe.append(each)

                            ans+=1 
                            
                        visited.add(each)
                            
            final = max(final,ans)         
                                
        return final
                            
                            
                
                    
                    
        
