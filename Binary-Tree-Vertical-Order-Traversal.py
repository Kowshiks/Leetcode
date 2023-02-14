# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def verticalOrder(self, root: Optional[TreeNode]) -> List[List[int]]:

        if not root:

            return []

        output = []

        cache = {}

        fringe = collections.deque()

        fringe.append((root,0))

        tmp = float('inf')

        while fringe:

            node, val = fringe.popleft()

            if val not in cache.keys():

                cache[val] = [node.val]
            
            else:

                cache[val].append(node.val)
            
            tmp = min(tmp,val)

            if node.left:

                fringe.append((node.left,val-1))
            
            if node.right:

                fringe.append((node.right,val+1))


        while tmp in cache.keys():

            output.append(cache[tmp])

            tmp+=1

        return output
