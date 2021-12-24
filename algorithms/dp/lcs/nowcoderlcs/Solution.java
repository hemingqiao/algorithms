package blogandquestion.algorithms.dp.lcs.nowcoderlcs;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/04/28 14:51:32
 * description:
 */
public class Solution {
    /**
     * longest common substring
     * @param str1 string字符串 the string
     * @param str2 string字符串 the string
     * @return string字符串
     */
    public String LCS (String str1, String str2) {
        // write code here
        int n1 = str1.length(), n2 = str2.length();
        int maxLen = Integer.MIN_VALUE;
        int index = -1;
        for (int i = 0; i < n1; i++) {
            for (int j = i + 1; j <= n1; j++) {
                if (str2.contains(str1.substring(i, j))) {
                    if (maxLen < j - i) {
                        maxLen = j - i;
                        index = i;
                    }
                } else {
                    break;
                }
            }
        }
        if (maxLen == Integer.MIN_VALUE) return "-1";
        return str1.substring(index, maxLen + index);
    }

    public static void main(String[] args) {
        String test = "12345";
        System.out.println(test.substring(0, 4));
    }
}
