// 5 May 2024
// There is a singly-linked list head and we want to delete a node node in it.
//
//You are given the node to be deleted node. You will not be given access to the first node of head.
//
//All the values of the linked list are unique, and it is guaranteed that the given node node is not the last
// node in the linked list.
//
//Delete the given node. Note that by deleting the node, we do not mean removing it from memory. We mean:
//
//The value of the given node should not exist in the linked list.
//The number of nodes in the linked list should decrease by one.
//All the values before node should be in the same order.
//All the values after node should be in the same order.
//Custom testing:
//
//For the input, you should provide the entire linked list head and the node to be given node. node should not
// be the last node of the list and should be an actual node in the list.
//We will build the linked list and pass the node to your function.
//The output will be the entire list after calling your function.

package Medium;

public class lc0237_DeleteNodeInALinkedList {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public void deleteNode(ListNode node) {
        ListNode prev = null;
        while (node != null && node.next != null) {
            node.val = node.next.val;
            prev = node;
            node = node.next;
        }
        prev.next = null;
    }

    public static void printLinkedList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static ListNode createLinkedListFromArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        ListNode dummy = new ListNode(0, null); // Dummy node to simplify insertion
        ListNode current = dummy;

        for (int num : arr) {
            current.next = new ListNode(num, current.next);
            current = current.next;
        }

        return dummy.next; // Skip the dummy node and return the actual head
    }

    // Main function for testing
    public static void main(String[] args) {
        lc0237_DeleteNodeInALinkedList obj = new lc0237_DeleteNodeInALinkedList();
        int[] arr = {4, 5, 1, 9};
        ListNode head = createLinkedListFromArray(arr);
        printLinkedList(head);

        ListNode nodeToDelete = head;
        while (nodeToDelete != null && nodeToDelete.val != 5) {
            nodeToDelete = nodeToDelete.next;
        }

        obj.deleteNode(nodeToDelete);

        printLinkedList(head);
    }
}
