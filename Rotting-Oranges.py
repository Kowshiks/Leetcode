class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        
        rows = len(grid)
        cols = len(grid[0])
        
        output_grid = [[float('inf') for i in range(cols)] for j in range(rows)]
        
        moves = [[-1,0],[1,0],[0,-1],[0,1]]
        
        def valid(r,c,visit):
            
            if r not in range(rows):
                
                return False
            
            if c not in range(cols):
                
                return False
            
            if (r,c) in visit:
                
                return False
            
            if grid[r][c] != 1:
                
                return False
            
            return True
            
        def bfs(i,j):
            
            visited = set()
            
            fringe = collections.deque()
            
            fringe.append((i,j,0))
            
            while fringe:
                
                r,c,index = fringe.popleft()
                
                visited.add((r,c))
                
                for move in moves:
                    
                    r1 = r + move[0]
                    c1 = c + move[1]
                    
                    if valid(r1,c1,visited):
        
                        visited.add((r1,c1))
            
                        fringe.append((r1,c1,index+1))
                
                        output_grid[r1][c1] = min(index+1,output_grid[r1][c1])
        
        for i in range(rows):
            
            for j in range(cols):
                
                if grid[i][j] == 2:
                    
                    output_grid[i][j] = 0
                    
                    bfs(i,j)
                    
                if grid[i][j] == 0:
                    
                    output_grid[i][j] = 0
                    
        output = 0
                    
        for i in range(rows):
            
            for j in range(cols):
                
                output = max(output,output_grid[i][j])
                                
        if output == float('inf'):
            
            return -1
        
        return output
