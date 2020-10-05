package blogandquestion.algorithms.dp.climbstairs70;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/05 08:57:36
 * description:
 * 设爬到第x级台阶有f(x)种方法，又因为每次只能爬一级或者两级，所以爬到第x级可以是从x-2级爬两级，也可以是从x-1级爬一级，
 * 所以爬到第x级的方法是爬到x-2级的方法和爬到x-1级的方法之和：
 * 有 f(x) = f(x - 1) + f(x - 2)
 * 上式便是状态转移方程。
 * 而进行初始化的边界条件则是：f(0) = 1, f(1) = 1;
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
