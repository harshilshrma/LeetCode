// Date: 12 December 2023
// Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas.
// The guards have gone and will come back in h hours. Koko can decide her bananas-per-hour eating speed of k.
// Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas,
// she eats all of them instead and will not eat any more bananas during this hour.
// Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
// Return the minimum integer k such that she can eat all the bananas within h hours.

package Medium;
import java.util.Arrays;

public class Q40_KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int l = 1;
        int r = piles[piles.length - 1];
        int res = r; // not initialising it to 0 but to r(max) because this is the max which our
        // answer can be and we have to find the minimum

        // Applying the binary search
        while (l <= r) {
            int k = (l + r) / 2;
            int hours = 0;
            for (int i : piles) {
                // We have to round up, so we will use Math.ceil
                // Ex: Ceil(7.0 / 3.0) = Ceil(2.333) = 3.0 -> 3 in int
                hours += Math.ceil((double) i / k);
            }

            if (hours <= h) { // Meaning Koko ate faster, she could have gone slower
                res = Math.min(res, k);
                r = k - 1;
            } else {
                l = k + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Q40_KokoEatingBananas obj = new Q40_KokoEatingBananas();
        int[] piles = {30, 11, 23, 4, 20};
        int h = 6;
        System.out.println(obj.minEatingSpeed(piles, h));
    }
}
