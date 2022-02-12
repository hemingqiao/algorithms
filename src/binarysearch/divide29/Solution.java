package src.binarysearch.divide29;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/21 14:27:23
 * description:
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 *
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 *
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 *
 *  
 *
 * 示例 1:
 *
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
 * 示例 2:
 *
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * 解释: 7/-3 = truncate(-2.33333..) = -2
 *  
 *
 * 提示：
 *
 * 被除数和除数均为 32 位有符号整数。
 * 除数不为 0。
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/divide-two-integers
 *
 */
public class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        long m = Math.abs((long) dividend), n = Math.abs((long)divisor);
        int sign = -1;
        if (dividend > 0 && divisor > 0 || dividend < 0 && divisor < 0) {
            sign = 1;
        }
        if (n == 1) return (int) (sign == 1 ? m : -m);
        long res = 0;
        while (m >= n) {
            long temp = n, p = 1;
            while (m >= (temp << 1)) {
                temp <<= 1;
                p <<= 1;
            }
            res += p;
            m -= temp;
        }
        return (int) (sign == 1 ? res : -res);
    }

    public static void main(String[] args) {
        int test = -2147483648;
        int divisor = 2;
        Solution s = new Solution();
        int res = s.divide(test, divisor);
        System.out.println(res);
    }
}
