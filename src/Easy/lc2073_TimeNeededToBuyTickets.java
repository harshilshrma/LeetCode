// 9 April 2024
// There are n people in a line queuing to buy tickets, where the 0th person is at the front of the line and
// the (n - 1)th person is at the back of the line.
//
//You are given a 0-indexed integer array tickets of length n where the number of tickets that the ith person
// would like to buy is tickets[i].
//
//Each person takes exactly 1 second to buy a ticket. A person can only buy 1 ticket at a time and has to go
// back to the end of the line (which happens instantaneously) in order to buy more tickets. If a person does not
// have any tickets left to buy, the person will leave the line.
//
//Return the time taken for the person at position k (0-indexed) to finish buying tickets.

package Easy;

public class lc2073_TimeNeededToBuyTickets {

    public int timeRequiredToBuy(int[] tickets, int k) {
        int res = 0;

        // Iterate through the queue
        for (int i = 0; i < tickets.length; i++) {
            // If the person is before or at position k
            if (i <= k) {
                // Add the minimum of tickets[i] and tickets[k] to the result
                res += Math.min(tickets[i], tickets[k]);
            } else {
                // If the person is after position k, add the minimum of (tickets[k] - 1) and tickets[i] to the result
                res += Math.min(tickets[k] - 1, tickets[i]);
            }
        }

        return res; // Return the total time
    }

    // Main function for testing
    public static void main(String[] args) {
        lc2073_TimeNeededToBuyTickets obj = new lc2073_TimeNeededToBuyTickets();
        int[] tickets = {2, 3, 2};
        int k = 2;
        System.out.println(obj.timeRequiredToBuy(tickets, k));
    }
}
