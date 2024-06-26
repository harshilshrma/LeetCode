// 4 May 2024
// You are given an array people where people[i] is the weight of the ith person, and an infinite number of boats
// where each boat can carry a maximum weight of limit. Each boat carries at most two people at the same time,
// provided the sum of the weight of those people is at most limit.
//
//Return the minimum number of boats to carry every given person.

package Medium;

import java.util.Arrays;

public class lc0881_BoatsToSavePeople {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int low = 0, high = people.length - 1, boats = 0;
        while (low <= high) {
            if (people[low] + people[high] <= limit) {
                low++;
                high--;
                boats++;
            } else {
                high--;
                boats++;
            }
        }
        return boats;
    }

    // Main function for testing
    public static void main(String[] args) {
        lc0881_BoatsToSavePeople obj = new lc0881_BoatsToSavePeople();
        int[] people =
                {3, 2, 2, 1};
        int limit = 3;
        System.out.println(obj.numRescueBoats(people, limit));
    }

}
