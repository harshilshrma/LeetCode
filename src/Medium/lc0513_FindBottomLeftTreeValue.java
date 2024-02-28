// Date: 28 February 2024
// Given the root of a binary tree, return the leftmost value in the last row of the tree.

package Medium;

public class lc0513_FindBottomLeftTreeValue {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private int maxDepth;
    private int bottomLeft; // Result value

    public void dfs(TreeNode root, int currDepth) {
        if (root == null) {
            return;
        }

        if (currDepth > maxDepth) {
            maxDepth = currDepth;
            // Update bottomLeft to the value of the leftmost node at the current depth
            bottomLeft = root.val;
        }

        // Recursively traverse left and right subtrees, incrementing the depth
        dfs(root.left, currDepth + 1);
        dfs(root.right, currDepth + 1);
    }

    public int findBottomLeftValue(TreeNode root) {
        // Initialize maxDepth to -1 before starting DFS
        maxDepth = -1;
        // Start DFS from the root with initial depth 0
        dfs(root, 0);

        // Return the value of the bottom-left node
        return bottomLeft;
    }

}
