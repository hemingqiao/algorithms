package src.string.atoi8;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/04 17:44:36
 * description:
 * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
 *
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。接下来的转化规则如下：
 *
 * 如果第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字字符组合起来，形成一个有符号整数。
 * 假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成一个整数。
 * 该字符串在有效的整数部分之后也可能会存在多余的字符，那么这些字符可以被忽略，它们对函数不应该造成影响。
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换，即无法进行有效转换。
 *
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0 。
 *
 * 提示：
 *
 * 本题中的空白字符只包括空格字符 ' ' 。
 * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−2^31,  2^31 − 1]。如果数值超过这个范围，请返回  INT_MAX (2^31 − 1) 或 INT_MIN (−2^31) 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/string-to-integer-atoi
 *
 * see: https://leetcode-cn.com/problems/string-to-integer-atoi/solution/java-zi-fu-chuan-zhuan-zheng-shu-hao-dong-by-sweet/326032
 */
public class Solution {
    public int myAtoi(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int MAX = Integer.MAX_VALUE;
        int MIN = Integer.MIN_VALUE;

        int res = 0;
        int index = 0;

        // 过滤空格
        while (index < s.length() && s.charAt(index) == ' ') {
            index++;
        }

        if (index == s.length()) return 0;

        // 判断正负号
        char signChar = s.charAt(index);
        boolean positive = true;
        if (!Character.isDigit(signChar)) {
            if (signChar != '-' && signChar != '+') {
                return 0;
            }
            index++;
            positive = signChar != '-';
        }

        // 用负数保存正负数的边界。如果转成正数，负数的最小值-2147483648会超过正数的最大值2147483647
        // 正数：-2147483647
        // 负数：-2147483648
        int limit = positive ? (-MAX) : MIN;

        // 过滤0
        // 不过滤也可以
        while (index < s.length() && s.charAt(index) == '0') {
            index++;
        }

        // 取每一位，在非数字处截止
        while (index < s.length() && Character.isDigit(s.charAt(index))) {
            int digit = s.charAt(index++) - '0';
            // 判断是否溢出
            // res * 10 - digit < limit
            if (res < ((limit + digit) / 10)) {
                return positive ? MAX : MIN; // 返回对应的边界值
            }
            // 此处res >= limit
            res = res * 10 - digit;
        }
        return positive ? -res : res;
    }

    public static void main(String[] args) {
        int result = new Solution().myAtoi("42");
        System.out.println(result);
    }
}
