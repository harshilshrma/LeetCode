// Date: 12 January 2024
// Given the root of a binary tree, invert the tree, and return its root.

package Easy;

public class lc0226_InvertBinaryTree {

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

    // Tree Builder Class
    public static TreeNode createTree(Integer[] values) {
        if (values == null || values.length == 0 || values[0] == null) {
            return null;
        }

        TreeNode[] nodes = new TreeNode[values.length];


    }
}
