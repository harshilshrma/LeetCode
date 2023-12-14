// Date: 14 December 2023
// Given an m x n binary matrix mat, return the number of special positions in mat.
// A position (i, j) is called special if mat[i][j] == 1 and all other elements in row i and column j are 0
// (rows and columns are 0-indexed).

package Easy.Q31_to_;

import java.util.HashMap;

public class Q43_SpecialPositionsInABinaryMatrix {
    public int numSpecial(int[][] mat) {
        HashMap<Integer, Integer> mapR = new HashMap<>();
        HashMap<Integer, Integer> mapC = new HashMap<>();
        int count = 0;
        int res = 0;

        // Storing number of 1s in each row
        for (int i = 0; i < mat.length; i++) {
            count = 0;
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) count += 1;
            }
            mapR.put(i, count);
        }

        // Storing number of 1s in each column
        for (int i = 0; i < mat[0].length; i++) {
            count = 0;
            for (int j = 0; j < mat.length; j++) {
                if (mat[j][i] == 1) count += 1;
            }
            mapC.put(i, count);
        }

        // Iterating through the matrix to check for special positions
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1){
                    if(mapC.get(j) == 1 && mapR.get(i) == 1) res += 1;
                }
            }
        }
        return res;
    }

    // Main function for testing
    public static void main(String[] args) {
        Q43_SpecialPositionsInABinaryMatrix obj = new Q43_SpecialPositionsInABinaryMatrix();
        int[][] mat = {{1, 0, 0}, {0, 0, 1}, {1, 0, 0}};
        System.out.println(obj.numSpecial(mat));
    }
}
