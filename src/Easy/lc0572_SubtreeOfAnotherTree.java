// Date: 17 January 2024
// Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with
// the same structure and node values of subRoot and false otherwise.
//A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's
// descendants. The tree tree could also be considered as a subtree of itself.

package Easy;

public class lc0572_SubtreeOfAnotherTree {
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
    public boolean isSameTree(TreeNode s, TreeNode t) {
        // Base case: Both nodes are null, considered equal
        if (s == null && t == null) {
            return true;
        }

        // Check if nodes are not null and have equal values
        if ((s != null && t != null) && (s.val == t.val)) {
            // Recursively check left and right subtrees
            return (isSameTree(s.left, t.left) && isSameTree(s.right, t.right));
        }

        // Nodes are not equal
        return false;
    }

    // Function to check if a tree is a subtree of another tree
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // Base case: The subtree is considered present if it is null
        if (subRoot == null) {
            return true;
        }

        // Base case: The main tree is empty, subtree is not present
        if (root == null) {
            return false;
        }

        // Check if the current subtree is the same as the main tree or present in left or right subtrees
        if (isSameTree(root, subRoot)) {
            return true;
        }

        // Recursively check left and right subtrees
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
}
