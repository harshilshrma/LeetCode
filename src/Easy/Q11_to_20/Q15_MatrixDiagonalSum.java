// Date: 04 March 2023
// Q15: Given a square matrix mat, return the sum of the matrix diagonals.
// Only include the sum of all the elements on the primary diagonal and all the elements on the
// secondary diagonal that are not part of the primary diagonal.

// My Solution: 1ms
package Easy.Q11_to_20;
public class Q15_MatrixDiagonalSum {
    public int diagonalSum(int[][] mat) {
        int sum=0;
        //For Matrices with single entry
        if (mat.length == 1) return mat[0][0];

        for (int i=0; i<mat.length; i++){
            for(int j=0; j<mat.length; j++){

                //For Matrices with Odd No. of Rows & Columns
                if(mat.length%2 != 0){
                    if(i==j) sum = sum + mat[i][j]; //Primary Diagonal
                    if((i+j)==(mat.length-1) && i!=j) sum = sum + mat[i][j];
                    // In Secondary Diagonal, (i!=j) condition removes the common
                    // element in both the diagonals i.e., the center element.
                }

                //For Matrices with Even No. of Rows & Columns
                if(mat.length%2 == 0){
                    //Primary Diagonal
                    if(i==j) sum = sum + mat[i][j];
                    //Secondary Diagonal
                    if((i+j)==(mat.length-1)) sum = sum + mat[i][j];
                }
            }
        }
        return sum;
    }
}

// Better Solution: 0ms
class dfghj {
    public int diagonalSum(int[][] mat) {
        int ans = 0;
        for(int i=0; i<mat.length; i++){
            ans += mat[i][i];
            if(mat.length-1-i != i){
                ans += mat[i][mat.length-1-i];
            }
        }
        return ans;
    }
}
