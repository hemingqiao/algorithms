package blogandquestion.algorithms.dp.numtrees96;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/02/24 19:44:26
 * description:
 */
public class ExerciseSolution {
    // 卡塔兰数(https://zh.wikipedia.org/wiki/%E5%8D%A1%E5%A1%94%E5%85%B0%E6%95%B0)的一个例子
    // 参考：https://github.com/grandyang/leetcode/issues/96
    public int numTrees(int n) {
        int[] dp = new int[n];
        dp[0] = dp[1] = 1;
        for (int i = 2; i < n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - 1 - j];
            }
        }
        return dp[n - 1];
    }

    /*
    把 n = 0 时赋为1，因为空树也算一种二叉搜索树，那么 n = 1 时的情况可以看做是其左子树个数乘以右子树的个数，左右子树都是空树，所以1乘1还是1。
    那么 n = 2 时，由于1和2都可以为根，分别算出来，再把它们加起来即可。n = 2 的情况可由下面式子算出（这里的 dp[i] 表示当有i个数字能组成
    的 BST 的个数）：

        dp[2] =  dp[0] * dp[1]　　　(1为根的情况，则左子树一定不存在，右子树可以有一个数字)

        　　　　+ dp[1] * dp[0]　　  (2为根的情况，则左子树可以有一个数字，右子树一定不存在)

    同理可写出 n = 3 的计算方法：

        dp[3] =  dp[0] * dp[2]　　　(1为根的情况，则左子树一定不存在，右子树可以有两个数字)

        　　　　+ dp[1] * dp[1]　　  (2为根的情况，则左右子树都可以各有一个数字)

         　　　  + dp[2] * dp[0]　　  (3为根的情况，则左子树可以有两个数字，右子树一定不存在)

    由此可以得出卡塔兰数列的递推式
     */
}
