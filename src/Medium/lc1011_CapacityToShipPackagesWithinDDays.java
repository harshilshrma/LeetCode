// 15-05-2024 - 03:49 pm
// A conveyor belt has packages that must be shipped from one port to another within days days.
//
//The ith package on the conveyor belt has a weight of weights[i]. Each day, we load the ship with
// packages on the conveyor belt (in the order given by weights). We may not load more weight than the
// maximum weight capacity of the ship.
//
//Return the least weight capacity of the ship that will result in all the packages on the conveyor
// belt being shipped within days days.

package Medium;

public class lc1011_CapacityToShipPackagesWithinDDays {
    // Functions
    public static int daysRequired(int[] weights, int mid) {
        int counter = 0, requiredDays = 1;
        for (int i = 0; i < weights.length; i++) {
            if (counter + weights[i] > mid) {
                requiredDays++;
                counter = weights[i];
            } else {
                counter += weights[i];
            }
        }
        return requiredDays;
    }

    public static int totalSumCounter(int[] weights) {
        int sum = 0;
        for (int weight : weights) {
            sum += weight;
        }
        return sum;
    }

    public int shipWithinDays(int[] weights, int days) {
        int ans = 0, maxi = 0;
        for (int i : weights) {
            maxi = Math.max(maxi, i);
        }

        int low = maxi, high = totalSumCounter(weights);
        if (days == 1) return high;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (daysRequired(weights, mid) <= days) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    // Main function for testing
    public static void main(String[] args) {
        lc1011_CapacityToShipPackagesWithinDDays obj = new lc1011_CapacityToShipPackagesWithinDDays();
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(obj.shipWithinDays(weights, 5));
    }
}



