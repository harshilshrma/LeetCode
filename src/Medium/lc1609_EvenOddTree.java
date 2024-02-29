// Date: 29 February 2024
// A binary tree is named Even-Odd if it meets the following conditions:
//
//The root of the binary tree is at level index 0, its children are at level index 1, their children are at level index 2, etc.
//For every even-indexed level, all nodes at the level have odd integer values in strictly increasing order (from left to right).
//For every odd-indexed level, all nodes at the level have even integer values in strictly decreasing order (from left to right).
//Given the root of a binary tree, return true if the binary tree is Even-Odd, otherwise return false.

package Medium;

import java.util.LinkedList;
import java.util.Queue;

public class lc1609_EvenOddTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // This method checks if the given binary tree is an "even-odd" tree using breadth-first search (BFS).
    // It iterates through each level of the tree, maintaining a queue to store nodes at each level.
    // At each level, it checks if the nodes satisfy the conditions for an even-odd tree:
    //For even levels, the values of nodes must be strictly increasing and odd.
    //For odd levels, the values of nodes must be strictly decreasing and even.
    //If any node violates these conditions, the method returns false; otherwise, it returns true.

    public boolean isEvenOddTreeByBFS(TreeNode root) {
        // Create a queue to perform breadth-first search
        Queue<TreeNode> q = new LinkedList<>();
        // Add the root node to the queue
        q.offer(root);

        // Flag to track if the current level is even or odd
        boolean even_level = true;

        // Loop until the queue is empty
        while (!q.isEmpty()) {
            // Get the number of elements in the current level
            int n = q.size();

            // Initialize the previous node's value based on the level
            int prev;
            if (even_level) {
                // For even level, initialize prev to the smallest possible value
                prev = Integer.MIN_VALUE;
            } else {
                // For odd level, initialize prev to the largest possible value
                prev = Integer.MAX_VALUE;
            }

            // Process each node in the current level
            while (n > 0) {
                // Remove the first node from the queue
                TreeNode currNode = q.poll();

                // Check if the current node's value violates the even or odd level conditions
                if (even_level && (currNode.val % 2 == 0 || currNode.val <= prev)) {
                    // If the condition is violated for even level, return false
                    return false;
                }
                if (!even_level && (currNode.val % 2 != 0 || currNode.val >= prev)) {
                    // If the condition is violated for odd level, return false
                    return false;
                }

                // Update prev to the current node's value
                prev = currNode.val;

                // Add the children of the current node to the queue if they exist
                if (currNode.left != null) {
                    q.offer(currNode.left);
                }
                if (currNode.right != null) {
                    q.offer(currNode.right);
                }

                // Decrement the count of nodes in the current level
                n--;
            }

            // Toggle the even_level flag for the next level
            even_level = !even_level;
        }

        // If all levels satisfy the conditions, return true
        return true;
    }
}
