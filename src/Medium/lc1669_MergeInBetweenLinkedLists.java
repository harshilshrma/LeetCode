// Date: 20 March 2024
// You are given two linked lists: list1 and list2 of sizes n and m respectively.
//
//Remove list1's nodes from the ath node to the bth node, and put list2 in their place.
//The blue edges and nodes in the following figure indicate the result:
// https://leetcode.com/problems/merge-in-between-linked-lists

package Medium;

public class lc1669_MergeInBetweenLinkedLists {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        // Initialize a pointer for the node before the sublist to be replaced
        ListNode left = null;

        // Initialize a pointer for the starting node of the sublist to be replaced
        ListNode right = list1;

        // Traverse the list to find the node before the sublist to be replaced
        for (int i = 0; i <= b; i++) {
            // If the current index matches the 'a' index, update the left pointer
            if (i == a - 1) {
                left = right;
            }
            // Move the right pointer to the next node
            right = right.next;
        }

        // Connect the 'next' pointer of the node before the sublist to list2
        left.next = list2;

        // Traverse list2 to find the last node
        ListNode temp = list2;
        while (temp.next != null) {
            temp = temp.next;
        }

        // Connect the 'next' pointer of the last node of list2 to the node after the sublist
        temp.next = right;

        // Return the modified list1
        return list1;
    }
}
