# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxPathSum(self, root: Optional[TreeNode]) -> int:
        
        output = [root.val]
        
        def rec(node):
            
            if not node:
                
                return 0
            
            left_val = rec(node.left)
            
            right_val = rec(node.right)
            
            cur_val = max(node.val + left_val, node.val + right_val,node.val)
                                    
            output[0] = max(output[0], cur_val, node.val + left_val + right_val)
        
            return cur_val
        
        ans = rec(root)
        
        return output[0]
