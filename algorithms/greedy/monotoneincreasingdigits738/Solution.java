package blogandquestion.algorithms.greedy.monotoneincreasingdigits738;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/12/15 08:53:05
 * description:
 * 给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。
 *
 * （当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。）
 *
 * 示例 1:
 *
 * 输入: N = 10
 * 输出: 9
 * 示例 2:
 *
 * 输入: N = 1234
 * 输出: 1234
 * 示例 3:
 *
 * 输入: N = 332
 * 输出: 299
 * 说明: N 是在 [0, 10^9] 范围内的一个整数。
 *
 * 通过次数8,155提交次数17,832
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/monotone-increasing-digits
 *
 * 参考：https://github.com/grandyang/leetcode/issues/738
 */
public class Solution {
    public int monotoneIncreasingDigits(int N) {
        char[] digits = String.valueOf(N).toCharArray();
        int len = digits.length;
        int i = len;
        for (int j = len - 1; j > 0; j--) {
            if (digits[j - 1] <= digits[j]) continue;
            digits[j - 1]--;
            i = j;
        }
        for (int k = i; k < len; k++) {
            digits[k] = '9';
        }
        return Integer.parseInt(String.valueOf(digits));
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int N = 2132;
        int res = s.monotoneIncreasingDigits(N);
        System.out.println(res);
    }
}
