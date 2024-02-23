// Date: 22 February 2024
// You are given an integer n. There are n rooms numbered from 0 to n - 1.
//
//You are given a 2D integer array meetings where meetings[i] = [starti, endi] means that a meeting will be
// held during the half-closed time interval [starti, endi). All the values of starti are unique.
//
//Meetings are allocated to rooms in the following manner:
//
//Each meeting will take place in the unused room with the lowest number.
//If there are no available rooms, the meeting will be delayed until a room becomes free. The delayed meeting
// should have the same duration as the original meeting.
//When a room becomes unused, meetings that have an earlier original start time should be given the room.
//Return the number of the room that held the most meetings. If there are multiple rooms, return the
// room with the lowest number.
//
//A half-closed interval [a, b) is the interval between a and b including a and not including b.


package Hard;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class lc2402_MeetingRoomsIII {

    // Brute Force Approach
    public int mostBookedByBF(int n, int[][] meetings) {
        int m = meetings.length;

        // Sort meetings based on starting times
        Arrays.sort(meetings, Comparator.comparing(a -> a[0]));

        // Array to track the last available time for each room
        long[] lastAvailableAt = new long[n];
        // Array to track the number of times each room has been used
        int[] roomUsedCount = new int[n];

        // Iterate through each meeting
        for (int[] meet : meetings) {
            int start = meet[0];
            int ending = meet[1];
            boolean found = false;
            long earlyEndRoomTime = Long.MAX_VALUE;
            int earlyEndRoom = 0;

            // Find the first available meeting room for the current meeting
            for (int room = 0; room < n; room++) {
                if (lastAvailableAt[room] <= start) {
                    lastAvailableAt[room] = ending; // Current meeting will finish at ending time
                    roomUsedCount[room]++;
                    found = true;
                    break;
                }
                if (lastAvailableAt[room] < earlyEndRoomTime) {
                    earlyEndRoomTime = lastAvailableAt[room];
                    earlyEndRoom = room;
                }
            }

            // If no available room is found
            if (!found) {
                // Pick the room that will end first
                lastAvailableAt[earlyEndRoom] += (ending - start);
                roomUsedCount[earlyEndRoom]++;
            }
        }

        // Determine the room that has been used the most
        int resultRoom = -1;
        int maxUse = 0;
        for (int room = 0; room < n; room++) {
            if (roomUsedCount[room] > maxUse) {
                maxUse = roomUsedCount[room];
                resultRoom = room;
            }
        }
        return resultRoom; // Return the index of the room that has been used the most
    }

    // Optimal Approach
    public int mostBookedByOptimal(int n, int[][] meetings) {
        Arrays.sort(meetings, Comparator.comparing(a -> a[0]));

        int[] roomUsedCount = new int[n];

        // Priority queues to track used rooms and available rooms
        var usedRooms = new PriorityQueue<long[]>((a, b) -> a[0] != b[0] ? Long.compare(a[0], b[0]) : Long.compare(a[1], b[1]));
        var availableRooms = new PriorityQueue<Integer>();

        // Initialize available rooms
        for (int room = 0; room < n; room++) {
            availableRooms.add(room);
        }

        // Iterate through each meeting
        for (int[] meet : meetings) {
            int start = meet[0];
            int end = meet[1];

            // Make rooms available if their end time is before the current meeting start time
            while (!usedRooms.isEmpty() && usedRooms.peek()[0] <= start) {
                int room = (int) usedRooms.poll()[1];
                availableRooms.add(room);
            }

            if (!availableRooms.isEmpty()) {
                // Assign the meeting to an available room
                int room = availableRooms.poll();
                usedRooms.add(new long[]{end, room});
                roomUsedCount[room]++;
            } else {
                // Assign the meeting to the earliest ending room
                int room = (int) usedRooms.peek()[1];
                long endTime = usedRooms.poll()[0];
                usedRooms.add(new long[] {endTime + (end - start), room});
                roomUsedCount[room]++;
            }
        }

        // Determine the room that has been used the most
        int resultRoom = -1;
        int maxUse = 0;
        for (int room = 0; room < n; room++) {
            if (roomUsedCount[room] > maxUse) {
                maxUse = roomUsedCount[room];
                resultRoom = room;
            }
        }
        return resultRoom; // Return the index of the room that has been used the most
    }


    // Main function for testing
    public static void main(String[] args) {
        lc2402_MeetingRoomsIII obj = new lc2402_MeetingRoomsIII();
        int n = 2;
        int[][] meetings = {{1, 20}, {2, 10}, {3, 5}, {4, 9}, {6, 8}};
        System.out.println(obj.mostBookedByBF(n, meetings));
        System.out.println(obj.mostBookedByOptimal(n, meetings));
    }
}
