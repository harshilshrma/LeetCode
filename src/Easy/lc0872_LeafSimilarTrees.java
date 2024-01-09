// Date: 9 January 2024
// Consider all the leaves of a binary tree, from left to right order, the values of those leaves form a leaf
// value sequence.

package Easy;

import java.util.ArrayList;
import java.util.List;

public class lc0872_LeafSimilarTrees {
    public static class TreeNode {
        int val;
        TreeNode right;
        TreeNode left;
        TreeNode(int val, TreeNode right, TreeNode left) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public void dfs(TreeNode node, List<Integer> sequence) {
        if (node == null){
            return;
        }

        if (node.left == null && node.right == null) {
            sequence.add(node.val);
        }
        dfs(node.right, sequence);
        dfs(node.left, sequence);
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> seq1 = new ArrayList<>();
        List<Integer> seq2 = new ArrayList<>();

        dfs(root1, seq1);
        dfs(root2, seq2);

        return seq1.equals(seq2);
    }

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

        for (int i = 0; i < values.length / 2; i++) {
            if (nodes[i] != null) {
                int leftIdx = 2 * i + 1;
                int rightIdx = 2 * i + 2;
                nodes[i].left = (leftIdx < values.length) ? nodes[leftIdx] : null;
                nodes[i].right = (rightIdx < values.length) ? nodes[rightIdx] : null;
            }
        }
        return nodes[0];
    }

    // Main function for testing
    public static void main(String[] args) {
        lc0872_LeafSimilarTrees obj = new lc0872_LeafSimilarTrees();
        Integer[] root1 = {3,5,1,6,2,9,8,null,null,7,4};
        Integer[] root2 = {3,5,1,6,7,4,2,null,null,null,null,null,null,9,8};
        TreeNode tree1 = createTree(root1);
        TreeNode tree2 = createTree(root2);

        System.out.println(obj.leafSimilar(tree1, tree2));
    }
}
