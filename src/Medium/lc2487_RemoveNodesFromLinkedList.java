// 6 May 2024
// You are given the head of a linked list.
//
//Remove every node which has a node with a greater value anywhere to the right side of it.
//
//Return the head of the modified linked list.

package Medium;

import java.util.Stack;

public class lc2487_RemoveNodesFromLinkedList {

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

    // to reverse the linked list
    public static ListNode reverseList (ListNode node, ListNode pre) {
        if (node == null) return pre;
        ListNode temp = node.next;
        node.next = pre;
        return reverseList(temp, node);
    }

    // approach 1 - using stack
    public ListNode removeNodes1(ListNode head) {
        Stack<ListNode> st = new Stack<>();
        ListNode curr = head;

        while (curr != null) {
            st.push(curr);
            curr = curr.next;
        }

        curr = st.pop();
        int maxNode = curr.val;


        ListNode ans = new ListNode(curr.val, null);

        while (!st.isEmpty()) {
            curr = st.pop();

            if (curr.val < maxNode) {
                continue; // skip this node
            } else {
                ListNode newNode = new ListNode(curr.val, ans);
                ans = newNode;
                maxNode = curr.val;
            }
        }
        return ans;
    }

    // approach 2 - using recursion
    public ListNode removeNodes2(ListNode head) {
        if (head == null || head.next == null) {
            return  head;
        }

        ListNode nextNode = removeNodes2(head.next);

        if (head.val < nextNode.val) {
            return nextNode;
        }

        head.next = nextNode;
        return head;
    }

    // approach 3 - reversing the linked list
    public ListNode removeNodes3(ListNode head) {
        head = reverseList(head, null);

        int maxNode = -1;
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            maxNode = Math.max(maxNode, curr.val);
            if (curr.val < maxNode) {
                prev.next = curr.next;

                // garbage collection takes care but still a good practice
                ListNode temp = curr; // to be deleted
                temp = null;

                curr = curr.next;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }
        return reverseList(head, null);
    }

    // Main function for testing
    public static void main(String[] args) {
        lc2487_RemoveNodesFromLinkedList obj = new lc2487_RemoveNodesFromLinkedList();
        int[] arr = {5, 2, 13, 3, 8};

        // approach 1 - using stack
        ListNode head = createLLFromArray(arr);
        printLL(head);

        ListNode ans = obj.removeNodes1(head);
        printLL(ans);

        // approach 2 - using recursion
        System.out.println();
        ListNode head2 = createLLFromArray(arr);
        printLL(head2);

        ListNode ans2 = obj.removeNodes2(head);
        printLL(ans2);

        // approach 3 - reversing the linked list
        System.out.println();
        ListNode head3 = createLLFromArray(arr);
        printLL(head3);

        ListNode ans3 = obj.removeNodes3(head);
        printLL(ans3);
    }
}
