// 15 April 2024
// Given the root of a binary tree, return the sum of all left leaves.
//
//A leaf is a node with no children. A left leaf is a leaf that is the left child of another node.

package Easy;

public class lc0404_SumOfLeftLeaves {
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

    public int solve(TreeNode curr, boolean isLeft) {
        if (curr == null) {
            return 0;
        }

        if (curr.left == null && curr.right == null && isLeft) {
            return curr.val;
        }

        return solve(curr.left, true) + solve(curr.right, false);
    }

    public int sumOfLeftLeaves(TreeNode root) {
        return solve(root, false);
    }

}
