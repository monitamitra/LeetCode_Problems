class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] visited = new int[m][n];
        int num_islands = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && visited[i][j] == 0) {
                    num_islands++;
                    dfs(grid, i, j, visited);
                }
            }
        }
        return num_islands;
    }

    private void dfs(char[][] grid, int i, int j, int[][] visited) {
        // index exceeds bounds or already visited 
        if (i >= grid.length || j >= grid[0].length || i < 0 || j < 0
        || visited[i][j] == 1 || grid[i][j] == '0') {
            return;
        }
        visited[i][j] = 1;

        dfs(grid, i + 1, j, visited); 
        dfs(grid, i - 1, j, visited);
        dfs(grid, i, j + 1, visited); 
        dfs(grid, i, j - 1, visited);
    }
}