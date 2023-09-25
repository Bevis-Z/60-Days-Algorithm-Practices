class Solution {
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] chessboard = new char[n][n];
        for (char[] row : chessboard) {
            Arrays.fill(row, '.');
        }
        backtracking(0, n, chessboard);
        return res;
    }

    void backtracking(int row, int n, char[][] chessboard) {
        if (row == n) {
            res.add(charToString(chessboard));
            return;
        }

        for (int col=0; col<n; ++col) {
            if (isValid(row, col, n, chessboard)) {
                chessboard[row][col] = 'Q';
                backtracking(row+1, n, chessboard);
                chessboard[row][col] = '.';
            }
        }
    }

    List<String> charToString(char[][] chessboard) {
        List<String> list = new ArrayList<>();
        for (char[] row : chessboard) {
            list.add(new String(row));
        }
        return list;
    }

    public boolean isValid(int row, int col, int n, char[][] chessboard) {
        // 检查列
        for (int i=0; i<row; ++i) { // 相当于剪枝
            if (chessboard[i][col] == 'Q') {
                return false;
            }
        }

        // 检查45度对角线
        for (int i=row-1, j=col-1; i>=0 && j>=0; i--, j--) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }

        // 检查135度对角线
        for (int i=row-1, j=col+1; i>=0 && j<=n-1; i--, j++) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
}