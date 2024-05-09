// 9 may 2024
// You are given an array happiness of length n, and a positive integer k.
//
//There are n children standing in a queue, where the ith child has happiness value happiness[i].
// You want to select k children from these n children in k turns.
//
//In each turn, when you select a child, the happiness value of all the children that have not been selected
// till now decreases by 1. Note that the happiness value cannot become negative and gets decremented only
// if it is positive.
//
//Return the maximum sum of the happiness values of the selected children you can achieve by selecting k children.

package Medium;

import java.util.Collections;
import java.util.PriorityQueue;

public class lc3075_MaximizeHappinessOfSelectedChildren {
    public long maximumHappinessSum(int[] happiness, int k) {
        long ans = 0;
        int count = 0;

        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for (int i : happiness) {
            q.offer(i);
        }
        System.out.println(q);

        for (int i = 0; i < k; i++) {
            ans += Math.max(q.poll() - count , 0);
            count++;
        }

        return ans;
    }

    //Main function for testing
    public static void main(String[] args) {
        lc3075_MaximizeHappinessOfSelectedChildren obj = new lc3075_MaximizeHappinessOfSelectedChildren();
        int[] happiness = {2, 3, 4, 5};
        int k = 2;
        System.out.println(obj.maximumHappinessSum(happiness, k));
    }
}
