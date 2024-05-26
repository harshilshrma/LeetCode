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
    private void reverse(char[] array, int start, int end) {
        while (start < end) {
            char temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }

    public String reverseWords(String s) {
        // Convert the string to a mutable character array
        char[] strArray = s.toCharArray();

        // Reverse the whole string
        reverse(strArray, 0, strArray.length - 1);

        int i = 0;
        int l = 0, r = 0;
        int n = strArray.length;

        while (i < n) {
            // Move r and i forward until we find a space
            while (i < n && strArray[i] != ' ') {
                strArray[r++] = strArray[i++];
            }

            // If we have characters between l and r, reverse the word
            if (l < r) {
                reverse(strArray, l, r - 1);
                // Check if r is within bounds before assigning a space
                if (r < n) {
                    strArray[r] = ' ';
                    r++;
                }
                l = r;
            }

            i++;
        }

        // Create the final string without trailing spaces
        return new String(strArray, 0, r > 0 ? r - 1 : 0);
    }


    // Main function for testing
    public static void main(String[] args) {
        lc0151_ReverseWordsInAString obj = new lc0151_ReverseWordsInAString();
        System.out.println(obj.reverseWords(" the sky is blue "));
    }
}



