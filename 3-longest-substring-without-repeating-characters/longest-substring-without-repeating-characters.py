class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        map = {}
        l = 0
        res = 0

        for r in range(len(s)):
            if s[r] in map:
                # l = start index of curr window
                # if last seen index > l, duplicate is in window
                # if last seen index < l, duplicate is out of curr window
                l = max(map[s[r]] + 1, l)
            map[s[r]] = r
            res = max(res, r - l + 1)
        
        return res