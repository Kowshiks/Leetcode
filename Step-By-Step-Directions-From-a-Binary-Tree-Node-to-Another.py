# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def getDirections(self, root: Optional[TreeNode], startValue: int, destValue: int) -> str:
        
        fringe = []
        
        fringe.append((root,""))
        
        while fringe:
            
            node, path = fringe.pop()
            
            if node.val == startValue:
                
                start_path = path
            
            if node.val == destValue:
                
                end_path = path
                
            if node.left:

                fringe.append((node.left,path+"L"))

            if node.right:

                fringe.append((node.right,path+"R"))
            
        if not start_path:
            
            return end_path
        
        elif not end_path:
            
            return "U" * len(start_path)
        
        elif start_path[0] != end_path[0]:
            
            return "U" * len(start_path) + end_path
        
        else:
            
            index = 0
            
            while start_path[index] == end_path[index]:
                
                index+=1
            
                if index == len(end_path):
                    
                    return "U" * (len(start_path) - index)
                
                if index == len(start_path):
                    
                    return end_path[index:]
                
            return "U" * (len(start_path) - index) + end_path[index:]
