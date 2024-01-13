// Date: 13 January 2024
// Given a binary tree, determine if it is height-balanced
// A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node
// never differs by more than one.

package Easy;

public class lc0110_BalancedBinaryTree {
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

    // Record Pair to represent a key-value pair
    record Pair<K, V>(K key, V value){};

    // Function to perform depth-first search and check if a tree is balanced
    public Pair<Boolean, Integer> dfs (TreeNode root) {
        // Base case: If the current node is null, return a Pair indicating a balanced tree with height 0
        if (root == null) {
            return new Pair<>(true, 0);
        }

        // Recursively check the left and right subtrees
        var left = dfs(root.left);
        var right = dfs(root.right);

        // Check if the left and right subtrees are balanced and the height difference is at most 1
        var balanced = left.key() && right.key() && (Math.abs(left.value() - right.value()) <= 1);

        // Return a Pair indicating whether the subtree is balanced and its height
        return new Pair<>(balanced, 1 + Math.max(left.value(), right.value()));
    }

    // Function to check if a tree is balanced
    public boolean isBalanced(TreeNode root) {
        // Call dfs to perform the depth-first search and return the result indicating if
        // the tree is balanced
        return dfs(root).key();
    }
}
