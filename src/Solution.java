package src;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/06 08:57:59
 * description:
 */
public class Solution {
    public int atoi(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int MAX = Integer.MAX_VALUE;
        int MIN = Integer.MIN_VALUE;

        int res = 0;
        int index = 0;

        // 去除空格
        while (index < s.length() && s.charAt(index) == ' ') {
            index++;
        }

        if (index == s.length()) return 0;

        char signChar = s.charAt(index);
        boolean positive = true;
        if (!Character.isDigit(signChar)) {
            if (signChar != '-' && signChar != '+') {
                return 0;
            }

            // 跳过符号位
            index++;
            positive = signChar != '-';
        }

        int limit = positive ? (-MAX) : MIN;
        // 过滤前导的0，不过滤其实也行
        while (index < s.length() && s.charAt(index) == '0') {
            index++;
        }

        while (index < s.length() && Character.isDigit(s.charAt(index))) {
            int digit = s.charAt(index++) - '0';
            if (res < (limit + digit) / 10) {
                return positive ? MAX : MIN;
            }
            res = res * 10 - digit;
        }

        return positive ? -res : res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int result = s.atoi("  -7788856982258722592586");
        System.out.println(result);
    }
}
