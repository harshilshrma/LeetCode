// Date: July 07, 2023
// Q: Design an algorithm to encode a list of string. The encoded string is then sent over the network and is decoded
// back to the original list of strings.
// Please implement encode and decode.

package PremiumQuestions;
import java.util.ArrayList;
import java.util.List;

public class lc0271_EncodeNDecodeStrings {
    public String encode(List<String> strs) {
        StringBuilder encodedString = new StringBuilder();
        for (String s: strs) {
            encodedString.append(s.length()).append("#").append(s);
        }
        return encodedString.toString();
    }
    public List<String> decode(String str) {
        List<String> list = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') j++;
            int length  = Integer.parseInt(str.substring(i, j));
            i = j + 1 + length;
            list.add(str.substring(j + 1, i));
        }
        return list;
    }

    // Main function for testing
    public static void main(String[] args) {
        lc0271_EncodeNDecodeStrings obj1 = new lc0271_EncodeNDecodeStrings();
        List<String> strs = new ArrayList<>();
        strs.add("#hello");
        strs.add("my");
        strs.add("name");
        strs.add("is");
        strs.add("meow");
        System.out.println(obj1.encode(strs));
        System.out.println(obj1.decode(obj1.encode(strs)));
    }
}