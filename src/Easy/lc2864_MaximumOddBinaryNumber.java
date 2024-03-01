// Date: 1 March 2024
// You are given a binary string s that contains at least one '1'.
//You have to rearrange the bits in such a way that the resulting binary number is the maximum odd binary
// number that can be created from this combination.
//Return a string representing the maximum odd binary number that can be created from the given combination.
//Note that the resulting string can have leading zeros.

package Easy;

public class lc2864_MaximumOddBinaryNumber {
    public String maximumOddBinaryNumber(String s) {
        // Get the length of the input string
        int n = s.length();

        // Create a StringBuilder initialized with '0's of length n
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < n; k++) {
            sb.append('0');
        }

        // Initialize the index variable i
        int i = 0;

        // Iterate through each character in the input string
        for (char ch : s.toCharArray()) {
            // If the current character is '1'
            if (ch == '1') {
                // If the last character of the StringBuilder is '1'
                if (sb.charAt(n - 1) == '1') {
                    // Set the character at index i to '1' and increment i
                    sb.setCharAt(i, '1');
                    i++;
                } else {
                    // Otherwise, set the last character of the StringBuilder to '1'
                    sb.setCharAt(n - 1, '1');
                }
            }
        }

        // Return the maximum odd binary number as a string
        return sb.toString();
    }

    public static void main(String[] args) {
        lc2864_MaximumOddBinaryNumber obj = new lc2864_MaximumOddBinaryNumber();
        String s = "010";
        System.out.println(obj.maximumOddBinaryNumber(s));
    }
}
