class Solution:
    def solveSudoku(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        
        row = len(board)
        col = len(board[0])
        
        count = 0
        
        row_val = {}
        column_val = {}
        box_val = {}
        
        # Create empty cache for row, col and the box
        
        for i in range(9):
            
            row_val[i] = {}
            column_val[i] = {}
            box_val[i] = {}
        
        # Fill in the row, col and box with the existing values
        
        for i in range(row):
            
            for j in range(col):
                
                if board[i][j] != ".":
                    
                    if i < 3 and j < 3:
                        box_val[0][board[i][j]] = (i,j)
                    elif i < 3 and j < 6:
                        box_val[1][board[i][j]] = (i,j)
                    elif i < 3:
                        box_val[2][board[i][j]] = (i,j)
                    elif i < 6 and j < 3:
                        box_val[3][board[i][j]] = (i,j)
                    elif i < 6 and j < 6:
                        box_val[4][board[i][j]] = (i,j)
                    elif i < 6:
                        box_val[5][board[i][j]] = (i,j)
                    elif i < 9 and j < 3:
                        box_val[6][board[i][j]] = (i,j)
                    elif i < 9 and j < 6:
                        box_val[7][board[i][j]] = (i,j)
                    else:
                        box_val[8][board[i][j]] = (i,j)
                    
                    
                    row_val[i][board[i][j]] = (i,j)
                    column_val[j][board[i][j]] = (i,j)
                    
                # Else count the empty spaces
                    
                else:
                    
                    count += 1
        
        # Recursive function
        
        def rec(board,rows_data,cols_data,box_data,dot_count):
            
            # If the empty space count is 0 then return True
            
            if dot_count == 0:
                return True
            
            # Recursively fill in the empty spaces
                
            for i in range(row):
                for j in range(col):
                
                    if board[i][j] == ".":
                        
                        for k in range(1,10):
                            
                            if str(k) not in rows_data[i] and str(k) not in cols_data[j]:
                                
                                newBox = box_data.copy()
                                newRow = rows_data.copy()
                                newCol = cols_data.copy()
                                
                                cache = False
                        
                                if i < 3 and j < 3:
                                    if str(k) not in box_data[0]:
                
                                        num = 0
                                        cache = True
                                        
                                elif i < 3 and j < 6:
                                    if str(k) not in box_data[1]:
                                        
                                        num = 1
                                        cache = True
                                        
                                elif i < 3:
                                    if str(k) not in box_data[2]:
                                  
                                        num = 2
                                        cache = True
                                        
                                elif i < 6 and j < 3:
                                    if str(k) not in box_data[3]:
                                        
                                        num = 3
                                        cache = True
                                        
                                elif i < 6 and j < 6:
                                    if str(k) not in box_data[4]:
                                
                                        num = 4
                                        cache = True
                                        
                                elif i < 6:
                                    if str(k) not in box_data[5]:
                                    
                                        num = 5
                                        cache = True
                                        
                                elif i < 9 and j < 3:
                                    if str(k) not in box_data[6]:
                                        
                                        num = 6
                                        cache = True
                                        
                                elif i < 9 and j < 6:
                                    if str(k) not in box_data[7]:
                                        
                                        num = 7
                                        cache = True
                                        
                                elif i < 9:
                                    if str(k) not in box_data[8]:
                                        
                                        num = 8
                                        cache = True
                                        
                                if cache:
                                
                                    board[i][j] = str(k)
                                    newBox[num][str(k)] = (i,j)
                                    newRow[i][str(k)] = (i,j)
                                    newCol[j][str(k)] = (i,j)

                                    tmp = rec(board,newRow,newCol,newBox,dot_count-1)

                                    if tmp:

                                        return tmp

                                    board[i][j] = "."
                                    del newBox[num][str(k)]
                                    del newRow[i][str(k)]
                                    del newCol[j][str(k)]
            
                    if board[i][j] == ".":
                                                
                        return False
            
        rec(board,row_val,column_val,box_val,count)
        
       
        
        
        
                    
        
