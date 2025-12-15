class Solution:
    def nextPermutation(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """

        # Start at the second-to-last number
        # We do this because we need to compare it to its neighbor (i+1)
        i = len(nums) - 2

        # "While the number I'm looking at is BIGGER than the one to its right..."
        # We are walking up the mountain from the right side.
        # We need to find the first number (from the right) that breaks the increasing trend.
        while i >= 0 and nums[i] >= nums[i + 1]:
            i -= 1
        
        # found a dip
        # We need to find the first number (from the right) that breaks the increasing trend.
        if i >= 0:
            j = len(nums) - 1
            while nums[j] <= nums[i]:
                j -= 1
            nums[i], nums[j] = nums[j], nums[i]

        # Start pointers at the beginning of the tail (i + 1) and the end
        # Since we know tail is descending, we reverse it 
        l, r = i + 1, len(nums) - 1
        while l < r:
            nums[l], nums[r] = nums[r], nums[l]
            l += 1
            r -= 1
