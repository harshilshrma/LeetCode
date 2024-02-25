// Date:25 February 2024
// You are given a 0-indexed integer array nums, and you are allowed to traverse between its indices.
// You can traverse between index i and index j, i != j, if and only if gcd(nums[i], nums[j]) > 1, where gcd
// is the greatest common divisor.
//
//Your task is to determine if for every pair of indices i and j in nums, where i < j, there exists a sequence
// of traversals that can take us from i to j.
//
//Return true if it is possible to traverse between all such pairs of indices, or false otherwise.

package Hard;

import java.util.Arrays;

public class lc2709_GreatestCommonDivisorTraversal {

    class DSU {
        private int[] parent;
        private int[] size;
        private int numberOfComponents;

        // Constructor to initialize the DSU with n components
        public DSU(int n) {
            parent = new int[n];
            size = new int[n];
            numberOfComponents = n;

            // Initially, each element is its own parent and has a size of 1
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        // Find operation with path compression to find the root of the component containing x
        public int find(int x) {
            if (x == parent[x])
                return x;

            // Path compression: Set the parent of x to the root of its component
            return parent[x] = find(parent[x]);
        }

        // Union operation to merge the components containing x and y
        public void union(int x, int y) {
            int xParent = find(x);
            int yParent = find(y);

            // If x and y are already in the same component, do nothing
            if (xParent == yParent)
                return;

            // Merge smaller component into the larger one to maintain balance
            if (size[xParent] > size[yParent]) {
                parent[yParent] = xParent;
                size[xParent] += size[yParent];
            } else if (size[xParent] < size[yParent]) {
                parent[xParent] = yParent;
                size[yParent] += size[xParent];
            } else {
                parent[xParent] = yParent;
                size[yParent] += size[xParent];
            }

            // Decrement the number of components after each union operation
            numberOfComponents -= 1;
        }

        // Method to get the size of the largest component
        public int maxSize() {
            return numberOfComponents;
        }
    }

    public boolean canTraverseAllPairs(int[] nums) {
        int n = nums.length;
        // Initialize Disjoint Set Union (DSU)
        DSU dsu = new DSU(n);

        // Find the maximum value in nums
        int m = Arrays.stream(nums).max().orElse(0);
        // Array to store the index of the first occurrence of each prime factor in nums
        int[] first = new int[m + 1];
        Arrays.fill(first, -1);

        // Iterate through each number in nums
        for (int i = 0; i < n; ++i) {
            // Factorize the current number
            for (int prime = 2; prime * prime <= nums[i]; ++prime) {
                // If prime is a factor of nums[i], union the indices of the current number and the first occurrence of prime
                if (nums[i] % prime != 0)
                    continue;

                if (first[prime] != -1)
                    dsu.union(first[prime], i);
                else
                    first[prime] = i;

                // Remove all occurrences of prime from nums[i]
                while (nums[i] % prime == 0)
                    nums[i] /= prime;
            }

            // If there's a remaining prime factor greater than 1, union its index with the current number's index
            if (nums[i] > 1) {
                if (first[nums[i]] != -1)
                    dsu.union(first[nums[i]], i);
                else
                    first[nums[i]] = i;
            }
        }

        // Check if all elements are in the same component
        return dsu.maxSize() == 1;
    }

    // Main function for testing
    public static void main(String[] args) {
        lc2709_GreatestCommonDivisorTraversal obj = new lc2709_GreatestCommonDivisorTraversal();
        int[] nums = {2, 3, 6};
        System.out.println(obj.canTraverseAllPairs(nums));
    }
}
