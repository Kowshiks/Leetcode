class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        
        output = []
        
        if len(s) < len(p):
            
            return output
        
        tmp_main = [0]*26
        
        for i in p:
            
            tmp_main[ord(i)-ord('a')] += 1
        
        tmp = [0]*26
        
        for i in range(len(p)):
            
            tmp[ord(s[i])-ord('a')] += 1
            
        if tmp == tmp_main:
            
            output.append(0)
            
        index = len(p)
            
        for i in range(1,len(s)-len(p)+1):
            
            tmp[ord(s[i-1])-ord('a')] -= 1
            
            tmp[ord(s[index])-ord('a')] += 1
            
            if tmp == tmp_main:
                
                output.append(i)
                
            index+=1
                
        return output
            
        
        
                
        
        
                
        
        
        
        
        
        
