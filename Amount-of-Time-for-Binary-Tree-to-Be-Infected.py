# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def amountOfTime(self, root: Optional[TreeNode], start: int) -> int:

        tmp = [0]

        def rec(node):

            if not node:

                return (0,False)

            left,left_check = rec(node.left)

            right,right_check = rec(node.right)

            if node.val == start:

                tmp[0] = max(left,right)

                return (1,True)

            if left_check or right_check:

                tmp[0] = max(tmp[0],left+right)

                if left_check:

                    return (1+left,True)

                else:

                    return (1+right,True)
            
            else:

                return (1+max(left,right),False)

        
        x,y = rec(root)

        return tmp[0]
