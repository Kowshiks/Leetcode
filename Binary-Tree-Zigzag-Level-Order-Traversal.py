# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def zigzagLevelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        
        if not root:
            
            return None
        
        fringe = collections.deque()
        fringe.append((root,0))
        output = []
        
        while fringe:
            
            node,index = fringe.popleft()
            
            if len(output) < index + 1:
                
                output.append([node.val])
            
            else:
                
                if index % 2 != 0:
                    
                    output[index] = [node.val] + output[index]
                    
                else:
                
                    output[index].append(node.val)
            
            
            if node.left:
                
                fringe.append((node.left,index+1))

            if node.right:
                
                fringe.append((node.right,index+1))
                
        return output
