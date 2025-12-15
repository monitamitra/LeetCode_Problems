class Solution:
    def decodeString(self, s: str) -> str:
        res = []
        k = 0
        char_stack = []
        num_stack = []

        for char in s:
            if char.isdigit():
                k = k * 10 + int(char)
            elif char.isalpha():
                res.append(char)
            
            if char == "[":
                # store onto stack to pull later
                num_stack.append(k)
                char_stack.append("".join(res))

                # reset variables
                res = []
                k = 0

            elif char == "]":
                prefix = char_stack.pop()
                temp_num = num_stack.pop()

                inner_string = "".join(res)
                new_segment = prefix + (inner_string * temp_num)
                res = [new_segment]

        return "".join(res)