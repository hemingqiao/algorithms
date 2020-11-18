package blogandquestion.algorithms.numbers.ispowerofthree326;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/18 15:21:13
 * description:
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。如果是，返回 true ；否则，返回 false 。
 *
 * 整数 n 是 3 的幂次方需满足：存在整数 x 使得 n == 3x
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 27
 * 输出：true
 * 示例 2：
 *
 * 输入：n = 0
 * 输出：false
 * 示例 3：
 *
 * 输入：n = 9
 * 输出：true
 * 示例 4：
 *
 * 输入：n = 45
 * 输出：false
 *  
 *
 * 提示：
 *
 * -2^31 <= n <= 2^31 - 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/power-of-three
 *
 */
public class Solution {
    public boolean isPowerOfThree(int n) {
        // 特判0
        if (n == 0) return false;
        int m = (int)Math.floor(Math.log10(n) / Math.log10(3));
        return Math.pow(3, m) == n;
    }

    /**
     * 对上面公式的优化
     * @param n
     * @return
     */
    public boolean isPowerOfThreeOpt(int n) {
        if (n == 0) return false;
        return (Math.log10(n) / Math.log10(3)) % 1 == 0;
    }

    /**
     * 常规解法
     * @param n
     * @return
     */
    public boolean isPowerOfThreeOpt1(int n) {
        if (n < 0) return false;
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isPowerOfThree(81));
    }
}
