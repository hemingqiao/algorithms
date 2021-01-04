package blogandquestion.algorithms.array.numteams1395;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/04 18:53:19
 * description:
 * 参考：https://leetcode-cn.com/problems/count-number-of-teams/solution/tong-ji-liang-ce-de-shi-bing-on2java-by-wowph/
 */
public class AnotherSolution {
    public int numTeams(int[] rating) {
        int cnt = 0;
        int n = rating.length;
        // 从1开始遍历，到n - 1截止
        for (int i = 1; i < n - 1; i++) {
            int[] left = count(rating, 0, i, rating[i]);
            int[] right = count(rating, i + 1, n, rating[i]);
            cnt += left[0] * right[1] + left[1] * right[0];
        }
        return cnt;
    }

    private int[] count(int[] rating, int from, int to, int target) {
        int[] ret = new int[2]; // ret[0]代表target单侧比target小的个数，ret[1]代表比target大的个数
        for (int i = from; i < to; i++) {
            if (rating[i] < target) {
                ret[0]++;
            } else {
                ret[1]++;
            }
        }
        return ret;
    }
}
