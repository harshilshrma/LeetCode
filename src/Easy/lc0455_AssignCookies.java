// Date: 3 December 2024
// Assume you are an awesome parent and want to give your children some cookies. But, you should give each child at
// most one cookie.
//Each child i has a greed factor g[i], which is the minimum size of a cookie that the child will be content with;
// and each cookie j has a size s[j]. If s[j] >= g[i], we can assign the cookie j to the child i, and the child i
// will be content. Your goal is to maximize the number of your content children and output the maximum number.

package Easy;

import java.util.Arrays;

public class lc0455_AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int contentChildren = 0;
        int cookieIndex = 0;
        while (cookieIndex < s.length && contentChildren < g.length){
            if (s[cookieIndex] >= g[contentChildren]) {
                contentChildren++;
            }
            cookieIndex++;
        }
        return contentChildren;
    }

    public static void main(String[] args) {
        lc0455_AssignCookies obj = new lc0455_AssignCookies();
        int[] g = {1,2,3};
        int[] s = {1,1};
        System.out.println(obj.findContentChildren(g, s));
    }
}
