# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def getDirections(self, root: Optional[TreeNode], startValue: int, destValue: int) -> str:
        
        def helper(curr, path, tgt):
            if not curr:
                return False
            
            if curr.val == tgt:
                return True
            
            path.append("L")
            if helper(curr.left, path, tgt):
                return True
            path.pop()

            path.append("R")
            if helper(curr.right, path, tgt):
                return True
            path.pop()
        
            return False
    
        start_path = []
        dest_path = []
        helper(root, start_path, startValue)
        helper(root, dest_path, destValue)

        i = 0
        n = min(len(start_path), len(dest_path))
        while i < n and start_path[i] == dest_path[i]:
            i += 1
        
        res = ["U"] * (len(start_path) - i)
        res += dest_path[i:]
        return "".join(res)

            
            
