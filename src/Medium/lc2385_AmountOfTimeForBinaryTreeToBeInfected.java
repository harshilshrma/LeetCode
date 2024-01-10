// Date: 10 January 2024
// You are given the root of a binary tree with unique values, and an integer start. At minute 0, an
// infection starts from the node with value start.
//Each minute, a node becomes infected if:
//The node is currently uninfected.
//The node is adjacent to an infected node.
//Return the number of minutes needed for the entire tree to be infected.

package Medium;

public class lc2385_AmountOfTimeForBinaryTreeToBeInfected {
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

    public int amountOfTime(TreeNode root, int start) {

    }
}
