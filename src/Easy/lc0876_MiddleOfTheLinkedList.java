// Date: 07 March 2024
// Given the head of a singly linked list, return the middle node of the linked list.
//
//If there are two middle nodes, return the second middle node.

package Easy;

public class lc0876_MiddleOfTheLinkedList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode middleNode(ListNode head) {
        ListNode slowPtr = head;
        ListNode fastPtr = head;
        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
        }

        return slowPtr;
    }
}
