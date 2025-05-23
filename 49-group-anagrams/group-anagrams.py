class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        seen = {}
        for word in strs:
            # sorted returns list of characters
            sorted_word = "".join(sorted(word))
            if sorted_word in seen:
                seen[sorted_word].append(word)
            else:
                seen[sorted_word] = [word]

        res = []
        for word in seen:
            temp = seen[word]
            res.append(temp)
        
        return res
