// Date: 22 December 2023
// You are given the head of a singly linked-list. The list can be represented as:
// L0 → L1 → … → Ln - 1 → Ln
// Reorder the list to be on the following form:
// L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
// You may not modify the values in the list's nodes. Only nodes themselves may be changed.

package Medium;

public class lc0143_ReorderList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public void reorderList(ListNode head) {
        // Finding middle of list using a slow and fast pointer approach
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reversing the second half of the list using a nextCurrent variable (Reversed Link List problem)
        ListNode second = slow.next;
        ListNode prev = slow.next = null;
        ListNode nextCurrent;
        while (second != null) {
            nextCurrent = second.next;
            second.next = prev;
            prev = second;
            second = nextCurrent;
        }

        // Merging these two halves
        // Re-assigning the pointers to match the pattern
        // The prev from above list is the start of the second half list from the back
        ListNode first = head;
        second = prev;
        while (second != null) {
            // We will break these links so we are saving these
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;

            // Arranging to obtain the pattern
            first.next = second;
            second.next = temp1;

            // Updating the pointers
            first = temp1;
            second = temp2;
        }
    }

    // Method to print the linked list
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println(); // Print a new line after printing the list
    }

    // Main function for testing
    public static void main(String[] args) {
        lc0143_ReorderList obj = new lc0143_ReorderList();
        ListNode node4 = new ListNode(4);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        printList(node1);
        obj.reorderList(node1);
        printList(node1);
    }
}
