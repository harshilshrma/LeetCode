// Date: 24 January 2024
// Given a binary tree where node values are digits from 1 to 9. A path in the binary tree is said to be
// pseudo-palindromic if at least one permutation of the node values in the path is a palindrome.
//Return the number of pseudo-palindromic paths going from the root node to leaf nodes.

package Medium;

public class lc1457_PseudoPalindromicPathsInABinaryTree {
    public int result = 0;

    public static class TreeNode {
        int val;
        TreeNode right;
        TreeNode left;
        TreeNode(int val, TreeNode right, TreeNode left) {
            this.val = val;
            this.right = right;
            this.left = left;
        }
    }

    public void solve(TreeNode root, int[] count) {
        if (root == null) {
            return;
        }

        // Increment count for the current value in the path
        count[root.val]++;

        // Check if it's a leaf node
        if (root.left == null && root.right == null) {
            int oddFreq = 0;

            // Count the frequencies of odd occurrences
            for (int i = 1; i <= 9; i++) {
                if (count[i] % 2 != 0) {
                    oddFreq++;
                }
            }

            // If there is at most one odd frequency, it's a pseudo-palindromic path
            if (oddFreq <= 1) {
                result += 1;
            }
        }

        // Recursively explore left and right subtrees
        solve(root.left, count);
        solve(root.right, count);

        // Decrement count for backtracking
        count[root.val]--;
    }

    public int pseudoPalindromicPaths(TreeNode root) {
        int[] count = new int[10];

        // Invoke the recursive function starting from the root
        solve(root, count);

        // Return the result containing the count of pseudo-palindromic paths
        return result;
    }
}
