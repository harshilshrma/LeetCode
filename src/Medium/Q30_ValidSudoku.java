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
        // We will solve this problem by HashSets. Why HashSets? Because,
        // 1. HashSets do not support duplicate items. Thus, giving us the advantage to check for the duplicate
        // entries.
        // 2. In a HashSet, the elements are placed randomly and according to their Hash codes. For this problem,
        // we don't have to worry about the order because we just have to check for the duplicate entries.

        // We will create 3 Hashsets in this problem, each for checking every single row, column, and 3x3 block.
        for (int i = 0; i < 9; i++) {
            // Hashsets for checking each row and column
            // We re-initialise the sets above the second loop to create a new HashSet for every new row/column.
            Set<Character> rowSet = new HashSet<>();
            Set<Character> colSet = new HashSet<>();

            // Iterating through each entry:
            for (int j = 0; j < 9; j++) {
                char r = board[i][j];
                char c = board[j][i];  // Notice the change from [i][j] for row to [j][i] for column
                if (r != '.'){
                    // If the entry is already present in the row, we return false, else, we add that entry
                    if (rowSet.contains(r)){
                        return false;
                    } else {
                        rowSet.add(r);
                    }
                }
                if (c != '.'){
                    // If the entry is already present in the column, we return false, else, we add that entry
                    if (colSet.contains(c)){
                        return false;
                    } else {
                        colSet.add(c);
                    }
                }
            }
        }
        // By the end of this 'for' loop, all of our rows and columns will be checked for duplicates.

        // Now we will check for each 3x3 block, for this, we have created another function named 'checkBlock'.
        // Refer to that function first then come back to this part of the code.

        // We have 3 3x3 blocks in each row and each column, i.e., 9 3x3 blocks in total.
        for (int i = 0; i < 9; i = i + 3) {
            for (int j = 0; j < 9; j = j + 3) {
                // By these loops, we will provide the function 'checkBlock', the following arguments:
                // (0, 0, board), (0, 3, board) and (0, 6, board)
                // (3, 0, board), (3, 3, board) and (3, 6, board)
                // (6, 0, board), (6, 3, board) and (6, 6, board)
                // By these arguments, it will iterate through all the 9 3x3 blocks

                // If any one of the 3x3 block is invalid, we will return false
                if (!checkBlock(i, j, board)) {
                    return false;
                }
            }
        }

        // If all the rows, columns and 3x3 blocks are valid, we will return true
        return true;
    }

    // This function checks for duplicates in A SINGLE 3x3 block and is called in the 'isValidSudoku' Class.
    // We have arguments, idxI for iterating through the i/row part, and, idxJ for iterating through the j/column part.
    public boolean checkBlock(int idxI, int idxJ, char[][] board) {
        // Creating a HashSet for each 3x3 block
        Set<Character> blockSet = new HashSet<>();

        // So, now we will define the boundary till which we will iterate for each 3x3 block, i.e., 3 on each side
        // of a 3x3 block. Hence, +3 for rows, and, +3 for columns.
        // Therefore, we will initialise our limits as:
        int rows = idxI + 3;
        int cols = idxJ + 3;

        // Iterating through each 3x3 block
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

        // The function returns true if all the entries are unique
        return true;
    }

    // Main function for testing.
    public static void main(String[] args) {
        Q30_ValidSudoku obj1 = new Q30_ValidSudoku();
        char[][] sudoku = {
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
        System.out.println(obj1.isValidSudoku(sudoku));
    }
}
