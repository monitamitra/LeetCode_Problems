class Solution:
    def pacificAtlantic(self, heights: List[List[int]]) -> List[List[int]]:
        res = []
        m = len(heights)
        n = len(heights[0])
        pac, atl = set(), set()
        
        def helper(r, c, visit, prevHeight):
            if (r, c) in visit or not (0 <= r < m) or not (0 <= c < n) or heights[r][c] < prevHeight:
                return 
            
            visit.add((r, c))
            helper(r + 1, c, visit, heights[r][c])
            helper(r - 1, c, visit, heights[r][c])
            helper(r, c + 1, visit, heights[r][c])
            helper(r, c - 1, visit, heights[r][c])
            
        for i in range(n):
            helper(0, i, pac, heights[0][i])
            helper(m - 1, i, atl, heights[m - 1][i])

        for i in range(m):
            helper(i, 0, pac, heights[i][0])
            helper(i, n - 1, atl, heights[i][n - 1])

        for r in range(m):
            for c in range(n):
                if (r, c) in pac and (r, c) in atl:
                    res.append([r, c])
        
        return res
        