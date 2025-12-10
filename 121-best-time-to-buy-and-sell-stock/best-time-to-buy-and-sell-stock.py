class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        res = 0
        minBuy = prices[0]

        # sliding window
        for i in range(1, len(prices)):
            minBuy = min(minBuy, prices[i])
            res = max(res, prices[i] - minBuy)

        return res