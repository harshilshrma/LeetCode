// Date: 11 January 2024
// Given the root of a binary tree, find the maximum value v for which there exist different nodes a and b
// where v = |a.val - b.val| and a is an ancestor of b.
// A node a is an ancestor of b if either: any child of a is equal to b or any child of a is an ancestor of b

package Medium;

public class lc1026_MaximumDifferenceBetweenNodeAndAncestor {
    // Definition for a binary tree node.
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

    // Tree Builder class
    public static TreeNode createTree (Integer[] values) {
        if (values == null || values.length == 0 || values[0] == null) {
            return null;
        }

        TreeNode[] nodes = new TreeNode[values.length];
        for (int i = 0; i < values.length; i++) {
            if (values[i] != null) {
                nodes[i] = new TreeNode(values[i], null, null);
            }
        }

        for (int i = 0; i < values.length; i++) {
            if (nodes[i] != null) {
                int leftIdx = 2 * i + 1;
                int rightIdx = 2 * i + 2;
                nodes[i].left = (leftIdx < values.length) ? nodes[leftIdx] : null;
                nodes[i].right = (rightIdx < values.length) ? nodes[rightIdx] : null;
            }
        }
        return nodes[0];
    }

// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    // Brute Force Approach

    // Time Complexity: 115 ms
    // Space Complexity: 41.29 MB

    private int maxDiff;

    // Utility function to find the maximum difference between root and its descendants
    public void findMaxDiffUtil(TreeNode root, TreeNode child) {
        if (root == null || child == null) {
            return;
        }
        // Update maxDiff with the absolute difference between root and child values
        maxDiff = Math.max(maxDiff, Math.abs(root.val - child.val));

        // Recursively traverse left and right children of root
        findMaxDiffUtil(root, child.left);
        findMaxDiffUtil(root, child.right);
    }

    // Main function to find the maximum difference for each node in the tree
    public void findMaxDiff(TreeNode root) {
        if (root == null) return;

        // Find maximum difference with left and right children of root
        findMaxDiffUtil(root, root.left);
        findMaxDiffUtil(root, root.right);

        // Recursively traverse right and left subtrees
        findMaxDiff(root.right);
        findMaxDiff(root.left);
    }

    // Function to calculate the maximum ancestor difference using brute force
    public int maxAncestorDiffByBruteForce(TreeNode root) {
        maxDiff = -1; // Initialize maxDiff to an invalid value
        findMaxDiff(root); // Call the function to calculate maximum differences
        return maxDiff; // Return the result
    }
// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    // Optimal Approach

    // Time Complexity: 0ms
    // Space Complexity: 41.88 MB

    // Recursive function to find the maximum ancestor difference
    public int findMax(TreeNode root, int min, int max) {
        if (root == null) {
            return Math.abs(min - max); // Return the absolute difference between min and max
        }

        // Update min and max based on the current root value
        min = Math.min(min, root.val);
        max = Math.max(max, root.val);

        // Recursively find maximum differences in left and right subtrees
        int l = findMax(root.left, min, max);
        int r = findMax(root.right, min, max);

        // Return the maximum of left and right subtree differences
        return Math.max(l, r);
    }

    // Main function to calculate the maximum ancestor difference using optimal approach
    public int maxAncestorDiffByOptimalApproach(TreeNode root) {
        // Call the recursive function with initial min and max values
        return findMax(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    // Main function for testing
    public static void main(String[] args) {
        lc1026_MaximumDifferenceBetweenNodeAndAncestor obj = new lc1026_MaximumDifferenceBetweenNodeAndAncestor();
        Integer[] values = {8,3,10,1,6,null,14,null,null,4,7,13};
        TreeNode root = createTree(values);
        System.out.println(obj.maxAncestorDiffByBruteForce(root));
        System.out.println(obj.maxAncestorDiffByOptimalApproach(root));
    }
}
