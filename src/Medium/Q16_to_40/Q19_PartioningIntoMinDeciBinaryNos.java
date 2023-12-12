// Date: 15 March 2023
// A decimal number is called deci-binary if each of its digits is either 0 or 1 without any leading zeros.
// For example, 101 and 1100 are deci-binary, while 112 and 3001 are not.
// Given a string n that represents a positive decimal integer, return the minimum number of positive
// deci-binary numbers needed so that they sum up to n.

package Medium.Q16_to_40;
public class Q19_PartioningIntoMinDeciBinaryNos {
    public int minPartitions(String n) {
        int max=0;
        for (int i=0; i<n.length(); i++){
            max = Math.max(max, n.charAt(i)-'0');
        }
        return max;
    }
}

