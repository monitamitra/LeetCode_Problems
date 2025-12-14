class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        # initialize with value bigger than possible 
        # max # of coins used is amount + 1
        dp = [amount + 1] * (amount + 1)
        # base case -> takes 0 coins to get 0 money
        dp[0] = 0

        # iterate through every target amount
        for i in range(1, amount + 1):
            # check every coin
            for c in coins:
                if i - c >= 0:
                    # 1 (current coin) + cost of the remainder (a - c)
                    dp[i] = min(dp[i], 1 + dp[i - c])
        
        return dp[amount] if dp[amount] != amount + 1 else -1
