class Solution {
    public int countSubstrings(String s) {
        boolean[][] dp  = new boolean[s.length()][s.length()];
        int ans = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (i == j) {
                        // substring with 1 char is always palindrome
                        dp[i][j] = true;
                    } else if (j == i + 1) {
                        dp[i][j] = (s.charAt(i) == s.charAt(j));
                    } else {
                        dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]);
                    }
                    if (dp[i][j]) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
}