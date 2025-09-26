class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        res = 0 
        charSet = set()
        left = 0
        for right in range(len(s)):
            # found duplicate
            while s[right] in charSet:
                # reset pointer
                charSet.remove(s[left])
                left += 1
            # create new substring and update res 
            charSet.add(s[right])
            res = max(res, right - left + 1)

        return res