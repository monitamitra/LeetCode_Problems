class Solution:
    def minFallingPathSum(self, grid: List[List[int]]) -> int:
        if len(grid) == 1:
            return grid[0][0]
        
        dp = [row[:] for row in grid]

        for i in range(1, len(grid)):
            for j in range(0, len(grid)):
                min_val = float("inf")
                for k in range(0, len(grid)):
                    if k != j:
                        min_val = min(min_val, dp[i - 1][k])
                    dp[i][j] = grid[i][j] + min_val
        return min(dp[-1])