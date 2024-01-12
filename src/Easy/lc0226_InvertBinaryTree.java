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

    public TreeNode invertTree(TreeNode root) {
        // Base case: If the root is null, return null
        if (root == null) {
            return null;
        }

        // Swap the left and right children of the current node
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // Recursively invert the left and right subtrees
        invertTree(root.left);
        invertTree(root.right);

        // Return the inverted tree
        return root;
    }

    // Main function for testing
    public static void main(String[] args) {
        lc0226_InvertBinaryTree obj = new lc0226_InvertBinaryTree();
        Integer[] values = {4,2,7,1,3,6,9};
        TreeNode root = createTree(values);
        System.out.println(obj.invertTree(root));
    }
}
