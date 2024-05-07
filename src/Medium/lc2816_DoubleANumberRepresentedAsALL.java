// 7 May 2024
// You are given the head of a non-empty linked list representing a non-negative integer without leading zeroes.
//
//Return the head of the linked list after doubling it.

package Medium;

import java.math.BigInteger;

public class lc2816_DoubleANumberRepresentedAsALL {
    // Defining listnode
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // to create LL from array
    public static ListNode createLLFromArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        ListNode dummy = new ListNode(0, null);
        ListNode current = dummy;

        for (int i : arr) {
            current.next = new ListNode(i, current.next);
            current = current.next;
        }

        return dummy.next;
    }

    //to print LL
    public static void printLL(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // to reverse LL
    public static ListNode reverseLL(ListNode head, ListNode prev) {
        if (head == null) return prev;

        ListNode temp = head.next;
        head.next = prev;
        return reverseLL(temp, head);
    }


    public ListNode doubleIt1(ListNode head) {
        StringBuilder str = new StringBuilder();
        ListNode curr = head;

        while (curr != null) {
            str.append(curr.val);
            curr = curr.next;
        }

        BigInteger num = new BigInteger(str.toString());
        num = num.multiply(BigInteger.valueOf(2));

        ListNode dummy = new ListNode(0, null);
        ListNode tail = dummy;
        String numStr = num.toString();

        for (int i = 0; i < numStr.length(); i++) {
            char digit = numStr.charAt(i);
            tail.next = new ListNode(Character.getNumericValue(digit), tail.next);
            tail = tail.next;
        }

        return dummy.next;
    }

    public ListNode doubleIt2(ListNode head) {
        head = reverseLL(head, null);

        ListNode curr = head;
        ListNode prev = null;
        int carry = 0;

        while (curr != null) {
            int newval = curr.val * 2 + carry;
            curr.val = newval % 10;

            if (newval >= 10) {
                carry = 1;
            } else {
                carry = 0;
            }

            prev = curr;
            curr = curr.next;
        }

        if (carry != 0){
            ListNode newhead = new ListNode(carry, null);
            prev.next = newhead;
        }

        return reverseLL(head, null);
    }


    // Main function for testing
    public static void main(String[] args) {
        lc2816_DoubleANumberRepresentedAsALL obj = new lc2816_DoubleANumberRepresentedAsALL();
        int[] arr = {3, 4, 5, 4, 2, 5, 5, 9, 9, 9};

        ListNode head = createLLFromArray(arr);
        printLL(head);

        ListNode ans1 = obj.doubleIt1(head);
        printLL(ans1);

        ListNode head2 = createLLFromArray(arr);
        printLL(head2);

        ListNode ans2 = obj.doubleIt2(head2);
        printLL(ans2);
    }

}
