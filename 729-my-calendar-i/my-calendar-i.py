class MyCalendar:

    def __init__(self):
        self.calendar = []

    def book(self, startTime: int, endTime: int) -> bool:
        if not self.calendar:
            self.calendar.append([startTime, endTime])
            return True
        
        l, r = 0, len(self.calendar)
        while l < r:
            m = (l + r) // 2
            curr_interval = self.calendar[m]

            if curr_interval[0] < startTime:
                l = m + 1
            else:
                r = m 
        
        # l is index to insert at
        if l < len(self.calendar):
            # does right neighbor start before I end?
            if self.calendar[l][0] < endTime:
                return False
        
        if l > 0:
            # does left neighbor end after I start?
            if self.calendar[l-1][1] > startTime:
                return False

        self.calendar.insert(l, [startTime, endTime])
        return True
    

# Your MyCalendar object will be instantiated and called as such:
# obj = MyCalendar()
# param_1 = obj.book(startTime,endTime)