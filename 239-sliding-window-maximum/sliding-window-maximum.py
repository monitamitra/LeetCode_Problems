class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        output = []
        l, r = 0, 0
        q = deque() # contain indices

        while r < len(nums):
            # while smaller values exist, pop values from q
            while q and nums[q[-1]] < nums[r]:
                q.pop()
            q.append(r)

            # remove left val from window
            if l > q[0]:
                q.popleft()
            
            if (r + 1) >= k:
                output.append(nums[q[0]])
                l += 1
            r += 1

        return output
