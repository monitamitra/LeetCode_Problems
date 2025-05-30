class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        stack = []
        res = 0

        for token in tokens:
            if token == "+" and stack:
                stack.append(stack.pop() + stack.pop())
            elif token == "/" and stack:
                a, b = stack.pop(), stack.pop()
                stack.append(int(float(b) / a))
            elif token == "-" and stack:
                a, b = stack.pop(), stack.pop()
                stack.append(b - a)
            elif token == "*" and stack:
                stack.append(stack.pop() * stack.pop())
            else:
                stack.append(int(token))
        
        return stack[-1]