// 16-05-2024 - 12:18 pm
// 

package Easy;

public class lc2331_EvaluateBooleanBinaryTree {
    // Functions
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean evaluateTree(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root.val != 0; // Convert int to boolean
        }

        if (root.val == 2) {
            return evaluateTree(root.left) | evaluateTree(root.right);
        }

        return evaluateTree(root.left) & evaluateTree(root.right);
    }
}



