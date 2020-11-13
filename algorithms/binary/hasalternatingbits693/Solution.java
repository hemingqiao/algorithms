package blogandquestion.algorithms.binary.hasalternatingbits693;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/13 17:27:03
 * description:
 * 给定一个正整数，检查它的二进制表示是否总是 0、1 交替出现：换句话说，就是二进制表示中相邻两位的数字永不相同。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 5
 * 输出：true
 * 解释：5 的二进制表示是：101
 * 示例 2：
 *
 * 输入：n = 7
 * 输出：false
 * 解释：7 的二进制表示是：111.
 * 示例 3：
 *
 * 输入：n = 11
 * 输出：false
 * 解释：11 的二进制表示是：1011.
 * 示例 4：
 *
 * 输入：n = 10
 * 输出：true
 * 解释：10 的二进制表示是：1010.
 * 示例 5：
 *
 * 输入：n = 3
 * 输出：false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-number-with-alternating-bits
 *
 * 参考
 * https://leetcode-cn.com/problems/binary-number-with-alternating-bits/solution/tao-pan-feng-bian-li-liang-liang-bi-jiao-wei-yun-s/
 */
public class Solution {
    public boolean hasAlternatingBits(int n) {
        // 初始化prev为n的最后一位
        int prev = n & 1;
        while (n != 0) {
            // n右移一位
            n  = n >> 1;
            // cur为右移一位后n的最后一位
            int cur = n & 1;
            // 如果两者相等，直接返回false
            if (prev == cur) return false;
            // 否则，cur的值赋给prev，继续循环
            prev = cur;
        }
        return true;
    }
}

class AnotherSolution {
    // 如果n是交替位二进制数，则n与n右移一位的数进行异或运算后，有效二进制位一定都是1
    // 如果n不是交替位二进制数，则n与n右移一位的数进行异或运算后，有效二进制位一定包括0
    // 而一个数字m的二进制位是否全为1等价于 m & (m + 1) == 0
    public boolean hasAlternatingBits(int n) {
        int temp = n ^ (n >> 1);
        return (temp & (temp + 1)) == 0;
    }
}
