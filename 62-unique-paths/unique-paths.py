class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        dp = [[0] * n for _ in range(m)]
        # base case -> don't have top/left neighbor
        for i in range(m):
            dp[i][0] = 1
        for i in range(n):
            dp[0][i] = 1

        # 0 is handled in base cases
        for i in range(1, m):
            for j in range(1, n):
                dp[i][j] = dp[i-1][j] + dp[i][j-1]

        return dp[m - 1][n - 1]


# Only store one row (the "previous" row)
    # Initialize with 1s because the top row is always 1
   #  row = [1] * n
    
    # Iterate through the grid rows (skipping the first one)
    # for i in range(1, m):
    #     for j in range(1, n):
            # The Magic:
            # row[j] starts as the value from the "top" (old value)
            # row[j-1] is the value from the "left" (newly updated value)
    #         row[j] = row[j] + row[j-1]
            
    # return row[-1]
