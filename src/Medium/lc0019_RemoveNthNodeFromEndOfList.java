// Date: 23 December 2023
// Given the head of a linked list, remove the nth node from the end of the list and return its head.

package Medium;

public class lc0019_RemoveNthNodeFromEndOfList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Checking if the list is empty or has only one node
        if (head == null ||  head.next == null) return null;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode left = dummy, right = head;

        // Moving the 'right' pointer 'n' nodes ahead
        while (n > 0 && right != null) {
            right = right.next;
            n--;
        }

        // Traversing and updating pointers until 'right' reaches the end of the list
        while (right != null) {
            left = left.next;
            right = right.next;
        }

        // deleting the next node of the left pointer which is at 'n' (as left node comes to 'n-1' position)
        // 1 -> 2 -> 3
        // l
        // We are doing:
        // 1 -> 3
        // l
        left.next = left.next.next;

        // returning dummy.next which is the head of our LL, "node1"
        return dummy.next;
    }

    // Method to print the linked list
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }

    // Main function for testing
    public static void main(String[] args) {
        lc0019_RemoveNthNodeFromEndOfList obj = new lc0019_RemoveNthNodeFromEndOfList();
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        printList(node1);
        System.out.println("\n");
        obj.removeNthFromEnd(node1, 2);
        printList(node1);
    }
}