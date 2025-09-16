class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        maxArea = 0
        # pair: index, height
        stack = []

        for i, h in enumerate(heights):
            startIndex = i
            # if top value of stacks height is greater than curr height...
            # can't extend height further
            while stack and stack[-1][1] > h:
                # recompute max area
                index, height = stack.pop()
                maxArea = max(maxArea, height * (i - index))
                startIndex = index
            
            stack.append((startIndex, h))
        
        # update maxArea for values which can be extended all the way
        for i, h in stack:
            maxArea = max(maxArea, h * (len(heights) - i))
        
        return maxArea
