// 3 April 2024
// Given an m x n grid of characters board and a string word, return true if word exists in the grid.
//
//The word can be constructed from letters of sequentially adjacent cells, where adjacent cells
// are horizontally or vertically neighboring. The same letter cell may not be used more than once.

package Medium;

public class lc0079_WordSearch {

    private int m, n, l;
    private int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private boolean find(char[][] board, int i, int j, String word, int idx) {
        if (idx == word.length())
            return true;

        if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] != word.charAt(idx))
            return false;

        char temp = board[i][j];
        board[i][j] = '$';

        for (int[] dir : directions) {
            int i_ = i + dir[0];
            int j_ = j + dir[1];

            if (find(board, i_, j_, word, idx + 1))
                return true;
        }

        board[i][j] = temp;
        return false;
    }


    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0) && find(board, i, j, word, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    // Main function for testing
    public static void main(String[] args) {
        lc0079_WordSearch obj = new lc0079_WordSearch();
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        System.out.println(obj.exist(board, word));
    }
}
