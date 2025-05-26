class Solution:
    def maxArea(self, height: List[int]) -> int:
        res = 0
        i = 0
        j = len(height) - 1

        while i < j:
            curr_height = min(height[i], height[j])
            curr_area = curr_height * (j - i)
            res = max(curr_area, res)

            if height[i] <= height[j]:
                i += 1
            else:
                j -= 1

        return res