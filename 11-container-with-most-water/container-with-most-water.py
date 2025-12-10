class Solution:
    def maxArea(self, height: List[int]) -> int:
        left = 0
        right = len(height) - 1
        res = 0

        while left != right:
            currArea = min(height[left], height[right]) * abs(right - left)
            res = max(currArea, res)
            if height[left] <= height[right]:
                left += 1
            else:
                right -= 1
        
        return res