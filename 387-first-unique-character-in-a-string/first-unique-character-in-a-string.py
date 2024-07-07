class Solution:
    def firstUniqChar(self, s: str) -> int:
        seen = {}

        for char in s:
            seen[char] = seen.get(char, 0) + 1
        
        for char in seen:
            if seen[char] == 1:
                return s.index(char)
        
        return -1
        