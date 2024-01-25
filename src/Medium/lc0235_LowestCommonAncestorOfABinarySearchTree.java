// Date: 25 January 2024
// Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.
//According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and
// q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of
// itself).”

package Medium;

public class lc0235_LowestCommonAncestorOfABinarySearchTree {
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

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > root.val && q.val > root.val) {
            // LCA is in the right subtree
            return lowestCommonAncestor(root.right, p, q);
        }
        if (p.val < root.val && q.val < root.val) {
            // LCA is in the left subtree
            return lowestCommonAncestor(root.left, p, q);
        }
        // LCA found or root is the LCA
        return root;
    }
}
