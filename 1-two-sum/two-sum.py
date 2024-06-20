class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        diff = []
        for i in range(0, len(nums)):
            if target - nums[i] in diff:
                return [i, diff.index(target - nums[i])]
            diff.append(nums[i])
        