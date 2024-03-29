package src.leetcodeweeklycontest.d47;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/03/06 21:40:03
 * description:
 * 给你一个整数 n ，如果你可以将 n 表示成若干个不同的三的幂之和，请你返回 true ，否则请返回 false 。
 *
 * 对于一个整数 y ，如果存在整数 x 满足 y == 3^x ，我们称这个整数 y 是三的幂。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 12
 * 输出：true
 * 解释：12 = 3^1 + 3^2
 * 示例 2：
 *
 * 输入：n = 91
 * 输出：true
 * 解释：91 = 3^0 + 3^2 + 3^4
 * 示例 3：
 *
 * 输入：n = 21
 * 输出：false
 *  
 *
 * 提示：
 *
 * 1 <= n <= 10^7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/check-if-number-is-a-sum-of-powers-of-three
 *
 */
public class Two {
    public boolean checkPowersOfThree(int n) {
        int[] table = new int[16];
        for (int i = 0; i < 16; i++) {
            table[i] = (int) Math.pow(3, i);
        }
        for (int i = 15; i >= 0; i--) {
            if (n >= table[i]) {
                n -= table[i];
            }
        }
        return n == 0;
    }

    // 大佬的解法
    public boolean checkPowersOfThree1(int n) {
        for (; n != 0; n /= 3) {
            if (n % 3 == 2) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Two two = new Two();
        boolean res = two.checkPowersOfThree(12);
        System.out.println(res);
    }
}
