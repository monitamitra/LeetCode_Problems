class Solution:
    def lastStoneWeight(self, stones: List[int]) -> int:
        # no maxheap in python creating minheap
        stones = [-s for s in stones]
        heapq.heapify(stones)

        while len(stones) > 1:
            first = heapq.heappop(stones)
            second = heapq.heappop(stones)

            if second > first: 
                # have to add weight in heap back as negative
                heapq.heappush(stones, first - second)
            
        # handles empty heap edge case
        stones.append(0)
        return abs(stones[0])
