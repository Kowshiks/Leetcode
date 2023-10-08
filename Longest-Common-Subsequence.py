class Solution:
    def longestCommonSubsequence(self, text1: str, text2: str) -> int:
        
        arr = [0] * (len(text1)+1)
        
        for i in range(len(text2)-1,-1,-1):
            
            cur = [0] * (len(text1)+1)
            
            for j in range(len(text1)-1,-1,-1):
                
                same_val = 0
                
                if text2[i] == text1[j]:
                    
                    same_val+=1
                    
                    cur[j] = same_val + arr[j+1]
                    
                else:
                    
                    cur[j] = max(cur[j+1],arr[j])
                            
            arr = cur[:]                
                
        return arr[0]
