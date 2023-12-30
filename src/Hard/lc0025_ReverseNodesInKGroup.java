// Date: 30 December 2023
// Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.
// k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not
// a multiple of k then left-out nodes, in the end, should remain as it is.
// You may not alter the values in the list's nodes, only nodes themselves may be changed.

package Hard;

public class lc0025_ReverseNodesInKGroup {

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

    public ListNode getKth(ListNode curr, int k){
        // Function to get the kth node in the list from the current position
        while (curr != null && k > 0) {
            curr = curr.next; // Traverse 'k' nodes forward
            k--; // Decrement the count
        }
        return curr; // Return the kth node or null if end reached before k nodes
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        // Function to reverse groups of 'k' nodes in a linked list
        ListNode dummy = new ListNode(0, head); // Dummy node for easier manipulation
        ListNode groupPrev = dummy; // Pointer to track the previous group's last node
        ListNode nextcurr; // Placeholder for the next node in the sequence

        while (true){
            ListNode kth = getKth(groupPrev, k); // Get the kth node in the current group
            if (kth == null) {
                break; // Break if end of list reached
            }
            ListNode groupNext = kth.next; // Pointer to the next group or null

            ListNode prev = kth.next; // Initialize 'prev' as the first node after the current group
            ListNode curr = groupPrev.next; // Pointer to the start of the current group

            while (curr != groupNext) {
                nextcurr = curr.next; // Store the next node in the original sequence
                curr.next = prev; // Reverse the pointer of 'curr' to point to 'prev'
                prev = curr; // Move 'prev' one step forward
                curr = nextcurr; // Move 'curr' one step forward
            }

            // Rearrange pointers to include the reversed group in the list
            ListNode tmp = groupPrev.next; // Store the beginning of the current group
            groupPrev.next = kth; // Set the end of the reversed group
            groupPrev = tmp; // Move 'groupPrev' to the beginning of the next group
        }

        return dummy.next; // Return the modified linked list with groups of 'k' nodes reversed
    }
}
