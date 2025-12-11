class TimeMap:

    def __init__(self):
        self.map = {}

    def set(self, key: str, value: str, timestamp: int) -> None:
        if key not in self.map:
            self.map[key] = []
        
        self.map[key].append([value, timestamp])

    def get(self, key: str, timestamp: int) -> str:
        res = ""
        values = self.map.get(key, [])
        left, right = 0, len(values) - 1
        
        while left <= right:
            mid = (left + right) // 2
            mid_val = values[mid]
            
            if mid_val[1] == timestamp:
                return mid_val[0]

            if mid_val[1] < timestamp:
                res = mid_val[0]
                left = mid + 1
            elif mid_val[1] > timestamp:
                right = mid - 1
            

        return res


# Your TimeMap object will be instantiated and called as such:
# obj = TimeMap()
# obj.set(key,value,timestamp)
# param_2 = obj.get(key,timestamp)