 # Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def longestZigZag(self, root: Optional[TreeNode]) -> int:
        
        output = 0
        fringe = []
        fringe.append((root,0,""))
        
        while fringe:
            
            node, index, path = fringe.pop()
            
            if node.left:
                
                cur = 1
                
                if path != "l":
                    
                    cur = index+1
                
                fringe.append((node.left, cur, "l"))         
                output = max(output, cur)
            
            if node.right:
                
                cur = 1
                                
                if path != "r":
                    
                    cur = index+1
                
                fringe.append((node.right, cur, "r"))
                output = max(output,cur)
                
        return output
        
        
        
