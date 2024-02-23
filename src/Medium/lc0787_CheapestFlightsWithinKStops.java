// Date: 23 February 2-24
// There are n cities connected by some number of flights. You are given an array flights where
// flights[i] = [fromi, toi, pricei] indicates that there is a flight from city fromi to city toi with cost pricei.
//
//You are also given three integers src, dst, and k, return the cheapest price from src to dst with at most k stops.
// If there is no such route, return -1.

package Medium;

import java.util.*;

public class lc0787_CheapestFlightsWithinKStops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // Initialize distance array to track minimum cost to reach each node
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);

        // Create adjacency list representation of the graph
        HashMap<Integer, List<int[]>> adj = new HashMap<>();
        for (int[] flight : flights) {
            int u = flight[0];
            int v = flight[1];
            int cost = flight[2];
            adj.computeIfAbsent(u, key -> new ArrayList<>()).add(new int[]{v, cost});
        }

        // Perform BFS traversal
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{src, 0}); // Enqueue source node with cost 0
        distance[src] = 0; // Update distance to source node

        int steps = 0; // Track number of stops

        while (!q.isEmpty() && steps <= k) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] current = q.poll();
                int u = current[0];
                int d = current[1];

                // Explore neighbors of current node
                List<int[]> neighbors = adj.getOrDefault(u, Collections.emptyList());
                for (int[] neighbor : neighbors) {
                    int v = neighbor[0];
                    int cost = neighbor[1];

                    // Update distance if a cheaper path is found
                    if (distance[v] > d + cost) {
                        distance[v] = d + cost;
                        q.offer(new int[]{v, d + cost}); // Enqueue neighbor with updated distance
                    }
                }
            }
            steps++; // Increment number of stops
        }
        return distance[dst] == Integer.MAX_VALUE ? -1 : distance[dst]; // Return minimum cost to reach destination
    }


    // Main function for testing
    public static void main(String[] args) {
        lc0787_CheapestFlightsWithinKStops obj = new lc0787_CheapestFlightsWithinKStops();
        int n = 4;
        int[][] flights = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        int src = 0, dst = 3, k = 1;
        System.out.println(obj.findCheapestPrice(n, flights, src, dst, k));
    }
}
