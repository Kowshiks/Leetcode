class Solution:
    def minRemoveToMakeValid(self, s: str) -> str:
        
        stack = []
        
        index = []
        
        for i in range(len(s)):
            
            if s[i] == "(":
                
                stack.append(i)
            
            if s[i] == ")":
                
                if not stack:
                    
                    index.append(i)
                    
                else:
                    
                    stack.pop()
                    
        for i in stack:
                
            index.append(i)
            
        tmp = 0
                
        for i in index:
            
            s = s[:i-tmp] + s[i+1-tmp:]
            
            tmp+=1
            
        return s
