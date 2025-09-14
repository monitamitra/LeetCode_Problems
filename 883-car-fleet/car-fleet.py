class Solution:
    def carFleet(self, target: int, position: List[int], speed: List[int]) -> int:
        pair = [[p, s] for p, s in zip(position, speed)]
        stack = []

        # reverse sorted order
        for p, s, in sorted(pair)[::-1]:
            # appends time for car to get to target
            stack.append((target - p) / s)
            if len(stack) >= 2 and stack[-1] <= stack[-2]:
                # add a car to the fleet
                stack.pop()

        return len(stack)