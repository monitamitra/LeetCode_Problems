class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        res = []
        tgt = newInterval[0]
        l, r = 0, len(intervals) - 1
        while l <= r:
            m = (l + r) // 2
            curr_interval = intervals[m]
            if curr_interval[0] < tgt:
                l = m + 1
            else:
                r = m - 1
            
        intervals.insert(l, newInterval)

        for interval in intervals:
            if not res or res[-1][1] < interval[0]:
                res.append(interval)
            else:
                res[-1][1] = max(res[-1][1], interval[1])
        
        return res
            
