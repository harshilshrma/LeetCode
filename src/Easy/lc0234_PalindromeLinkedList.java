// Date: 22 March 2024
// Given the head of a singly linked list, return true if it is a palindrome
// or false otherwise.

package Easy;

import java.util.ArrayList;
import java.util.List;

public class lc0234_PalindromeLinkedList {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // Approach-1 (Using extra space)
// T.C : O(n)
// S.C : O(n)
    static class Solution1 {
        public boolean isPalindrome(ListNode head) {
            List<Integer> temp = new ArrayList<>();

            ListNode curr = head;
            while (curr != null) {
                temp.add(curr.val);
                curr = curr.next;
            }

            int i = 0;
            int j = temp.size() - 1;

            while (i < j) {
                if (!temp.get(i).equals(temp.get(j)))
                    return false;

                i++;
                j--;
            }

            return true;
        }
    }

    // Approach-2 (Reversing the 2nd half of linked list)
// T.C : O(n)
// S.C : O(1)
    static class Solution2 {
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null)
                return head;

            ListNode last = reverseList(head.next);
            head.next.next = head;
            head.next = null;
            return last;
        }

        public boolean isPalindrome(ListNode head) {
            if (head == null || head.next == null) {
                return true;
            }

            ListNode slow = head;
            ListNode fast = head;
            ListNode prev = null;

            while (fast != null && fast.next != null) {
                prev = slow;
                slow = slow.next;
                fast = fast.next.next;
            }

            ListNode revhead = reverseList(slow);
            prev.next = null;

            while (revhead != null && head != null) {
                if (revhead.val != head.val) {
                    return false;
                }

                revhead = revhead.next;
                head = head.next;
            }

            return true;
        }
    }

    // Approach-3 (Reversing the 2nd half of linked list)
// T.C : O(n)
// S.C : O(1)
    static class Solution3 {
        public boolean isPalindrome(ListNode head) {
            if (head == null || head.next == null) {
                return true;
            }

            ListNode slow = head;
            ListNode fast = head;
            ListNode prev = null;

            while (fast != null && fast.next != null) {
                fast = fast.next.next;

                ListNode temp = slow.next;
                slow.next = prev;
                prev = slow;
                slow = temp;
            }

            // To handle case when number of nodes is odd
            if (fast != null)
                slow = slow.next;

            while (prev != null && slow != null) {
                if (prev.val != slow.val) {
                    return false;
                }

                prev = prev.next;
                slow = slow.next;
            }

            return true;
        }
    }

    // Approach-4 (Using Pure Recursion - Because when recursion winds back, we can start comparing
    // curr head with last node and so on)
// T.C : O(n)
// S.C : O(1) Auxiliary space
    static class Solution4 {
        ListNode curr;

        public boolean solve(ListNode head) {
            if (head == null)
                return true;

            if (!solve(head.next) || head.val != curr.val) {
                return false;
            }

            curr = curr.next;
            return true;
        }

        public boolean isPalindrome(ListNode head) {
            curr = head;

            return solve(head);
        }
    }

}
