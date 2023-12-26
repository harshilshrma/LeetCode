// Date: 26 December 2023
// Given head, the head of a linked list, determine if the linked list has a cycle in it.
// There is a cycle in a linked list if there is some node in the list that can be reached again by continuously
// following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is
// connected to. Note that pos is not passed as a parameter.
// Return true if there is a cycle in the linked list. Otherwise, return false.

package Easy;

public class lc0141_LinkedListCycle {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public boolean hasCycle(ListNode head) {
        ListNode fast = head;  // Initialize fast pointer to the head of the list
        ListNode slow = head;  // Initialize slow pointer to the head of the list

        // Iterate while fast pointer is not null and its next node is not null
        while (fast != null && fast.next != null) {
            fast = fast.next.next;  // Move the fast pointer by two nodes

            slow = slow.next;  // Move the slow pointer by one node

            // Check if the fast and slow pointers meet, indicating a cycle
            if (fast == slow) return true;
        }

        // Return false if fast reaches the end (no cycle detected)
        return false;
    }
}
