class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        res = 0
        i = 0
        charSet = set()

        for j in range(len(s)):
            while s[j] in charSet:
                charSet.remove(s[i])
                i += 1
            
            charSet.add(s[j])
            res = max(res, j - i + 1)            
        return res