class Solution:
    def search(self, nums: List[int], target: int) -> int:
        l, r = 0, len(nums) - 1

        # try to find pivot index
        while l <= r:
            m = (l + r) // 2
            # found target 
            if target == nums[m]:
                return m

            # left side is sorted
            if nums[l] <= nums[m]:
                # target is not in sorted portion
                if target > nums[m] or target < nums[l]:
                    l = m + 1
                else:
                    r = m - 1
            else:
                # right side is sorted
                # ex: [7, 0, 1, 2, 4, 5, 6]
                if target < nums[m] or target > nums[r]:
                    r = m - 1
                else:
                    l = m + 1
         
        return -1