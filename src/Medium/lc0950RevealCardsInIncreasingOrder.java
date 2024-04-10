// 10 April 2024
// You are given an integer array deck. There is a deck of cards where every card has a unique integer.
// The integer on the ith card is deck[i].
//
//You can order the deck in any order you want. Initially, all the cards start face down (unrevealed) in one deck.
//
//You will do the following steps repeatedly until all cards are revealed:
//
//Take the top card of the deck, reveal it, and take it out of the deck.
//If there are still cards in the deck then put the next top card of the deck at the bottom of the deck.
//If there are still unrevealed cards, go back to step 1. Otherwise, stop.
//Return an ordering of the deck that would reveal the cards in increasing order.
//
//Note that the first entry in the answer is considered to be the top of the deck.

package Medium;

import java.util.Arrays;

public class lc0950RevealCardsInIncreasingOrder {

    public int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        int[] res = new int[n]; // Result array to store the revealed deck
        Arrays.sort(deck); // Sort the original deck in increasing order

        boolean skip = false; // Flag to track whether to skip placing a card in the result array
        int i = 0; // Pointer for iterating through the sorted deck array
        int j = 0; // Pointer for placing cards in the result array

        while (i < n) {
            // If the current position in the result array is empty
            if (res[j] == 0) {
                // If skip is false, place the next card from the sorted deck array into the result array
                if (!skip) {
                    res[j] = deck[i];
                    i++; // Move to the next card in the sorted deck array
                }
                skip = !skip; // Toggle the skip flag for the next iteration
            }
            j = (j + 1) % n; // Move to the next position in the result array (circular)
        }
        return res; // Return the revealed deck
    }

    // Main function for testing
    public static void main(String[] args) {
        lc0950RevealCardsInIncreasingOrder obj = new lc0950RevealCardsInIncreasingOrder();
        int[] deck = {17, 13, 11, 2, 3, 5, 7};
        System.out.println(Arrays.toString(obj.deckRevealedIncreasing(deck)));
    }

}
