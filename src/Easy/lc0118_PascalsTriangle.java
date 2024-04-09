// 9 April 2024
// Given an integer numRows, return the first numRows of Pascal's triangle.
//
//In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

package Easy;

import java.util.ArrayList;
import java.util.List;

public class lc0118_PascalsTriangle {

    // Method to calculate the value of n choose r (nCr)
    public static long ncr(int n, int r) {
        long res = 1;
        // Calculate n! / (r! * (n - r)!); 10c3 = (10 x 9 x 8)
        for (int i = 0; i < r; i++) {
            res = res * (n - i);
            res = res / (i + 1);
        }
        return res;
    }

    // Method to generate Pascal's Triangle using a brute-force approach
    public List<List<Integer>> generateBRUTE(int n) {
        List<List<Integer>> ans = new ArrayList<>();
        // Generate each row of Pascal's Triangle
        for (int row = 1; row <= n; row++) {
            List<Integer> temp = new ArrayList<>();

            // Calculate each value in the current row
            for (int col = 1; col <= row; col++) {
                temp.add((int) ncr(row - 1, col - 1)); // Add nCr value to the current row
            }

            ans.add(temp); // Add the row to the result
        }
        return ans;
    }

    // Method to generate an individual row of Pascal's Triangle
    public static List<Integer> genRow(int row) {
        long ans = 1;
        List<Integer> ansRow = new ArrayList<>();
        ansRow.add(1); // First element of each row is always 1

        // Calculate the rest of the elements in the row
        for (int col = 1; col < row; col++) {
            ans = ans * (row - col); // Multiply by (row - col)
            ans = ans / col; // Divide by col
            ansRow.add((int) ans); // Add the calculated value to the row
        }
        return ansRow;
    }

    // Method to generate Pascal's Triangle using an optimal approach
    public List<List<Integer>> generateOPTIMAL(int n) {
        List<List<Integer>> ans = new ArrayList<>();
        // Generate each row of Pascal's Triangle
        for (int i = 1; i <= n; i++) {
            ans.add(genRow(i)); // Add the generated row to the result
        }
        return ans;
    }

    // Main function for testing
    public static void main(String[] args) {
        lc0118_PascalsTriangle obj = new lc0118_PascalsTriangle();
        int numRows = 5;
        System.out.println(obj.generateBRUTE(numRows));
    }
}
