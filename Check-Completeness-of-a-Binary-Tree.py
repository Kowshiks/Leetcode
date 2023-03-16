# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCompleteTree(self, root: Optional[TreeNode]) -> bool:
        
        fringe = collections.deque()
        tmp = False
        fringe.append(root)
        
        while fringe:
            
            cur = False
            node = fringe.popleft()
                        
            if node.left and not tmp:
                
                fringe.append(node.left)
                
            else:
                
                if node.left:
                    
                    return False
                
                tmp = True
            
            if node.right and not tmp:
                                
                fringe.append(node.right)
            
            else:
                                
                if node.right:
                    
                    return False
                
                tmp = True
                
        return True
