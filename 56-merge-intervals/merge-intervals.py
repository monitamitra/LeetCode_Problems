class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        # sort list based on start num in each pair
        intervals.sort(key = lambda pair: pair[0])
        # first interval in now sorted list
        output = [intervals[0]]

        # iterates over every interval
        for start, end in intervals:
            # gets end value of last interval
            lastEnd = output[-1][1]

            # intervals overlap
            if start <= lastEnd:
                output[-1][1] = max(lastEnd, end)
            else:
                output.append([start, end])
        
        return output
