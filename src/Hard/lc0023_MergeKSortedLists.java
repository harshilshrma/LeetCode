// Date: 29 December 2023
// You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
// Merge all the linked-lists into one sorted linked-list and return it.

package Hard;

public class lc0023_MergeKSortedLists {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode merge(ListNode l1, ListNode l2) {
        // Creating a dummy node to facilitate the merge
        ListNode dummy = new ListNode(0);
        // Initializing a pointer for building the merged list
        ListNode curr = dummy;

        // Merging while both lists have nodes
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                // Appending the smaller node to the merged list
                curr.next = l1;
                // Moving the pointer in list1 ahead
                l1 = l1.next;
            } else {
                // Appending the smaller node to the merged list
                curr.next = l2;
                // Moving the pointer in list2 ahead
                l2 = l2.next;
            }
            // Advancing the merged list pointer
            curr = curr.next;
        }

        // Concatenating any remaining nodes of either list
        curr.next = (l1 != null) ? l1 : l2;

        // Returning the merged list starting from the next of the dummy node
        return dummy.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        // Getting the total number of lists
        int size = lists.length;
        // Initializing the merging interval
        int interval = 1;

        // Continue merging until the interval is less than the size
        while (interval < size) {
            // Iterate over lists with the current interval
            for (int i = 0; i < size - interval; i += 2 * interval) {
                // Merge lists at indices i and i + interval
                lists[i] = merge(lists[i], lists[i + interval]);
            }
            // Double the interval for the next iteration
            interval *= 2;
        }

        // Return the first list if there is any; otherwise, return null
        return (size > 0) ? lists[0] : null;
    }
}
