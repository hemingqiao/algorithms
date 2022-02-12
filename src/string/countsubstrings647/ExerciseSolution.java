package src.string.countsubstrings647;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/03/08 22:11:28
 * description:
 * 经典动态规划题目
 */
public class ExerciseSolution {
    // 参考：https://www.cnblogs.com/grandyang/p/7404777.html
    public int countSubstrings(String s) {
        if (s.isEmpty()) return 0;
        char[] chars = s.toCharArray();
        int n = chars.length;
        // dp[i][j]表示区间[i, j]内的字串是否是回文串(左闭右闭区间)
        boolean[][] dp = new boolean[n][n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            // 应该先确定小区间是否是回文串，再通过小区间的状态推到更大区间的状态
            // 所以遍历顺序是随着i的增大，j从0遍历到i
            for (int j = i; j >= 0; j--) {
                // 不需要担心i - 1或者j + 1越界，因为 j - i <= 2会短路后面的判断条件
                // 如，当i == n - 1时，j从i开始，此时j == n - 1，第一个条件成立，短路了后面的判断条件
                dp[i][j] = (chars[i] == chars[j]) && (i - j <= 2 || dp[i - 1][j + 1]);
                if (dp[i][j]) ++res;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ExerciseSolution es = new ExerciseSolution();
        String test = "aaaaa";
        int res = es.countSubstrings(test);
        System.out.println(res);
    }
}
