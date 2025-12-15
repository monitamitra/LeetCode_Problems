class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        answer = [0] * len(temperatures)
        stack = []
        
        for i, curr_temp in enumerate(temperatures):
            while stack and curr_temp > temperatures[stack[-1]]:
                prev_index = stack.pop()
                answer[prev_index] = i - prev_index
            stack.append(i)

        # [0]
        
        # brute force
        # for i in range(len(temperatures)):
        #     curr_temp = temperatures[i]
        #     for j in range(i + 1, len(temperatures)):
        #         if temperatures[j] > curr_temp:
        #             answer[i] = j - i
        #             break

        return answer