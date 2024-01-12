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

    public int maxDepthByRecursion(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max((maxDepthByRecursion(root.left)), maxDepthByRecursion(root.right));
    }
}
