class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (helper(i, j, visited, board, word, 0)) {
                    return true;
                }
                }
            }
        }
        return false;
    }

    private boolean helper(int i, int j, boolean[][] visited, char[][] board, String word, int index) {
        if (index == word.length()) {
            return true;
        }
        
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || visited[i][j] || board[i][j] != word.charAt(index)) {
            return false;
        } 

        visited[i][j] = true;
        if (helper(i + 1, j, visited, board, word, index + 1) || helper(i - 1, j, visited, board, word, index + 1) || helper(i, j + 1, visited, board, word, index + 1) || helper(i, j - 1, visited, board, word, index + 1)) {
            return true;
        }
        
        visited[i][j] = false;
        return false;
    }
}