package src.binary.rangebitwiseand201;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/25 18:41:57
 * description:
 * 给定范围 [m, n]，其中 0 <= m <= n <= 2147483647，返回此范围内所有数字的按位与（包含 m, n 两端点）。
 *
 * 示例 1: 
 *
 * 输入: [5,7]
 * 输出: 4
 * 示例 2:
 *
 * 输入: [0,1]
 * 输出: 0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bitwise-and-of-numbers-range
 *
 */
public class Solution {
    // 暴力遍历，超时了。。
    public int rangeBitwiseAnd(int m, int n) {
        int res = m;
        for (int i = m + 1; i <= n; i++) {
            res &= i;
        }
        return res;
    }

    // 参考：https://leetcode.wang/leetcode-201-Bitwise-AND-of-Numbers-Range.html
    // 暂时没理解
    public int rangeBitwiseAndOpt(int m, int n) {
        int zeros = 0;
        while (n > m) {
            zeros++;
            m >>>= 1;
            n >>>= 1;
        }
        //将 0 的个数空出来
        return m << zeros;
    }
}
