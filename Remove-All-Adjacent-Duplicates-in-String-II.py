class Solution:
    def removeDuplicates(self, s: str, k: int) -> str:
        
        count = 0
        stack = []
        
        for i in range(len(s)):
            
            if not stack:
                
                stack.append(s[i])
                count = 0
                
            else:
                
                if s[i] == stack[-1]:
                    
                    count+=1
                    
                else:
                    
                    count = 0
                
                stack.append(s[i])
        
            if count == k-1:
                
                for j in range(k):
                    
                    stack.pop()
                    
                count = 0
                index = len(stack) - 2
                
                while index >= 0:
                    
                    if stack[index] == stack[-1]:
                        count+=1
                        
                    else:
                        break
                        
                    index-=1
            
        return ''.join(stack)
