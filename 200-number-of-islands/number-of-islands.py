class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        # island -> 1's surrounded by 0's
        res = 0
        m = len(grid)
        n = len(grid[0])

        def helper(r, c):
            if not (0 <= r < m) or not (0 <= c < n) or grid[r][c] == "0":
                return 

            grid[r][c] = "0"

            helper(r - 1, c)
            helper(r + 1, c)
            helper(r, c - 1)
            helper(r, c + 1)

        for r in range(m):
            for c in range(n):
                if grid[r][c] == "1":
                    res += 1
                    # mark island group (all reachable 1's) as visited
                    helper(r, c)

        return res