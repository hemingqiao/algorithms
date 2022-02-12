package src.leetcodeweeklycontest.c243;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/05/30 12:01:21
 * description:
 * 给你一个非常大的整数 n 和一个整数数字 x ，大整数 n 用一个字符串表示。n 中每一位数字和数字 x 都处于闭区间 [1, 9] 中，且 n 可能表示一个 负数 。
 *
 * 你打算通过在 n 的十进制表示的任意位置插入 x 来 最大化 n 的 数值 ​​​​​​。但 不能 在负号的左边插入 x 。
 *
 * 例如，如果 n = 73 且 x = 6 ，那么最佳方案是将 6 插入 7 和 3 之间，使 n = 763 。
 * 如果 n = -55 且 x = 2 ，那么最佳方案是将 2 插在第一个 5 之前，使 n = -255 。
 * 返回插入操作后，用字符串表示的 n 的最大值。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = "99", x = 9
 * 输出："999"
 * 解释：不管在哪里插入 9 ，结果都是相同的。
 * 示例 2：
 *
 * 输入：n = "-13", x = 2
 * 输出："-123"
 * 解释：向 n 中插入 x 可以得到 -213、-123 或者 -132 ，三者中最大的是 -123 。
 *  
 *
 * 提示：
 *
 * 1 <= n.length <= 10^5
 * 1 <= x <= 9
 * n​​​ 中每一位的数字都在闭区间 [1, 9] 中。
 * n 代表一个有效的整数。
 * 当 n 表示负数时，将会以字符 '-' 开始。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-value-after-insertion
 *
 */
public class Two {
    public String maxValue(String n, int x) {
        // 如果n是一个正数，那就需要尽可能保留较大的高位，才能使得最终的结果尽可能大，所以是
        // 从左向右枚举，找到第一个小于或等于x的位置，把x插入到这个位置
        // 反之，如果n是一个负数，那就是需要使得n的绝对值尽可能的小，才能使得最总的结果尽可能的大，所以
        // 和上面正数的情况正好相反，需要尽可能保留较小的高位，所以是从左向右枚举，找到第一个大于等于x的位置
        // 把x插入到这个位置
        char[] chars = n.toCharArray();
        int len = chars.length;
        if (chars[0] == '-') {
            int k = 1;
            while (k < len && chars[k] - '0' <= x) k++;
            return n.substring(0, k) + x + n.substring(k);
        } else {
            int k = 0;
            while (k < len && chars[k] - '0' >= x) k++;
            return n.substring(0, k) + x + n.substring(k);
        }
    }
}
