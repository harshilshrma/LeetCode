// Date: 24 February 2024
// You are given an integer n indicating there are n people numbered from 0 to n - 1. You are also given a
// 0-indexed 2D integer array meetings where meetings[i] = [xi, yi, timei] indicates that person xi and person yi
// have a meeting at timei. A person may attend multiple meetings at the same time. Finally, you are given
// an integer firstPerson.
//
//Person 0 has a secret and initially shares the secret with a person firstPerson at time 0. This secret is then shared
// every time a meeting takes place with a person that has the secret. More formally, for every meeting, if
// a person xi has the secret at timei, then they will share the secret with person yi, and vice versa.
//
//The secrets are shared instantaneously. That is, a person may receive the secret and share it with people in
// other meetings within the same time frame.
//
//Return a list of all the people that have the secret after all the meetings have taken place. You may
// return the answer in any orde


package Hard;

import java.util.*;

public class lc2092_FindAllPeopleWithSecret {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        // Organize meetings based on their times
        Map<Integer, List<int[]>> timeMeetings = new TreeMap<>();
        for (int[] meeting : meetings) {
            int p1 = meeting[0], p2 = meeting[1], time = meeting[2];
            timeMeetings.computeIfAbsent(time, k -> new ArrayList<>()).add(new int[]{p1, p2});
        }

        // Initialize knowledge of secret
        boolean[] knowsSecret = new boolean[n];
        knowsSecret[0] = true;
        knowsSecret[firstPerson] = true;

        // Traverse through meetings
        for (int t : timeMeetings.keySet()) {
            // Group meetings by attendees
            Map<Integer, List<Integer>> meet = new HashMap<>();
            for (int[] meeting : timeMeetings.get(t)) {
                int p1 = meeting[0], p2 = meeting[1];
                meet.computeIfAbsent(p1, k -> new ArrayList<>()).add(p2);
                meet.computeIfAbsent(p2, k -> new ArrayList<>()).add(p1);
            }

            // Initialize persons who attended meetings at this time
            Set<Integer> start = new HashSet<>();
            for (int[] meeting : timeMeetings.get(t)) {
                int p1 = meeting[0], p2 = meeting[1];
                if (knowsSecret[p1]) {
                    start.add(p1);
                }
                if (knowsSecret[p2]) {
                    start.add(p2);
                }
            }

            // Perform BFS traversal
            Queue<Integer> q = new LinkedList<>(start);
            while (!q.isEmpty()) {
                int person = q.poll();
                for (int nextPerson : meet.getOrDefault(person, new ArrayList<>())) {
                    if (!knowsSecret[nextPerson]) {
                        knowsSecret[nextPerson] = true;
                        q.offer(nextPerson);
                    }
                }
            }
        }

        // Extract the persons who know the secret
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            if (knowsSecret[i]) {
                result.add(i);
            }
        }
        return result;
    }


    // Min function for testing
    public static void main(String[] args) {
        lc2092_FindAllPeopleWithSecret obj = new lc2092_FindAllPeopleWithSecret();
        int n = 5;
        int[][] meetings = {{3, 4, 2}, {1, 2, 1}, {2, 3, 1}};
        int firstPerson = 1;
        System.out.println(obj.findAllPeople(n, meetings, firstPerson));
    }
}
