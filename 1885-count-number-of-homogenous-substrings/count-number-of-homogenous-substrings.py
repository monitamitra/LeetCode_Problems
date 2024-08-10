class Solution:
    def countHomogenous(self, s: str) -> int:
        res = 1
        temp_len = 1

        for i in range(1, len(s)):
            if s[i - 1] == s[i]:
                temp_len += 1
            else:
                temp_len = 1
            
            res += temp_len

        return res % (10**9 + 7)