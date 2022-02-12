package src.numbers.integerbreak343;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/02/24 21:21:55
 * description:
 *
 * 这题和后面剑指offer的一题相同：https://leetcode-cn.com/problems/jian-sheng-zi-lcof/
 *
 * 参考：https://github.com/grandyang/leetcode/issues/343
 */
public class ExerciseSolution {
    /*
    给了一个正整数n，让拆分成至少两个正整数之和，使其乘积最大。最简单粗暴的方法自然是检查所有情况了，但是拆分方法那么多，怎么才能保证能拆分出所有
    的情况呢？感觉有点像之前那道 Coin Change，当前的拆分方法需要用到之前的拆分值，这种重现关系就很适合动态规划 Dynamic Programming 来做，
    可以使用一个一维数组 dp，其中 dp[i] 表示数字i拆分为至少两个正整数之和的最大乘积，数组大小为 n+1，值均初始化为1，因为正整数的乘积不会小于1。
    可以从3开始遍历，因为n是从2开始的，而2只能拆分为两个1，乘积还是1。i从3遍历到n，对于每个i，需要遍历所有小于i的数字，因为这些都是潜在的拆分
    情况，对于任意小于i的数字j，首先计算拆分为两个数字的乘积，即j乘以 i-j，然后是拆分为多个数字的情况，这里就要用到 dp[i-j] 了，这个值表示
    数字 i-j 任意拆分可得到的最大乘积，再乘以j就是数字i可拆分得到的乘积，取二者的较大值来更新 dp[i]，最后返回 dp[n] 即可。
     */

    public int intergerBreak(int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) dp[i] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }

    public int intergerBreak1(int n) {
        if (n == 2 || n == 3) return n - 1;
        int ret = 1;
        while (n > 4) {
            n -= 3;
            ret *= 3;
        }
        return ret * n;
    }
}
