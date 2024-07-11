class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        pairs = {
            '(': ')',
            '{': '}',
            '[': ']'
        }

        for parantheses in s:
            if parantheses in pairs:
                stack.append(parantheses)
            elif len(stack) == 0 or parantheses != pairs[stack.pop()]:
                return False
        
        return len(stack) == 0