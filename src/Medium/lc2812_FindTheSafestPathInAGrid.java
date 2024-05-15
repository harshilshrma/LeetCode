// 15-05-2024 - 11:37 am
// You are given a 0-indexed 2D matrix grid of size n x n, where (r, c) represents:
//
//A cell containing a thief if grid[r][c] = 1
//An empty cell if grid[r][c] = 0
//You are initially positioned at cell (0, 0). In one move, you can move to any adjacent cell in the grid,
// including cells containing thieves.
//
//The safeness factor of a path on the grid is defined as the minimum manhattan distance from any cell in the
// path to any thief in the grid.
//
//Return the maximum safeness factor of all paths leading to cell (n - 1, n - 1).
//
//An adjacent cell of cell (r, c), is one of the cells (r, c + 1), (r, c - 1), (r + 1, c) and (r - 1, c) if it exists.
//
//The Manhattan distance between two cells (a, b) and (x, y) is equal to |a - x| + |b - y|, where |val|
// denotes the absolute value of val.

package Medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class lc2812_FindTheSafestPathInAGrid {
    // Functions

    public static List<List<Integer>> listMaker(int[][] arr) {
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < arr[0].length; j++) {
                temp.add(arr[i][j]);
            }
            ans.add(temp);
        }

        return ans;
    }

    public boolean check(int[][] distToNearestThief, int mid_sf) {
        int n = distToNearestThief.length;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];

        int[][] directions;
        directions = new int[][]{{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

        // we have to go from (0, 0) to (n - 1, n - 1)
        q.add(new int[]{0, 0});
        visited[0][0] = true;

        if(distToNearestThief[0][0] < mid_sf) {
            return false;
        }

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int curr_i = curr[0];
            int curr_j = curr[1];

            if (curr_i == n - 1 && curr_j == n - 1) {
                return true;
            }

            for (int[] dir : directions) {
                int new_i = curr_i + dir[0];
                int new_j = curr_j + dir[1];

                if (new_i >= 0 && new_j >= 0 && new_i < n && new_j < n && !visited[new_i][new_j]) {
                    if (distToNearestThief[new_i][new_j] < mid_sf) {
                        continue; // reject this cell
                    }
                    q.add(new int[]{new_i, new_j});
                    visited[new_i][new_j] = true;
                }

            }
        }

        return false;
    }

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        int[][] directions;
        directions = new int[][]{{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

        // step1 Pre-calculation of the distToNearestThief
        int[][] distToNearestThief = new int[n][n];
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];

        // push all cells in q where thieves are present
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    q.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                int[] curr = q.poll();
                int curr_i = curr[0];
                int curr_j = curr[1];

                distToNearestThief[curr_i][curr_j] = level;

                for (int[] dir : directions) {
                    int new_i = curr_i + dir[0];
                    int new_j = curr_j + dir[1];

                    if (new_i < 0 || new_i >= n || new_j < 0 || new_j >= n || visited[new_i][new_j]) {
                        continue;
                    }

                    q.add(new int[]{new_i, new_j});
                    visited[new_i][new_j] = true;
                }
            }

            level++;
        }

        // Special case: Return 0 if the destination cell contains a thief
        if (grid.get(n - 1).get(n - 1) == 1) {
            return 0;
        }

        // step2 apply binary search on SF
        int l = 0;
        int r = 400;
        int res = 0;

        while (l <= r) {
            int mid_sf = l + (r - l) / 2;

            if (check(distToNearestThief, mid_sf)) {
                res = mid_sf;
                l = mid_sf + 1;
            } else {
                r = mid_sf - 1;
            }
        }

        return res;
    }


    // Main function for testing
    public static void main(String[] args) {
        lc2812_FindTheSafestPathInAGrid obj = new lc2812_FindTheSafestPathInAGrid();
        int[][] grid1 = {{1, 0, 0}, {0, 0, 0}, {0, 0, 1}};
        int[][] grid2 = {{0, 0, 1}, {0, 0, 0}, {0, 0, 0}};
        int[][] grid3 = {{0, 0, 0, 1}, {0, 0, 0, 0}, {0, 0, 0, 0}, {1, 0, 0, 0}};
        int[][] grid4 = {{1}};
        int[][] grid5 = {{1, 1, 1}, {0, 1, 1}, {0, 0, 0}};


        List<List<Integer>> list1 = listMaker(grid1);
        List<List<Integer>> list2 = listMaker(grid2);
        List<List<Integer>> list3 = listMaker(grid3);
        List<List<Integer>> list4 = listMaker(grid4);
        List<List<Integer>> list5 = listMaker(grid5);

        System.out.println(obj.maximumSafenessFactor(list1));
        System.out.println(obj.maximumSafenessFactor(list2));
        System.out.println(obj.maximumSafenessFactor(list3));
        System.out.println(obj.maximumSafenessFactor(list4));
        System.out.println(obj.maximumSafenessFactor(list5));
    }
}



