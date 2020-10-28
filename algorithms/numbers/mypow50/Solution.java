package blogandquestion.algorithms.mypow50;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/18 21:35:47
 * description: 二分的思想。
 *
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 *
 * 示例 1:
 *
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例 2:
 *
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例 3:
 *
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/powx-n
 *
 * 解题思路
 * see: https://leetcode-cn.com/problems/powx-n/solution/powx-n-by-leetcode-solution/
 */
public class Solution {
    public double myPow(double x, int n) {
        int N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }

    private double quickMul(double x, int n) {
        if (n == 0) return 1.0;
        double y = quickMul(x, n / 2);
        return n % 2 == 0 ? y * y : y * y * x;
    }
}
