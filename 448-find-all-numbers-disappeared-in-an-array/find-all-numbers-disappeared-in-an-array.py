class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        # every # in nums will be positive
        # range of indices is 0 -> n - 1
        
        # mark existing
        for n in nums:
            i = abs(n) - 1
            nums[i] = -1 * abs(nums[i])
        
        res = []
        for i, n in enumerate(nums):
            if n > 0:
                res.append(i + 1)
        
        return res
        