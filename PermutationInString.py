class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        
        cache = {}
        
        for i in s1:
            
            if i not in cache.keys():
                
                cache[i] = 1
            
            else:
                
                cache[i]+=1
                
        total = 0
        
        count = 0
        
        for i in s1:
            
            total += ord(i)
            
            count += 1
        
        l = 0
        
        val = 0
        
        tmp_cache = {}
        
        for r in range(len(s2)):
            
            if s2[r] not in tmp_cache.keys():
                
                tmp_cache[s2[r]] = 1
            
            else:
                        
                tmp_cache[s2[r]] += 1
            
            val += ord(s2[r])
        
            if val > total or (r-l+1) > count:
                
                val = val - ord(s2[l])
                
                tmp_cache[s2[l]] = tmp_cache[s2[l]] - 1
                
                if tmp_cache[s2[l]] == 0:
                    
                    del tmp_cache[s2[l]]
                
                l+=1
            
            if val == total and (r-l+1) == count:
                                
                if cache == tmp_cache:
            
                    return True
            
                else:
                    
                    val = val - ord(s2[l])
                    
                    tmp_cache[s2[l]] = tmp_cache[s2[l]] - 1
                
                    if tmp_cache[s2[l]] == 0:
                    
                        del tmp_cache[s2[l]]
                    
                    l+=1
            
        return False
