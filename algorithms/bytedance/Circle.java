package blogandquestion.algorithms.bytedance;

import java.util.Arrays;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/04/04 19:57:02
 * description:
 */
public class Circle {
    /*
    圆环上有10个点，编号为0~9。从0点出发，每次可以逆时针和顺时针走一步，问走n步回到0点共有多少种走法。

    输入: 2
    输出: 2
    解释：有2种方案。分别是0->1->0和0->9->0

    参考：https://leetcode-cn.com/circle/discuss/TWO4Z5/
     */

    // 走n步到0的方案数=走n-1步到1的方案数+走n-1步到9的方案数
    // 设dp[i][j]为从0出发走i步到j点的方案数(取模是为了处理当j为0或者j为9时的情况)
    // 则dp[i][j] = dp[i - 1][(j - 1 + length) % length] + dp[i - 1][(j + 1) % length]
    public int backToOrigin(int length, int n) {
        int[][] dp = new int[n + 1][length];
        dp[0][0] = 1; // 从0出发走0步到0只有一种方案，走0步到其他地方只有0种方案
        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < length; j++) {
                dp[i][j] = dp[i - 1][(j - 1 + length) % length] + dp[i - 1][(j + 1) % length];
            }
        }
//        System.out.println(Arrays.deepToString(dp));
        return dp[n][0];
    }

    public static void main(String[] args) {
        Circle c = new Circle();
        int len = 10, n = 4;
        System.out.println(c.backToOrigin(len, n));
    }
}
