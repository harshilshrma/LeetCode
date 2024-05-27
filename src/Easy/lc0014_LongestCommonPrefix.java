// 26-05-2024 - 11:38 pm
// Write a function to find the longest common prefix string amongst an array of strings.
//
//If there is no common prefix, return an empty string "".

package Easy;

public class lc0014_LongestCommonPrefix {
    // Functions
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";

        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }

        return prefix;
    }

    // Main function for testing
    public static void main(String[] args) {
        lc0014_LongestCommonPrefix obj = new lc0014_LongestCommonPrefix();
        System.out.println(obj.longestCommonPrefix(new String[] {"flower","flow","floight"}));
    }
}



