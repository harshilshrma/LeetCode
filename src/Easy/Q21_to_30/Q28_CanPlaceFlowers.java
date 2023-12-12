// Date: June 22, 2023
// Q28: You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers
// cannot be planted in adjacent plots.
// Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an
// integer n, return true if n new flowers can be planted in the flowerbed without violating the
// no-adjacent-flowers rule and false otherwise.

package Easy.Q21_to_30;

public class Q28_CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        // We create 2 boolean variables to check for left and right sides of an element
        boolean right, left;

        // For the condition where no flower is to be placed:
        if (n == 0) return true;

        for (int i = 0; i < flowerbed.length; i++) {
            // Initializing the default variable values to false
            right = false;
            left = false;

            // We need 3 zeroes in a line to place a flower, so we will check for each zero's right and left.
            // If the zero which we examine, turns out to be surrounded by zeroes on both the sides, we can place
            // one flower and thus will reduce "n" by 1.
            if (flowerbed[i] == 0) {
                // Checking for the left side or the first element:
                if (i == 0 || flowerbed[i-1] == 0) left = true;

                // Checking for the right side or the last element:
                if (i == flowerbed.length - 1 || flowerbed[i+1] == 0) right = true;

                // If both the variables are "true" that means, we have found a zero surrounded by 2 other zeroes.
                // For Ex: [0, 0, 0]
                if (left && right) {
                    // We reduce 'n' by 1, because one flower will be placed in the place of this middle zero here.
                    n = n - 1;

                    // Checking if all the flowers have been placed or not, if they are placed, 'n' will be zero and
                    // the loop will break to the return statement which is a "true" value (n == 0)
                    if (n == 0) break;

                    // Replacing the middle zero with 1
                    flowerbed[i] = 1;

                    // If all the flowers will not be placed, then n != 0 and the output will be "false" for
                    // the return statement [(n == 0)]
                }
            }
        }
        return (n == 0);
    }
}
