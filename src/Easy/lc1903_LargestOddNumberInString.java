// 26-05-2024 - 11:03 pm
// 

package Easy;

public class lc1903_LargestOddNumberInString {
    // Functions

    // for a number to be odd, we aim to have its rightmost digit as odd so we start from right, to get max value
    public String largestOddNumber(String num) {
        for (int i = num.length() - 1; i >= 0; i--) {
            if (Character.getNumericValue(num.charAt(i)) % 2 != 0) {
                return num.substring(0, i + 1);
            }
        }

        return "";
    }

    // Main function for testing
    public static void main(String[] args) {
        lc1903_LargestOddNumberInString obj = new lc1903_LargestOddNumberInString();
        System.out.println(obj.largestOddNumber("7542351161"));
    }
}



