// Date: July 01, 2023
// Q30: Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the
// following rules:
// Each row must contain the digits 1-9 without repetition.
// Each column must contain the digits 1-9 without repetition.
// Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
// Note:
// A Sudoku board (partially filled) could be valid but is not necessarily solvable.
// Only the filled cells need to be validated according to the mentioned rules.

package Medium;

import java.util.HashSet;
import java.util.Set;

public class Q30_ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        // We will solve this problem by creating 3 HashSets:
        //
        Set<Character> rowSet;
        Set<Character> colSet;

        for (int i = 0; i < 9; i++) {
            rowSet = new HashSet<>();
            colSet = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                char r = board[i][j];
                char c = board[j][i];
                if (r != '.'){
                    if (rowSet.contains(r)){
                        return false;
                    } else {
                        rowSet.add(r);
                    }
                }
                if (c != '.'){
                    if (colSet.contains(c)){
                        return false;
                    } else {
                        colSet.add(c);
                    }
                }
            }
        }

        for (int i = 0; i < 9; i = i + 3) {
            for (int j = 0; j < 9; j = j + 3) {
                if (!checkBlock(i, j, board)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkBlock(int idxI, int idxJ, char[][] board) {
        Set<Character> blockSet = new HashSet<>();
        int rows = idxI + 3;
        int cols = idxJ + 3;

        for (int i = idxI; i < rows; i++) {

            for (int j = idxJ; j < cols; j++) {
                if (board[i][j] == '.') {
                    continue;
                }

                if (blockSet.contains(board[i][j])) {
                    return false;
                }
                blockSet.add(board[i][j]);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Q30_ValidSudoku obj1 = new Q30_ValidSudoku();
        char[][] Sudoku = {
                {5, 3, '.', '.', 7, '.', '.', '.', '.'},
                {6, '.', '.', 1, 9, 5, '.', '.', '.'},
                {'.', 9, 8, '.', '.', '.', '.', 6, '.'},
                {8, '.', '.', '.', 6, '.', '.', '.', 3},
                {4, '.', '.', 8, '.', 3, '.', '.', 1},
                {7, '.', '.', '.', 2, '.', '.', '.', 6},
                {'.', 6, '.', '.', '.', '.', 2, 8, '.'},
                {'.', '.', '.', 4, 1, 9, '.', '.', 5},
                {'.', '.', '.', '.', 8, '.', '.', 7, 9},
        };
        System.out.println(obj1.isValidSudoku(Sudoku));
    }
}
