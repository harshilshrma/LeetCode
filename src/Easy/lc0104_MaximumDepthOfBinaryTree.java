// Date: 12 January 2024
// Given the root of a binary tree, return its maximum depth.
//A binary tree's maximum depth is the number of nodes along the longest path from the root
// node down to the farthest leaf node.

package Easy;

public class lc0104_MaximumDepthOfBinaryTree {
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

    // Function to calculate the maximum depth of a binary tree
    public int maxDepth(TreeNode root) {
        // Base case: If the root is null, the depth is 0
        if (root == null) {
            return 0;
        }

        // Recursive calculation of the maximum depth
        // Return 1 (current level) plus the maximum depth of the left or right subtree
        return 1 + Math.max((maxDepth(root.left)), maxDepth(root.right));
    }
}
