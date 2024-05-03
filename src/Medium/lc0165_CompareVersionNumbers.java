// 3 May 2024
// Given two version numbers, version1 and version2, compare them.
//
//Version numbers consist of one or more revisions joined by a dot '.'. Each revision consists of digits and may
// contain leading zeros. Every revision contains at least one character. Revisions are 0-indexed from left to right,
// with the leftmost revision being revision 0, the next revision being revision 1, and so on. For example 2.5.33
// and 0.1 are valid version numbers.
//
//To compare version numbers, compare their revisions in left-to-right order. Revisions are compared using their
// integer value ignoring any leading zeros. This means that revisions 1 and 001 are considered equal. If a version
// number does not specify a revision at an index, then treat the revision as 0. For example, version 1.0 is less
// than version 1.1 because their revision 0s are the same, but their revision 1s are 0 and 1 respectively, and 0 < 1.

package Medium;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class lc0165_CompareVersionNumbers {

    // Tokenizes the version string by splitting it at '.' and returns the tokens as a list.
    public List<String> getTokens(String version) {
        StringTokenizer tokenizer = new StringTokenizer(version, ".");
        List<String> list = new ArrayList<>();
        // Iterates through the tokens and adds them to the list.
        while (tokenizer.hasMoreTokens()) {
            list.add(tokenizer.nextToken());
        }
        return list;
    }

    // Compares two version strings and returns:
    //  1 if version1 > version2
    // -1 if version1 < version2
    //  0 if version1 == version2
    public int compareVersion(String version1, String version2) {
        List<String> v1 = getTokens(version1); // Tokens of version1
        List<String> v2 = getTokens(version2); // Tokens of version2

        int m = v1.size(); // Number of tokens in version1
        int n = v2.size(); // Number of tokens in version2

        int i = 0;
        // Compare tokens of version1 and version2 until the end of either list is reached
        while (i < m || i < n) {
            // Get the integer value of token i in version1, default to 0 if i exceeds the list size
            int a = i < m ? Integer.parseInt(v1.get(i)) : 0;
            // Get the integer value of token i in version2, default to 0 if i exceeds the list size
            int b = i < n ? Integer.parseInt(v2.get(i)) : 0;

            // Compare the integer values of tokens
            if (a > b) {
                return 1; // version1 is greater
            } else if (a < b) {
                return -1; // version2 is greater
            } else {
                i++; // Move to the next token if both tokens are equal
            }
        }
        return 0; // Both versions are equal
    }


    // Main function for testing
    public static void main(String[] args) {
        lc0165_CompareVersionNumbers obj = new lc0165_CompareVersionNumbers();
        String version1 = "1.01", version2 = "1.001";
        System.out.println(obj.compareVersion(version1, version2));
    }
}
