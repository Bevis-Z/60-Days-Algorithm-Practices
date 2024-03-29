class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int res = Integer.MAX_VALUE;
        Integer memo[][] = new Integer[matrix.length][matrix[0].length];

        for(int startCol = 0; startCol < matrix.length; startCol++) {
            res = Math.min(res, findMinFallingPathSum(matrix, 0, startCol, memo));
        }
        return res;
    }

    public int findMinFallingPathSum(int[][] matrix, int row, int col, Integer[][] memo) {
        if (col < 0 || row == matrix.length) {
            return Integer.MAX_VALUE;
        }
        if (row == matrix.length - 1) {
            return matrix[row][col];
        }
        if (memo[row][col] != null) {
            return memo[row][col];
        }

        int left = findMinFallingPathSum(matrix, row + 1, col, memo);
        int middle = findMinFallingPathSum(matrix, row + 1, col + 1, memo);
        int right = findMinFallingPathSum(matrix, row, col + 1, memo);

        memo[row][col] = Math.min(left, Math.min(middle, right)) + matrix[row][col];
        return memo[row][col];
    }
}