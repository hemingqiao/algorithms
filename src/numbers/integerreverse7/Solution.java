package src.integerreverse7;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/03 15:10:58
 * description:
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 * 注意:
 *
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 *
 *
 * see: https://github.com/yuanguangxin/LeetCode/blob/master/src/%E6%95%B0%E5%AD%97%E6%93%8D%E4%BD%9C/q7_%E6%95%B4%E6%95%B0%E5%8F%8D%E8%BD%AC/f2/Solution.java
 */
public class Solution {
    public int reverse(int num) {
        int res = 0;
        while (true) {
            int y = num % 10;
            num /= 10;
            // 判断整型是否溢出
            if (res * 10 / 10 != res) return 0;
            res = res * 10 + y;
            if (num == 0) break;
        }

        return res;
    }

    public int reverse1(int num) {
        int res = 0;
        // 因为num可能是负数，所以判断条件是不等于0而不是大于0
        while (num != 0) {
            int y = num % 10;
            num /= 10;
            // 判断整型是否溢出
            if (res * 10 / 10 != res) return 0;
            res = res * 10 + y;
        }
        return res;
    }
}
