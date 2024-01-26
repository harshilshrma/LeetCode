// Date: 26 January 2024
// Given the root of a binary tree, return the level order traversal of its nodes' values.
// (i.e., from left to right, level by level).

package Medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class lc0102_BinaryTreeLevelOrderTraversal {

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

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        if (root == null) return null;

        while (!q.isEmpty()) {
            int len = q.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                TreeNode curr = q.poll();
                level.add(curr.val);

                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
            res.add(level);
        }
        return res;
    }
}
