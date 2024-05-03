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

    public List<String> getTokens(String version) {
        StringTokenizer tokenizer = new StringTokenizer(version, ".");
        List<String> list = new ArrayList<>();
        while (tokenizer.hasMoreTokens()) {
            list.add(tokenizer.nextToken());
        }
        return list;
    }

    public int compareVersion(String version1, String version2) {
        List<String> v1 = getTokens(version1);
        List<String> v2 = getTokens(version2);

        int m = v1.size();
        int n = v2.size();

        int i = 0;
        while (i < m || i < n) {
            int a = i < m ? Integer.parseInt(v1.get(i)) : 0;
            int b = i < n ? Integer.parseInt(v2.get(i)) : 0;

            if (a > b) {
                return 1;
            } else if (a < b) {
                return -1;
            } else {
                i++;
            }
        }
        return 0;
    }

    // Main function for testing
    public static void main(String[] args) {
        lc0165_CompareVersionNumbers obj = new lc0165_CompareVersionNumbers();
        String version1 = "1.01", version2 = "1.001";
        System.out.println(obj.compareVersion(version1, version2));
    }
}
