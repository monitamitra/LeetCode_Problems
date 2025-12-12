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

            if not left_search:
                return right_search
            
            if not right_search:
                return left_search
            
            # current node is common ancestor
            return curr
            
        return helper(root)
