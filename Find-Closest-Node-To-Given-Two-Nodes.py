class Solution:
    def closestMeetingNode(self, edges: List[int], node1: int, node2: int) -> int:
        
        if node1 == node2:
            
            return node1
        
        cache = {}
        
        for i in range(len(edges)):
            
            cache[i] = edges[i]
            
        val1 = True
        val2 = True
        
        set1 = set()
        set2 = set()
        
        set1.add(node1)
        set2.add(node2)
        
        tmp = False
        
        ans1 = float('inf')
        ans2 = float('inf')
        
        
        while val1 or val2:            
            
            if cache[node1] != -1 and cache[node1] not in set1:
                
                set1.add(cache[node1])
                
                if cache[node1] in set2:
                
                    ans1 = cache[node1]
                    
                    tmp = True
                
                node1 = cache[node1]
            
            else:
                
                val1 = False
            
            if cache[node2] != -1 and cache[node2] not in set2:
                
                set2.add(cache[node2])
                
                if cache[node2] in set1:
       
                    ans2 = cache[node2]
                    
                    tmp = True
    
                node2 = cache[node2] 
                
            
            else:
                
                val2 = False
            
            if tmp:
                
                return min(ans1,ans2)
                
        return -1
