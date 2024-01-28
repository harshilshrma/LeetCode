// Date: 28 January 2024
// Given a matrix and a target, return the number of non-empty submatrices that sum to target.
//A submatrix x1, y1, x2, y2 is the set of all cells matrix[x][y] with x1 <= x <= x2 and y1 <= y <= y2.
//Two submatrices (x1, y1, x2, y2) and (x1', y1', x2', y2') are different if they have some coordinate that
// is different: for example, if x1 != x1'.

package Hard;

import java.util.HashMap;

public class lc1074_NoOfSubmatricesThatSumToTarget {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        // Compute row-wise cumulative sums
        for (int row = 0; row < rows; row++) {
            for (int col = 1; col < cols; col++) {
                matrix[row][col] += matrix[row][col - 1];
            }
        }

        int result = 0;

        // Iterate through all possible submatrices
        for (int startCol = 0; startCol < cols; startCol++) {
            for (int endCol = startCol; endCol < cols; endCol++) {

                // HashMap to store cumulative sums and their frequencies
                HashMap<Integer, Integer> mp = new HashMap<>();
                mp.put(0, 1);
                int cumSum = 0;

                // Iterate through rows to calculate cumulative sums
                for (int row = 0; row < rows; row++) {
                    cumSum += matrix[row][endCol] - (startCol > 0 ? matrix[row][startCol - 1] : 0);

                    // Check if the complement of the current cumulative sum exists in the HashMap
                    if (mp.containsKey(cumSum - target)) {
                        // Increment the result by the frequency of the complement
                        result += mp.get(cumSum - target);
                    }

                    // Update the HashMap with the current cumulative sum and its frequency
                    mp.put(cumSum, mp.getOrDefault(cumSum, 0) + 1);
                }
            }
        }

        // Return the final result
        return result;
    }


    // Main function for testing
    public static void main(String[] args) {
        lc1074_NoOfSubmatricesThatSumToTarget obj = new lc1074_NoOfSubmatricesThatSumToTarget();
        int[][] matrix = {{0,1,0},{1,1,1},{0,1,0}};
        int target = 0;
        System.out.println(obj.numSubmatrixSumTarget(matrix, target));
    }
}
