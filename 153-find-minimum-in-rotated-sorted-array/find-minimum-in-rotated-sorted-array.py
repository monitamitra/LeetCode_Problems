class Solution:
    def findMin(self, nums: List[int]) -> int:
        res = nums[0]
        l, r = 0, len(nums) - 1

        while l <= r:
            # subarray is already sorted
            if nums[l] < nums[r]:
                # set to left most value of sorted subarray
                res = min(res, nums[l])
                break
            
            m = (l + r) // 2
            res = min(res, nums[m])
            
            # element is part of left sorted portion
            # #s on left will always be greater than #s on right
            # want to search right
            if nums[m] >= nums[l]:
                l = m + 1
            else:
                # search left
                # element in right sorted portion
                r = m - 1
        
        return res

