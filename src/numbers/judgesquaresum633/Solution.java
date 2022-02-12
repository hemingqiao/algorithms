package src.numbers.judgesquaresum633;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/04/28 12:54:51
 * description:
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：c = 5
 * 输出：true
 * 解释：1 * 1 + 2 * 2 = 5
 * 示例 2：
 *
 * 输入：c = 3
 * 输出：false
 * 示例 3：
 *
 * 输入：c = 4
 * 输出：true
 * 示例 4：
 *
 * 输入：c = 2
 * 输出：true
 * 示例 5：
 *
 * 输入：c = 1
 * 输出：true
 *  
 *
 * 提示：
 *
 * 0 <= c <= 2^31 - 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-square-numbers
 *
 */
public class Solution {
    public boolean judgeSquareSum(int c) {
        // TLE
        int sqrt = (int) Math.sqrt(c);
        for (int i = 0; i <= sqrt + 1; i++) {
            int fixed = i * i;
            for (int j = 0; j <= sqrt + 1; j++) {
                if (fixed + j * j == c) return true;
            }
        }
        return false;
    }

    public boolean judgeSquareSum1(int c) {
        for (int i = (int) Math.sqrt(c); i >= 0; i--) {
            if (i * i == c) return true;
            int delta = c - i * i;
            int d = (int) Math.sqrt(delta);
            if (d * d == delta) return true;
        }
        return false;
    }

    // 参考：https://github.com/grandyang/leetcode/issues/633
    public boolean judgeSquareSum2(int c) {
        int a = 0, b = (int) Math.sqrt(c);
        while (a <= b) {
            int temp = a * a + b * b;
            if (temp == c) return true;
            else if (temp > c) --b;
            else ++a;
        }
        return false;
    }
}
