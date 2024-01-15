// Date: 15 January 2024
// Given the roots of two binary trees p and q, write a function to check if they are the same or not.
//Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.

package Easy;

public class lc0100_SameTree {

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

    // Function to check if two trees are the same
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Call the dfs function to perform the recursive comparison
        return dfs(p, q);
    }

    // Recursive helper function to compare nodes of two trees
    public boolean dfs(TreeNode p, TreeNode q) {
        // Base case: If both nodes are null, they are equal
        if (p == null && q == null) return true;

        // If one node is null and the other is not, they are not equal
        if (p == null || q == null) return false;

        // If the values of the current nodes are different,
        // the trees are not equal
        if (p.val != q.val) return false;

        // Recursively compare the left and right subtrees
        boolean left = dfs(p.left, q.left);
        boolean right = dfs(p.right, q.right);

        // Return true only if both left and right subtrees are equal
        return left && right;
    }
}
