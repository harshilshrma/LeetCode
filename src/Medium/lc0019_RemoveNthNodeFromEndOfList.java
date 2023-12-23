// Date: 23 December 2023
// Given the head of a linked list, remove the nth node from the end of the list and return its head.

package Medium;

public class lc0019_RemoveNthNodeFromEndOfList {
    public static class ListNode {
        int val;
        lc0143_ReorderList.ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, lc0143_ReorderList.ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

    }

    // Method to print the linked list
    public static void printList(lc0143_ReorderList.ListNode head) {
        lc0143_ReorderList.ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println(); // Print a new line after printing the list
    }

}
