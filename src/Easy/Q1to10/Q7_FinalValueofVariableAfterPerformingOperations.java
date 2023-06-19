// Date: 01 March 2023
// Q7: There is a programming language with only four operations and one variable X:
// ++X and X++ increments the value of the variable X by 1.
// --X and X-- decrements the value of the variable X by 1.
// Initially, the value of X is 0. Given an array of strings operations containing a list of operations,
// return the final value of X after performing all the operations.

package Easy.Q1to10;
public class Q7_FinalValueofVariableAfterPerformingOperations {
    public int finalValueAfterOperations(String[] operations) {
        int total=0;  //Initializing a variable with value=0
        for (String s: operations){
            //Now, since in all the 4 operations (X++, ++X, --X, X--),
            //The second character [charAt(1)] will always be the operation that needs to be performed.
            //Ex:
            //   For ++X --> charAt(0)= +, charAt(1)= +, charAt(2)= X
            //   For X++ --> charAt(0)= X, charAt(1)= +, charAt(2)= +
            //   For X-- --> charAt(0)= X, charAt(1)= -, charAt(2)= -
            //   For --X --> charAt(0)= -, charAt(1)= -, charAt(2)= X
            //Hence, we can see that charAt(1) will always display the operation to be performed.
            if(s.charAt(1) == '+') total++;
            else total--;
        }
        return total;
    }
}

