# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def delNodes(self, root: Optional[TreeNode], to_delete: List[int]) -> List[TreeNode]:
        
        output = []
        
        fringe = [root]
        
        while fringe:
            
            cur = fringe.pop()
            
            if cur.val in to_delete:
                                
                if cur.left:
                    
                    fringe.append(cur.left)
                    
                if cur.right:
                    
                    fringe.append(cur.right)
                    
            else:
                
                output.append(cur)
                
                cur_node = [cur]
                
                while cur_node:
                    
                    cur_pop = cur_node.pop()
                    
                    if cur_pop.left:
                        
                        if cur_pop.left.val in to_delete:
                            
                            val = cur_pop.left
                            
                            fringe.append(val)
                            
                            cur_pop.left = None
                            
                        else:
                            
                            cur_node.append(cur_pop.left)
                            
                    if cur_pop.right:
                        
                        if cur_pop.right.val in to_delete:                            
                            
                            val = cur_pop.right
                                                        
                            fringe.append(val)
                            
                            cur_pop.right = None
                            
                        else:
                            
                            cur_node.append(cur_pop.right)                        
                            
        return output
                            
                            
                            
        
