class Solution:
    def numMatchingSubseq(self, s: str, words: List[str]) -> int:
        res = 0
        for word in words:
            start = 0
            found = True
            for char in word:
                index_loc = s.find(char, start)
                if index_loc == -1:
                    found = False
                    break
                start = index_loc + 1
            if found:
                res += 1
        return res