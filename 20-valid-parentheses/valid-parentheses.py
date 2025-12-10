class Solution:
    def isValid(self, s: str) -> bool:
        map = {"(" : ")", "{" : "}", "[" : "]"}
        stack = []

        for char in s:
            if char in map:
                stack.append(char)
            else:
                if not stack:
                    return False
                
                temp = stack.pop()
                if char != map[temp]:
                    return False
        
        return len(stack) == 0