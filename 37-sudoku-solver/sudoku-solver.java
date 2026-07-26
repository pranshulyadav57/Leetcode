class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    boolean solve(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char ch = '1'; ch <= '9'; ch++) {
                        if (check(i, j, board, ch)) {
                            board[i][j] = ch;
                            if (solve(board))
                                return true;
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    boolean check(int r, int c, char[][] board, char ch) {
        for (int i = 0; i < 9; i++) {
            if (board[i][c] == ch)
                return false;
        }
        for (int j = 0; j < 9; j++) {
            if (board[r][j] == ch)
                return false;
        }
        int sr = 3 * (r / 3);
        int sc = 3 * (c / 3);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[sr + i][sc + j] == ch)
                    return false;
            }
        }
        return true;
    }
}