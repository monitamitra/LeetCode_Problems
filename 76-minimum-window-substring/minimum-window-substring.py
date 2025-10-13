class Solution:
    def minWindow(self, s: str, t: str) -> str:
        if t == "":
            return ""
        
        countT, window = {}, {}

        for ch in t:
            countT[ch] = countT.get(ch, 0) + 1
        
        have, need = 0, len(countT) # unique chars in T
        res, resLen = [-1, -1], float("infinity")
        l = 0

        for r in range(len(s)):
            ch = s[r]
            window[ch] = window.get(ch, 0) + 1

            # just satisfied condition
            if ch in countT and window[ch] == countT[ch]:
                have += 1
            
            # while conditions are met, make string as min as possible 
            while have == need:
                # update our result 
                if r - l + 1 < resLen:
                    res = [l, r]
                    resLen = r - l + 1
                
                # pop from left of our window
                window[s[l]] -= 1
                if s[l] in countT and window[s[l]] < countT[s[l]]:
                    have -= 1
                l += 1
                
        l, r = res
        return s[l:r + 1] if resLen != float("infinity") else ""