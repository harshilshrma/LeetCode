// Date: 12 January 2024
// Given the root of a binary tree, return the length of the diameter of the tree.
//The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path
// may or may not pass through the root.
//The length of a path between two nodes is represented by the number of edges between them.

package Easy;

public class lc0543_DiameterOfBinaryTree {
    public static class TreeNode {
        int val;
        TreeNode right;
        TreeNode left;
        TreeNode (int val, TreeNode right, TreeNode left) {
            this.val = val;
            this.right = right;
            this.left = left;
        }
    }

    // Result variable to store the diameter of the binary tree
    private int result = -1;

    // Function to perform depth-first search and calculate the height of the tree
    private int dfs(TreeNode current) {
        // Base case: If the current node is null, return -1
        if (current == null) {
            return -1;
        }

        // Recursive calculation of the height of the left and right subtrees
        int left = 1 + dfs(current.left);
        int right = 1 + dfs(current.right);

        // Update the result with the maximum diameter obtained so far
        result = Math.max(result, (left + right));

        // Return the maximum height between left and right subtrees
        return Math.max(left, right);
    }

    // Function to calculate the diameter of the binary tree
    public int diameterOfBinaryTree(TreeNode root) {
        // Perform depth-first search to calculate height and update the result
        dfs(root);

        // Return the final result representing the diameter of the binary tree
        return result;
    }
}
