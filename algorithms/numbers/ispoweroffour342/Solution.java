package blogandquestion.algorithms.numbers.ispoweroffour342;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/18 16:46:00
 * description:
 * 给定一个整数，写一个函数来判断它是否是 4 的幂次方。如果是，返回 true ；否则，返回 false 。
 *
 * 整数 n 是 4 的幂次方需满足：存在整数 x 使得 n == 4x
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 16
 * 输出：true
 * 示例 2：
 *
 * 输入：n = 5
 * 输出：false
 * 示例 3：
 *
 * 输入：n = 1
 * 输出：true
 *  
 *
 * 提示：
 *
 * -2^31 <= n <= 2^31 - 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/power-of-four
 *
 */
public class Solution {
    // 数学公式解法
    public boolean isPowerOfFour(int n) {
        if (n == 0) return false;
        return (Math.log10(n) / Math.log10(4)) % 1 == 0;
    }

    /**
     * 常规思路
     * @param n
     * @return
     */
    public boolean isPowerOfFourNormal(int n) {
        // 一个数可以表示为4的多少次幂，一定可以表示为2的偶数次幂
        if (n == 0) return false;
        int count = 0;
        int temp = n;
        while (temp % 2 == 0) {
            temp /= 2;
            count++;
        }
        return count % 2 == 0 && Math.pow(2, count) == n;
    }
}
