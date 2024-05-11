// 11 may 2024
// You are given a sorted integer array arr containing 1 and prime numbers,
// where all the integers of arr are unique. You are also given an integer k.
//
//For every i and j where 0 <= i < j < arr.length, we consider the fraction arr[i] / arr[j].
//
//Return the kth smallest fraction considered. Return your answer as an array of integers of
// size 2, where answer[0] == arr[i] and answer[1] == arr[j].

package Medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class lc0786_KthSmallestPrimeFraction {
    public int[] kthSmallestPrimeFraction1(int[] arr, int k) {
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                double div = (double) arr[i] / arr[j];

                pq.offer(new double[]{div, (double) arr[i], (double) arr[j]});
                if (pq.size() > k) {
                    pq.poll();
                }

            }
        }

        double[] temp = pq.peek();

        return new int[]{(int) temp[1], (int) temp[2]};
    }

    public int[] kthSmallestPrimeFraction2(int[] arr, int k) {
        int n = arr.length;
        PriorityQueue<double[]> pq = new PriorityQueue<>(Comparator.comparingDouble(a -> a[0]));

        for (int i = 0; i < n; i++) {
            pq.offer(new double[]{(double) arr[i] / arr[n - 1], (double) i, (double) (n - 1)});
        }

        int smallest = 1;

        while (smallest < k) {
            double[] vec = pq.poll();

            int i = (int) vec[1]; // idx
            int j = (int) vec[2] - 1; // idx

            pq.offer(new double[]{1.0 * arr[i] / arr[j], (double) i, (double) j});
            smallest++;
        }

        double[] vec = pq.peek();
        int i = (int) vec[1];
        int j = (int) vec[2];
        return new int[]{arr[i], arr[j]};
    }

    // Main function for testing
    public static void main(String[] args) {
        lc0786_KthSmallestPrimeFraction obj = new lc0786_KthSmallestPrimeFraction();
        int[] arr = {1, 2, 3, 5};
        int k = 3;
        System.out.println(Arrays.toString(obj.kthSmallestPrimeFraction1(arr, k)));
        System.out.println(Arrays.toString(obj.kthSmallestPrimeFraction2(arr, k)));
    }
}
