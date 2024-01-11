// Date: 11 January 2024
// Given the root of a binary tree, find the maximum value v for which there exist different nodes a and b
// where v = |a.val - b.val| and a is an ancestor of b.
// A node a is an ancestor of b if either: any child of a is equal to b or any child of a is an ancestor of b

package Medium;

public class lc1026_MaximumDifferenceBetweenNodeAndAncestor {
    // Definition for a binary tree node.
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

    // Tree Builder class
    public static TreeNode createTree (Integer[] values) {
        if (values == null || values.length == 0 || values[0] == null) {
            return null;
        }

        TreeNode[] nodes = new TreeNode[values.length];
        for (int i = 0; i < values.length; i++) {
            if (values[i] != null) {
                nodes[i] = new TreeNode(values[i], null, null);
            }
        }

        for (int i = 0; i < values.length; i++) {
            if (nodes[i] != null) {
                int leftIdx = 2 * i + 1;
                int rightIdx = 2 * i + 2;
                nodes[i].left = (leftIdx < values.length) ? nodes[leftIdx] : null;
                nodes[i].right = (rightIdx < values.length) ? nodes[rightIdx] : null;
            }
        }
        return nodes[0];
    }

// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    // Brute Force

    private int maxDiff;

    public void findMaxDiffUtil(TreeNode root, TreeNode child) {
        if (root == null || child == null) {
            return;
        }
        maxDiff = Math.max(maxDiff, Math.abs(root.val - child.val));

        findMaxDiffUtil(root, child.left);
        findMaxDiffUtil(root, child.right);
    }

    public void findMaxDiff(TreeNode root) {
        if (root == null) return;

        findMaxDiffUtil(root, root.left);
        findMaxDiffUtil(root, root.right);

        findMaxDiff(root.right);
        findMaxDiff(root.left);
    }


    public int maxAncestorDiff(TreeNode root) {
        maxDiff = -1;
        findMaxDiff(root);
        return maxDiff;
    }

    // Main function for testing
    public static void main(String[] args) {
        lc1026_MaximumDifferenceBetweenNodeAndAncestor obj = new lc1026_MaximumDifferenceBetweenNodeAndAncestor();
        Integer[] values = {8,3,10,1,6,null,14,null,null,4,7,13};
        TreeNode root = createTree(values);
        System.out.println(obj.maxAncestorDiff(root));
    }
}
