class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        sorted_intervals = sorted(intervals, key=lambda x: x[0])
        res = [sorted_intervals[0]]

        for i in range(1, len(sorted_intervals)):
            curr_interval = sorted_intervals[i]
            last_interval = res[-1]
            
            if curr_interval[0] <= last_interval[1]:
                res[-1][1] = max(last_interval[1], curr_interval[1])
            else:
                res.append(curr_interval)
        
        return res