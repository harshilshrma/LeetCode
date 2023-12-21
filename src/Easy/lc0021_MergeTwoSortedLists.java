// Date: 21 December 2023
// You are given the heads of two sorted linked lists list1 and list2.
// Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the
// first two lists. Return the head of the merged linked list.

package Easy;

public class lc0021_MergeTwoSortedLists {
    // Definition for singly-linked list.
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

    public ListNode mergeTwoListsByIteration(ListNode list1, ListNode list2) {
        final ListNode dummy = new ListNode();
        ListNode tail = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                // Adding to tail
                tail.next = list1;
                // Updating list1 pointer
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            // tail pointer is updated no matter what
            tail = tail.next;
        }
        // Concatenation of Remaining Nodes
        tail.next = list1 != null
                ? list1
                : list2;
        return dummy.next;
    }

    public ListNode mergeTwoListsByRecursion(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        if (list1.val < list2.val) {
            list1.next = mergeTwoListsByRecursion(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoListsByRecursion(list2.next, list1);
            return list2;
        }
    }
}
