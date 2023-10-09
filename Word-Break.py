class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
            
        output = False
        
        cache = {}
        
        def rec(index):
            
            nonlocal output
            
            tmp = False
            
            if index == len(s):
                
                output = True
                
                return True
            
            if index in cache:
                
                return cache[index]
        
            for each in wordDict:
                
                if each == s[index:index+len(each)]:
                    
                    tmp = rec(index+len(each))
                    
            cache[index] = tmp
                    
            return tmp
        
        rec(0)
        
        return output
