// 24-05-2024 - 02:45 pm
// Given an input string s, reverse the order of the words.
//
//A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
//
//Return a string of the words in reverse order concatenated by a single space.
//
//Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string
// should only have a single space separating the words. Do not include any extra spaces.

package Medium;

public class lc0151_ReverseWordsInAString {
    // Functions
    public String reverseWords(String s) {
        // Convert the string to a character array
        char[] chars = s.toCharArray();

        // Step 1: Reverse the entire string
        reverse(chars, 0, chars.length - 1);

        // Step 2: Reverse each word in the reversed string
        reverseEachWord(chars);

        // Step 3: Clean up spaces
        return cleanSpaces(chars);
    }

    private void reverse(char[] chars, int left, int right) {
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }

    private void reverseEachWord(char[] chars) {
        int n = chars.length;
        int start = 0, end = 0;

        while (start < n) {
            // Move the end pointer to the end of the current word
            while (end < n && chars[end] != ' ') {
                end++;
            }

            // Reverse the current word
            reverse(chars, start, end - 1);

            // Move the start pointer to the next word
            start = end + 1;
            end++;
        }
    }

    private String cleanSpaces(char[] chars) {
        int n = chars.length;
        int i = 0, j = 0;

        while (j < n) {
            // Skip spaces
            while (j < n && chars[j] == ' ') {
                j++;
            }
            // Copy non-space characters
            while (j < n && chars[j] != ' ') {
                chars[i++] = chars[j++];
            }
            // Skip spaces
            while (j < n && chars[j] == ' ') {
                j++;
            }
            // Add a single space if not at the end
            if (j < n) {
                chars[i++] = ' ';
            }
        }

        // Create the final string and trim any extra spaces
        return new String(chars).substring(0, i);
    }


    // Main function for testing
    public static void main(String[] args) {
        lc0151_ReverseWordsInAString obj = new lc0151_ReverseWordsInAString();
        System.out.println(obj.reverseWords(" hello world "));
        System.out.println(obj.reverseWords("the sky is blue"));
        System.out.println(obj.reverseWords("a good   example"));
    }
}



