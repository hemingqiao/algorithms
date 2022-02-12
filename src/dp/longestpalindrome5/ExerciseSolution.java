package src.dp.longestpalindrome5;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/10 19:09:41
 * description: 中心扩散法
 */
public class ExerciseSolution {
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len <= 2) return s;
        String res = s.substring(0, 1);
        int maxLen = 0;
        for (int i = 0; i < len - 1; i++) {
            String evenStr = getPalindromeStr(s, i, i + 1, len);
            String oddStr = getPalindromeStr(s, i, i, len);
            String maxLenStr = evenStr.length() > oddStr.length() ? evenStr : oddStr;
            if (maxLenStr.length() > maxLen) {
                maxLen = maxLenStr.length();
                res = maxLenStr;
            }
        }
        return res;
    }

    private String getPalindromeStr(String s, int left, int right, int len) {
        int l = left, r = right;
        while (l >= 0 && r < len) {
            if (s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            } else {
                break;
            }
        }
        return s.substring(++l, r);
    }
}
