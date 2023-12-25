// Date: 25 December 2023
// You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse
// order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
// You may assume the two numbers do not contain any leading zero, except the number 0 itself.

package Medium;

public class lc0002_AddTwoNumbers {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0; // Variable to hold carry-over values
        int remainder = 0; // Variable to store the remainder after sum calculation
        int sum = 0; // Variable to store temporary sum
        ListNode head = null; // Resultant linked list head
        ListNode temp = null; // Temporary reference for list traversal

        while (l1 != null || l2 != null || carry > 0) {
            // Calculate the sum of digits along with the carry-over
            sum = carry + (((l1 != null) ? l1.val : 0) + ((l2 != null) ? l2.val : 0));
            remainder = sum % 10; // Calculate the remainder after summing digits
            carry = sum / 10; // Calculate the carry-over for the next iteration

            // Create a new node with the calculated remainder
            ListNode newNode = new ListNode(remainder);

            // Adding the new node to the resultant linked list
            if (head == null) {
                // If the resultant list is empty, set the new node as the head
                head = newNode;
            } else {
                // If the list is not empty, find the last node and append the new node
                temp = head;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = newNode; // Append the new node to the end of the list
                newNode.next = null; // Set the next of new node as null (end of list)
            }

            // Move to the next nodes in the input linked lists
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return head; // Return the head of the resultant linked list
    }
}
