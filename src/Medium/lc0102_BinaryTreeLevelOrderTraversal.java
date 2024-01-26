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
        // List to store the result
        List<List<Integer>> res = new ArrayList<>();
        // Queue for breadth-first search
        Queue<TreeNode> queue = new LinkedList<>();

        // Check if the tree is empty
        if (root == null) return res;

        // Add the root to the queue to start BFS
        queue.add(root);

        // Continue BFS until the queue is empty
        while (!queue.isEmpty()) {
            // Get the number of nodes at the current level
            int len = queue.size();
            // List to store elements at the current level
            List<Integer> level = new ArrayList<>();
            // Process each node at the current level
            for (int i = 0; i < len; i++) {
                TreeNode curr = queue.poll();
                // Add the current node's value to the level list
                level.add(curr.val);
                // Add left and right children to the queue for the next level
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
            // Add the level list to the result
            res.add(level);
        }
        // Return the final result
        return res;
    }
}
