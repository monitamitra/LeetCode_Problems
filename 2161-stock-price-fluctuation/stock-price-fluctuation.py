class StockPrice:

    def __init__(self):
        self.min_heap = []
        self.max_heap = []
        self.map= {}
        self.latest_time = 0

    def update(self, timestamp: int, price: int) -> None:
        self.map[timestamp] = price
        heapq.heappush(self.min_heap, (price, timestamp))
        heapq.heappush(self.max_heap,(-price, timestamp))

        if timestamp > self.latest_time:
            self.latest_time = timestamp

    def current(self) -> int:
        return self.map[self.latest_time]

    def maximum(self) -> int:
        while True:
            curr_price, timestamp = self.max_heap[0]

            if self.map[timestamp] == -curr_price:
                return -curr_price
            
            # had wrong data
            heapq.heappop(self.max_heap)

    def minimum(self) -> int:
        while True:
            curr_price, timestamp = self.min_heap[0]

            if self.map[timestamp] == curr_price:
                return curr_price
            
            # had wrong data
            heapq.heappop(self.min_heap)


# Your StockPrice object will be instantiated and called as such:
# obj = StockPrice()
# obj.update(timestamp,price)
# param_2 = obj.current()
# param_3 = obj.maximum()
# param_4 = obj.minimum()