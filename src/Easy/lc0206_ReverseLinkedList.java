// Date: 20 December 2023
// Given the head of a singly linked list, reverse the list, and return the reversed list.

package Easy;

public class lc0206_ReverseLinkedList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode reverseList(ListNode head) {
        // ITERATIVE METHOD
        ListNode current = head;
        ListNode previous = null;
        ListNode nextCurrent = null;

        while (current != null) {
            // Storing the next node in the original sequence
            nextCurrent = current.next;

            // Reversing the link: current node now points to the previous node
            current.next = previous;

            // Advancing pointers: updating 'previous' and 'current' for the next iteration
            previous = current;
            current = nextCurrent;
        }
        return previous;

        // RECURSIVE METHOD
//        return rev(head, null);
    }

    public ListNode rev(ListNode node, ListNode pre) {
        if (node == null) return pre;
        ListNode temp = node.next;
        node.next = pre;
        return rev(temp, node);
    }

    // Main function for testing
    public static void main (String[] args){
        lc0206_ReverseLinkedList obj = new lc0206_ReverseLinkedList();
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        ListNode reversedList = obj.reverseList(node1);

        while (reversedList != null) {
            System.out.print(reversedList.val + " "); // Print the value of each node
            reversedList = reversedList.next; // Move to the next node
        }
    }
}