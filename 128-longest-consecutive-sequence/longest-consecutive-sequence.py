class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        numSet = set(nums)
        res = 0

        for num in numSet:
            # check if its start of sequence
            # doesn't have left neighbor
            if (num - 1) not in numSet:
                curr_len = 0
                while (num + curr_len) in numSet:
                    curr_len += 1
                
                res = max(res, curr_len)

        return res