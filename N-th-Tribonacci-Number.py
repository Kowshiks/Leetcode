class Solution:
    def tribonacci(self, n: int) -> int:
        
        def rec(node1,node2,node3,index):
            
            if n == 0:
                
                return 0
        
            elif n == 1 or n == 2:
                
                return 1
            
            elif index == n:
                
                return node1 + node2 + node3
                
            out = rec(node2,node3,node1 + node2 + node3,index+1)
            
            return out
        
        ans = rec(0,1,1,3)
        
        return ans
