// 11-05-2024 - 08:51 pm
// There are n workers. You are given two integer arrays quality and wage where quality[i]
// is the quality of the ith worker and wage[i] is the minimum wage expectation for the ith worker.
//
//We want to hire exactly k workers to form a paid group. To hire a group of k workers,
// we must pay them according to the following rules:
//
//Every worker in the paid group must be paid at least their minimum wage expectation.
//In the group, each worker's pay must be directly proportional to their quality. This means if a worker’s
// quality is double that of another worker in the group, then they must be paid twice as much as the other worker.
//Given the integer k, return the least amount of money needed to form a paid group satisfying the above
// conditions. Answers within 10-5 of the actual answer will be accepted.

package Hard;

import java.util.*;

public class lc0857_MinCostToHireKWorkers {
    // Function
    public double mincostToHireWorkersBRUTE(int[] quality, int[] wage, int k) {
        int n = wage.length;
        double result = Double.MAX_VALUE;

        for (int manager = 0; manager < n; manager++) {
            double managerRatio = (double) wage[manager] / quality[manager];
            double[] group = new double[n];
            int groupSize = 0;

            for (int worker = 0; worker < n; worker++) {
                double workerWage = managerRatio * quality[worker];
                if (workerWage >= wage[worker]) {
                    group[groupSize++] = workerWage;
                }
            }


            if (groupSize < k) {
                continue;
            }

            PriorityQueue<Double> pq = new PriorityQueue<>(groupSize, Collections.reverseOrder());
            double sum = 0;

            for (int i = 0; i < groupSize; i++) {
                sum += group[i];
                pq.offer(group[i]);

                if (pq.size() > k) {
                    sum -= pq.poll();
                }
            }

            result = Math.min(result, sum);
        }
        return result;
    }

    public double mincostToHireWorkersBETTER(int[] quality, int[] wage, int k) {
        int n = quality.length;
        double result = Double.MAX_VALUE;

        // calculating wage to quality ratio for all
        double[][] workerRatio = new double[n][2];
        for (int worker = 0; worker < n; worker++) {
            workerRatio[worker][0] = (double) wage[worker] / quality[worker];
            workerRatio[worker][1] = quality[worker];
        }

        // sorting based on wage to quality ratio
        Arrays.sort(workerRatio, Comparator.comparingDouble(a -> a[0]));

        for (int manager = k - 1; manager < n; manager++) {
             double managerRatio = workerRatio[manager][0];

            // Create a group of workers whose wage-to-quality ratio is less than or equal to the current
            // manager's ratio
            double[] group = new double[manager + 1];

            for (int worker = 0; worker <= manager; worker++) {
                double workerWage = workerRatio[worker][1] * managerRatio;
                group[worker] = workerWage;
            }

            PriorityQueue<Double> pq = new PriorityQueue<>(group.length, Collections.reverseOrder());
            double sum = 0;

            // Calculate the sum of wages for the selected group of workers
            for (double i : group) {
                sum += i;
                pq.offer(i);

                if (pq.size() > k) {
                    sum -= pq.poll();
                }
            }

            result = Math.min(result, sum);
        }

        return result;
    }

    public double mincostToHireWorkersOPTIMAL(int[] quality, int[] wage, int k) {
        int n = quality.length;

        // calculating wage to quality ratio for all
        double[][] workerRatio = new double[n][2];
        for (int worker = 0; worker < n; worker++) {
            workerRatio[worker][0] = (double) wage[worker] / quality[worker];
            workerRatio[worker][1] = quality[worker];
        }

        // sorting based on wage to quality ratio
        Arrays.sort(workerRatio, Comparator.comparingDouble(a -> a[0]));

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        double sumQuality = 0;

        for (int i = 0; i < k; i++) {
            pq.offer((int) workerRatio[i][1]); // Push all qualities in max-heap
            sumQuality += workerRatio[i][1]; // Find sum of qualities
        }

        double managerRatio = workerRatio[k - 1][0];
        double result = managerRatio * sumQuality;

        for (int manager = k; manager < n; manager++) {
            managerRatio = workerRatio[manager][0];

            pq.offer((int) workerRatio[manager][1]);
            sumQuality += workerRatio[manager][1];

            if (pq.size() > k) {
                sumQuality -= pq.poll();
            }

            result = Math.min(result, managerRatio * sumQuality);
        }

        return result;
    }


    // Main function for testing
    public static void main(String[] args) {
        lc0857_MinCostToHireKWorkers obj = new lc0857_MinCostToHireKWorkers();
        int[] quality = {10, 20, 5}, wage = {70, 50, 30};
        int k = 2;
        System.out.println(obj.mincostToHireWorkersBRUTE(quality, wage, k));
        System.out.println(obj.mincostToHireWorkersBETTER(quality, wage, k));
        System.out.println(obj.mincostToHireWorkersOPTIMAL(quality, wage, k));
    }
}



