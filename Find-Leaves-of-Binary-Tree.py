# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def findLeaves(self, root: Optional[TreeNode]) -> List[List[int]]:

        output = []

        def rec(node):

            if not node:
                return 0
         
            index_1 = rec(node.left)
            index_2 = rec(node.right)


            cur_val  = max(index_1,index_2)

            if len(output) <= cur_val:

                output.append([node.val])
            
            else:

                output[cur_val].append(node.val)

            return cur_val+1

        rec(root)

        return output
