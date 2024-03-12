// Date: 12 March 2024
// Given the head of a linked list, we repeatedly delete consecutive sequences of nodes that sum to 0 until
// there are no such sequences.

//After doing so, return the head of the final linked list.  You may return any such answer.
//(Note that in the examples below, all sequences are serializations of ListNode objects.)


package Medium;

import java.util.HashMap;

public class lc1171_RemoveZeroSumConsecutiveNodesFromLL {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode removeZeroSumSublists(ListNode head) {
        int prefixSum = 0;
        HashMap<Integer, ListNode> map = new HashMap<>();

        ListNode dummy = new ListNode(0, head);
        dummy.next = head;
        map.put(0, dummy);

        while (head != null) {
            prefixSum += head.val;

            if (map.containsKey(prefixSum)) {
                ListNode p = map.get(prefixSum);
                ListNode start = p;
                int pSum = prefixSum;

                while (start != head) {
                    start = start.next;
                    pSum += start.val;
                    if (start != head) {
                        map.remove(pSum);
                    }
                }

                p.next = start.next;

            } else {
                map.put(prefixSum, head);
            }

            head = head.next;
        }

        return dummy.next;
    }
}
