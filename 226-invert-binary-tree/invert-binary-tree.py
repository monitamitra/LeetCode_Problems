# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def invertTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        if not root:
            return None
        
        def helper(curr):
            # base case 
            if not curr:
                return

            temp_left = curr.left
            temp_right = curr.right

            curr.left, curr.right = curr.right, curr.left

            helper(temp_left)
            helper(temp_right)

        helper(root)
        return root