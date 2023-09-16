class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        
        """
        cache = {}
        
        def valid(r,c):
            
            if r not in range(len(board)):
                
                return False
            
            if c not in range(len(board[0])):
                
                return False
            
            return True
        
        moves = [[-1,-1],[-1,0],[-1,1],[0,-1],[0,1],[1,-1],[1,0],[1,1]]
        
        for i in range(len(board)):
            
            for j in range(len(board[0])):
                
                cnt = 0
                
                for move in moves:
                    
                    r = i + move[0]
                    c = j + move[1]
                    
                    if valid(r,c) and board[r][c] ==1:
                        
                        cnt+=1
                                        
                cache[(i,j)] = cnt
        
        for i in range(len(board)):
            
            for j in range(len(board[0])):
                
                if board[i][j] == 0:
                    
                    if cache[(i,j)] == 3:
                        
                        board[i][j] = 1
                        
                else:
                    
                    if cache[(i,j)] < 2 or cache[(i,j)] > 3:
                        
                        board[i][j] = 0
                        
                    
        
                    
                        
                    
                        
                
                
        
