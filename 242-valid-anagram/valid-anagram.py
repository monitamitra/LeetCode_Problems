class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False
            
        seen = {}
        for char in s:
            seen[char] = seen.get(char, 0) + 1
        
        freq = {}
        for char in t:
            freq[char] = freq.get(char, 0) + 1

        for char in t:
            if char not in seen or freq[char] != seen[char]:
                return False
        return True
            
        