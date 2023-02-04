# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def flipEquiv(self, root1: Optional[TreeNode], root2: Optional[TreeNode]) -> bool:
        
        if root1 == None and root2 == None:
            
            return True
        
        elif root1 == None or root2 == None:
            
            return False
        
        elif root1.val != root2.val:
            
            return False
        
        fringe = collections.deque()
        fringe.append((root1,root2))
        
        while fringe:
            
            node1,node2 = fringe.popleft()
                        
            if (node1.left and node2.left) and (node1.right and node2.right):                
                
                if node1.left.val == node2.left.val:
                    
                    if node1.right.val == node2.right.val:
                        
                        fringe.append((node1.left,node2.left))
                        fringe.append((node1.right,node2.right))
                    
                    else:
                        
                        return False
                
                elif node1.left.val == node2.right.val:
                    
                    if node1.right.val == node2.left.val:
                        
                        fringe.append((node1.left,node2.right))
                        fringe.append((node1.right,node2.left))
                    
                    else:
                        
                        return False
                    
                else:
                    
                    return False
                    
                
            
            elif node1.left and node1.right == None:
                
                
                if node2.left:
                    
                    if (node1.left.val == node2.left.val) and node2.right == None:
                        
                        fringe.append((node1.left,node2.left))
                    
                    else:
                        
                        return False
                
                elif node2.right:
                    
                    if (node1.left.val == node2.right.val) and node2.left == None:
                        
                        fringe.append((node1.left,node2.right))
                    
                    else:
                        
                        return False
                    
                else:
                        
                    return False
            
            elif node1.right and node1.left == None:
                
                if node2.right:
                    
                    if (node1.right.val == node2.right.val) and node2.left == None:
                        
                        fringe.append((node1.right,node2.right))
                    
                    else:
                        
                        return False
                
                elif node2.left:
                    
                    if (node1.right.val == node2.left.val) and node2.right == None:
                        
                        fringe.append((node1.right,node2.left))
                    
                    else:
                        
                        return False
                    
                else:
                        
                    return False
            
            elif (node1.left == None and node2.left == None) and (node1.right == None and node2.right == None):
                
                continue
            
            else:
                
                return False
            
        
        return True
