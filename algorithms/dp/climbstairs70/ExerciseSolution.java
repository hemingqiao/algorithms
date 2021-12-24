package blogandquestion.algorithms.dp.climbstairs70;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/27 21:44:02
 * description:
 */
public class ExerciseSolution {
    // 参考：https://leetcode-cn.com/problems/climbing-stairs/solution/pa-lou-ti-by-leetcode-solution/595005
    // 一个follow up，相较于原题目加一个限制条件
    // 1、每次你可以爬 1 或 2 个台阶。 2、不能连续跳两个台阶。
    // “不能连续跳两个台阶”，即一旦跳了两个台阶，则下一步只能跳一步（2->1），把它们连在一起就一共跳了三个台阶，所以问题可以转化为要么跳一个台阶，
    // 要么跳三个台阶（当然还是有点区别的，只不过因为结果是一样的，所以可以这么转化），于是就有了 f(x) = f(x-1) + f(x-3)
    public int climbStairs(int n) {
        if (n < 2) return 1;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 3];
        }
        return dp[n];
    }

    /*
    思路：
        假设：
        f(x) 表示爬到第 x 级台阶的方案数，
        g(x, 1) 表示爬到第 x 级台阶并且最后一步只跨越一个台阶的方案数，
        g(x, 2) 表示爬到第 x 级台阶并且最后一步跨越了两个台阶的方案数。

        由 ：
        f(x) = g(x, 1)+g(x,2)，
        g(x, 1) = f(x-1)，
        g(x, 2) = g(x-2, 1) // 最后一步跨越了两步，那么上一步只能跨越一步

        得：
        f(x) = g(x, 1) + g(x, 2)
              = f(x-1) + g(x-2, 1)
              = f(x-1) + f((x-2)-1)
              = f(x-1) + f(x-3)
     */
}
