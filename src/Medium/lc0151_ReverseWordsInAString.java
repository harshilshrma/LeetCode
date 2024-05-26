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
        int left = 0;
        int right = s.length() - 1;

        String temp = "";
        String ans = "";

        //Iterate the string and keep on adding to form a word
        //If empty space is encountered then add the current word to the result
        while (left <= right)
        {
            char ch = s.charAt(left);
            if (ch != ' ')
            {
                temp += ch;
            }
            else {
                if (!ans.equals(""))
                {
                    ans = temp + " " + ans;
                }
                else
                {
                    ans = temp;
                }
                temp = "";
            }
            left++;
        }

        //If not empty string then add to the result(Last word is added)
        if (!temp.equals(""))
        {
            if (!ans.equals(""))
            {
                ans = temp + " " + ans;
            }
            else
            {
                ans = temp;
            }
        }

        return ans;
    }


    // Main function for testing
    public static void main(String[] args) {
        lc0151_ReverseWordsInAString obj = new lc0151_ReverseWordsInAString();
        System.out.println(obj.reverseWords(" the sky is blue "));
    }
}



