package blogandquestion.algorithms.dp.canwinnim292;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/12/02 09:01:28
 * description:
 */
public class Solution {
    // 超时
    public boolean canWinNim(int n) {
        if (n < 4) return true;
        boolean[] dp = new boolean[4];
        dp[0] = false;
        dp[1] = true;
        dp[2] = true;
        dp[3] = true;
        for (int i = 4; i <= n; i++) {
            dp[i % 4] = !dp[(i - 1) % 4] || !dp[(i - 2) % 4] || !dp[(i - 3) % 4];
        }
        return dp[n % 4];
    }
}

class AnotherSolution {
    // 数学方法
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }
}
