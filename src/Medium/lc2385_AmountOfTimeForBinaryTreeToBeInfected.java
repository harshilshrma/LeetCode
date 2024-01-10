// Date: 10 January 2024
// You are given the root of a binary tree with unique values, and an integer start. At minute 0, an
// infection starts from the node with value start.
//Each minute, a node becomes infected if:
//The node is currently uninfected.
//The node is adjacent to an infected node.
//Return the number of minutes needed for the entire tree to be infected.

package Medium;
import java.util.*;

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
// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // BFS Approach
    // Time Complexity: O(N), 102 ms
    // Space Complexity: O(N), 115.46 MB

    // To make the undirected graph from the tree
    public void makeGraph(HashMap<Integer, List<Integer>> adj, int parent, TreeNode curr) {
        if (curr == null) {
            return; // Base case: stop when reaching a null node
        }

        // Check if the current node value is not in the adjacency list, add if absent
        if (!adj.containsKey(curr.val)){
            adj.put(curr.val, new ArrayList<>());
        }

        // If there's a parent node (not the root -1), create undirected edges
        if (parent != -1) {
            adj.get(curr.val).add(parent); // Connect current node to parent
            adj.get(parent).add(curr.val); // Connect parent to current node
        }

        // Recursively traverse left and right nodes
        makeGraph(adj, curr.val, curr.left);
        makeGraph(adj, curr.val, curr.right);
    }

    public int amountOfTimeByBFS(TreeNode root, int start) {
        // Initialize adjacency list to represent the undirected graph
        HashMap<Integer, List<Integer>> adjacencyList = new HashMap<>();
        // Build the adjacency list from the tree structure
        makeGraph(adjacencyList, -1, root);

        // Applying BFS from the start node
        Deque<Integer> q = new LinkedList<>(); // Queue for BFS traversal
        Set<Integer> visited = new HashSet<>(); // Using HashSet for visited nodes
        q.push(start); // Start BFS from the given 'start' node
        visited.add(start); // Mark 'start' node as visited

        int time = 0; // Initialize time counter for infected nodes
        while (!q.isEmpty()) { // Perform BFS traversal until the queue is empty
            int n = q.size(); // current level size

            while (n > 0) { // Process nodes at the current level
                int curr = q.getFirst(); // Get the current node from the queue
                q.pop(); // Dequeue the current node

                List<Integer> neighbors = adjacencyList.getOrDefault(curr, new ArrayList<>());
                // Retrieve neighbors of the current node from the adjacency list

                for (int neighbor : neighbors) { // Check neighbors
                    if (!visited.contains(neighbor)) {
                        q.add(neighbor); // Add unvisited neighbors to the queue for traversal
                        visited.add(neighbor); // Mark neighbor as visited
                    }
                }
                n--; // Decrement the level size counter
            }
            time++; // Increment the time for each level (minute)
        }
        return time - 1; // Return total time taken (subtract 1 as we started from minute 0)
    }
// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    // DFS Approach
    // Time Complexity: O(N), 7 ms
    // Space Complexity: O(H), 78.39 MB

    private int ans; // Global variable to hold the answer

    public int amountOfTimeByDFS(TreeNode root, int start) {
        dfs(root, start);
        return ans;
    }

    public int dfs(TreeNode root, int start) {
        if (root == null) return 0; // Base case for null node

        int leftDepth = dfs(root.left, start); // DFS for left subtree
        int rightDepth = dfs(root.right, start); // DFS for right subtree

        if (root.val == start) { // If 'start' node is found
            ans = Math.max(leftDepth, rightDepth); // Update 'ans' with maximum depth
            return -1; // Indicate 'start' node found
        } else if (leftDepth >= 0 && rightDepth >= 0) { // 'start' node in both subtrees
            return Math.max(leftDepth, rightDepth) + 1; // Return maximum depth + 1
        } else { // 'start' node only in one subtree
            ans = Math.max(ans, Math.abs(leftDepth - rightDepth)); // Update 'ans' with difference in depths
            return Math.min(leftDepth, rightDepth) - 1; // Return minimum depth - 1
        }
    }

// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    // To create a tree from an array
    public static TreeNode createTreeFromArray(Integer[] values) {
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

    public static void main(String[] args) {
        lc2385_AmountOfTimeForBinaryTreeToBeInfected obj = new lc2385_AmountOfTimeForBinaryTreeToBeInfected();
        Integer[] values = {1,5,3,null,4,10,6,9,2};
        TreeNode root = createTreeFromArray(values);
        int start = 10;
        System.out.println(obj.amountOfTimeByDFS(root, start));
    }
}