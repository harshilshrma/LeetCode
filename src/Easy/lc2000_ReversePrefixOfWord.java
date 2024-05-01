// 1 May 2024
// Given a 0-indexed string word and a character ch, reverse the segment of word that starts at index 0 and
// ends at the index of the first occurrence of ch (inclusive). If the character ch does not exist in word,
// do nothing.
//
//For example, if word = "abcdefd" and ch = "d", then you should reverse the segment that starts at 0 and ends at
// 3 (inclusive). The resulting string will be "dcbaefd".
//Return the resulting string.

package Easy;

public class lc2000_ReversePrefixOfWord {
    public String reversePrefix(String word, char ch) {
        StringBuilder st = new StringBuilder();
        int targetIdx = 0;

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == ch) {
                targetIdx = i;
                break;
            }
        }

        for (int i = targetIdx; i >= 0; i--) {
            st.append(word.charAt(i));
        }

        for (int i = targetIdx + 1; i < word.length(); i++) {
            st.append(word.charAt(i));
        }

        return st.toString();
    }

    public String reversePrefixOPT(String word, char ch) {
        int firstOccurence = word.indexOf(ch);
        if (firstOccurence == -1) {
            return word;
        }

        StringBuilder prefix = new StringBuilder(word.substring(0, firstOccurence + 1));
        return prefix.reverse() + word.substring(firstOccurence + 1);
    }


    // Main function for testing
    public static void main(String[] args) {
        lc2000_ReversePrefixOfWord obj = new lc2000_ReversePrefixOfWord();
        String word = "abcdefd";
        char ch = 'd';
        System.out.println(obj.reversePrefix(word, ch));
        System.out.println(obj.reversePrefixOPT(word, ch));
    }
}
