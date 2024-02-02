// Date: 1 February 2024
// Given the root of a binary tree, imagine yourself standing on the right side of it,
// return the values of the nodes you can see ordered from top to bottom.

package Medium;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class lc0199_BinaryTreeRightSideView {
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

    public void bfs (List<Integer> list, TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int levelSize = q.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode curr = q.poll();
                if (i == 0) list.add(curr.val);
                if (curr.right != null) q.offer(curr.right);
                if (curr.left != null) q.offer(curr.left);
            }
        }
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if (root == null) return list;
        bfs(list, root);

        return list;
    }
}
