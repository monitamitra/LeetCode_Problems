class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        res = 0
        m = len(grid)
        n = len(grid[0])
        q = deque()
        dirs = [[0, 1], [0, -1], [1, 0], [-1, 0]]
        fresh_cnt = 0

        for r in range(m):
            for c in range(n):
                if grid[r][c] == 2:
                    q.append((r, c))
                elif grid[r][c] == 1:
                    fresh_cnt += 1
        
        # no fresh oranges 
        if fresh_cnt == 0:
            return 0

        while q:
            res += 1
            for _ in range(len(q)):
                r, c = q.popleft()

                # visit neighbors if cell is rotten
                if grid[r][c] == 2:
                    for d in dirs:
                        nr, nc = r + d[0], c + d[1]
                        if 0 <= nr < m and 0 <= nc < n and grid[nr][nc] == 1:
                            grid[nr][nc] = 2
                            q.append((nr, nc))
                            fresh_cnt -= 1
            
            if fresh_cnt == 0:
                return res
        
        if fresh_cnt > 0:
            return -1
        
        return res
        