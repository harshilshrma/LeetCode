// 14-05-2024 - 02:15 pm
// You are given an integer array bloomDay, an integer m and an integer k.
//
//You want to make m bouquets. To make a bouquet, you need to use k adjacent flowers from the garden.
//
//The garden consists of n flowers, the ith flower will bloom in the bloomDay[i] and then can be used in
// exactly one bouquet.
//
//Return the minimum number of days you need to wait to be able to make m bouquets from the garden. If it
// is impossible to make m bouquets return -1.

package Medium;

public class lc1482_MinNumOfDaysToMakemBouquets {
    // Functions

    public static boolean possibleOrNot(int[] bloomDay, int day, int m, int k) {
        int cnt = 0, bouq = 0;
        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= day) {
                cnt++;
            } else {
                bouq += (cnt / k);
                cnt = 0;
            }
        }
        bouq += (cnt / k);

        return bouq >= m;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if (n < m * k) return -1;
        int ans = 0, low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            low = Math.min(low, bloomDay[i]);
            high = Math.max(high, bloomDay[i]);
        }

        while (low <= high) {
            int mid = (low + high) / 2;

            if (possibleOrNot(bloomDay, mid, m, k)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }

        return ans == 0 ? -1 : ans;
    }


    // Main function for testing
    public static void main(String[] args) {
        lc1482_MinNumOfDaysToMakemBouquets obj = new lc1482_MinNumOfDaysToMakemBouquets();
        int[] bloomDay = {1,10,3,10,2};
        int m = 2, k = 2;
        System.out.println(obj.minDays(bloomDay, m, k));
    }
}



