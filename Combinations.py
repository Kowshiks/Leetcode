class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        
        output = []
        
        def rec(arr,index):
            
            if index > n+1 or (len(arr) + (n - index) + 1) < k:
                
                return
            
            if len(arr) == k:
                
                output.append(arr.copy())
                
                return

            arr.append(index)
            rec(arr,index+1)
            arr.pop()
            rec(arr,index+1)
            
            return
        
        rec([],1)
        
        return output
