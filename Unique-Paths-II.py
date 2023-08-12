class Solution:
    def uniquePathsWithObstacles(self, obstacleGrid: List[List[int]]) -> int:
    
        rows = len(obstacleGrid)
        cols = len(obstacleGrid[0])
                
        cache = {}
        
        def rec(index):
            
            if index[0] not in range(rows) or index[1] not in range(cols) or obstacleGrid[index[0]][index[1]]:
                
                return 0
            
            if index in cache.keys():
                
                return cache[index]
            
            if index == (rows-1,cols-1):
                
                return 1
          
            left = rec((index[0],index[1]+1))
            right = rec((index[0]+1,index[1]))
            
            cache[index] = left + right 
            
            return cache[index]
            
        cache[(0,0)] = rec((0,0))
        
        return cache[(0,0)]
