package src.numbers.nthuglynumber264;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/18 20:36:10
 * description:
 * 编写一个程序，找出第 n 个丑数。
 *
 * 丑数就是质因数只包含 2, 3, 5 的正整数。
 *
 * 示例:
 *
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 * 说明:  
 *
 * 1 是丑数。
 * n 不超过1690。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ugly-number-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    // 超时，悲伤
    public int nthUglyNumber(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            if (isUgly(i)) list.add(i);
            if (list.size() == n) {
                return list.get(n - 1);
            }
        }
        return -1;
    }

    private boolean isUgly(int n) {
        if (n == 0) return false;
        while (n % 2 == 0) n /= 2;
        while (n % 3 == 0) n /= 3;
        while (n % 5 == 0) n /= 5;
        return n == 1;
    }

    public static void main(String[] args) {
        int res = new Solution().nthUglyNumber(1352);
        System.out.println(res);
    }
}

/**
 * 使用treeset，时间效率很低。
 * 参考：https://leetcode-cn.com/problems/ugly-number-ii/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-5-9/
 */
class AnotherSolution {
    public int nthUglyNumber(int n) {
        TreeSet<Long> set = new TreeSet<>();
        int count = 0;
        long result = 1;
        set.add(result);
        while (count < n) {
            result = set.pollFirst();
            count++;
            set.add(result * 2);
            set.add(result * 3);
            set.add(result * 5);
        }
        return (int) result;
    }
}

/**
 * 参考：https://leetcode-cn.com/problems/ugly-number-ii/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-5-9/
 */
class DPSolution {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0;
        for (int i = 1; i < n; i++) {
            int t2 = dp[p2] * 2, t3 = dp[p3] * 3, t5 = dp[p5] * 5;
            dp[i] = Math.min(Math.min(t2, t3), t5);
            if (dp[i] == t2) p2++;
            if (dp[i] == t3) p3++;
            if (dp[i] == t5) p5++;
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        // 402653184
        System.out.println(new DPSolution().nthUglyNumber(1352));
    }
}
