package blogandquestion.algorithms.dp.climbstairs70;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/05 08:57:36
 * description:
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 *
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/climbing-stairs
 *
 *
 * 设爬到第x级台阶有f(x)种方法，又因为每次只能爬一级或者两级，所以爬到第x级可以是从x-2级爬两级，也可以是从x-1级爬一级，
 * 所以爬到第x级的方法是爬到x-2级的方法和爬到x-1级的方法之和：
 * 有 f(x) = f(x - 1) + f(x - 2)
 * 上式便是状态转移方程。
 * 而进行初始化的边界条件则是：f(0) = 1, f(1) = 1;
 * 下面的解法是递归解法（事实上是斐波那契数列的尾递归解法）。
 * see: https://leetcode-cn.com/problems/climbing-stairs/solution/pa-lou-ti-by-leetcode-solution/
 */
public class Solution {
    public int climbStairs(int n) {
        return auxiliary(n, 1, 1);
    }

    private int auxiliary(int n, int a, int b) {
        if (n == 0) {
            return a;
        }
        return auxiliary(n - 1, b, a + b);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().climbStairs(3));
    }
}
