// Date: 8 January 2024
// Given the root node of a binary search tree and two integers low and high, return the sum of values of all
// nodes with a value in the inclusive range [low, high].

package Easy;

public class lc0938_RangeSumOfBST {
    public static class TreeNode {
        int val;
        TreeNode right;
        TreeNode left;
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }

        if (root.val > high) {
            return rangeSumBST(root.left, low, high);
        }

        if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        }

        return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    }

    // Main function for testing
    public static void main(String[] args) {
        lc0938_RangeSumOfBST obj = new lc0938_RangeSumOfBST();
        TreeNode node3 = new TreeNode(3, null, null);
        TreeNode node7 = new TreeNode(7, null, null);
        TreeNode node5 = new TreeNode(5, node3, node7);
        TreeNode node18 = new TreeNode(18, null, null);
        TreeNode node15 = new TreeNode(15, null, node18);
        TreeNode root = new TreeNode(10, node5, node15);

        int low = 7;
        int high = 15;

        System.out.println(obj.rangeSumBST(root, low, high));
    }
}
