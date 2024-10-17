class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        return helper(dp, 0, 0);
    }

    private int helper(int[][] dp, int i, int j) {
        // out of bounds
        if (i >= dp.length || j >= dp[0].length) {
            return 0;
        }

        if (i == dp.length - 1 && j == dp[0].length - 1) {
            return 1;
        }

        // utilize calculated subproblem
        if (dp[i][j] > 0) {
            return dp[i][j];
        }

        return dp[i][j] = helper(dp, i, j + 1) + helper(dp, i + 1, j);
    }
}