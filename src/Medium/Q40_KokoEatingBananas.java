// Date: 12 December 2023
// Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas.
// The guards have gone and will come back in h hours. Koko can decide her bananas-per-hour eating speed of k.
// Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas,
// she eats all of them instead and will not eat any more bananas during this hour.
// Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
// Return the minimum integer k such that she can eat all the bananas within h hours.

package Medium;

public class Q40_KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {


        return 0;
    }

    public static void main(String[] args) {
        Q40_KokoEatingBananas obj = new Q40_KokoEatingBananas();
        int[] piles = {3,6,7,11};
        int h = 8;
        System.out.println(obj.minEatingSpeed(piles, h));
    }
}
