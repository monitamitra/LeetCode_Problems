# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        
        def helper(curr):
            if not curr or curr.val == p.val or curr.val == q.val:
                return curr

            left_search = helper(curr.left)
            right_search = helper(curr.right)

            # current node is common ancestor
            if left_search and right_search:
                return curr
            
            if left_search:
                return left_search
            else:
                return right_search
            
        return helper(root)
