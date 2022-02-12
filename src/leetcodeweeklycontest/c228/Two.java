package src.leetcodeweeklycontest.c228;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/02/15 08:56:38
 * description:
 * 给你一个字符串 s ，返回 s 中 同构子字符串 的数目。由于答案可能很大，只需返回对 109 + 7 取余 后的结果。
 *
 * 同构字符串 的定义为：如果一个字符串中的所有字符都相同，那么该字符串就是同构字符串。
 *
 * 子字符串 是字符串中的一个连续字符序列。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "abbcccaa"
 * 输出：13
 * 解释：同构子字符串如下所列：
 * "a"   出现 3 次。
 * "aa"  出现 1 次。
 * "b"   出现 2 次。
 * "bb"  出现 1 次。
 * "c"   出现 3 次。
 * "cc"  出现 2 次。
 * "ccc" 出现 1 次。
 * 3 + 1 + 2 + 1 + 3 + 2 + 1 = 13
 * 示例 2：
 *
 * 输入：s = "xy"
 * 输出：2
 * 解释：同构子字符串是 "x" 和 "y" 。
 * 示例 3：
 *
 * 输入：s = "zzzzz"
 * 输出：15
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 10^5
 * s 由小写字符串组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-number-of-homogenous-substrings
 *
 * 参考：https://leetcode-cn.com/problems/count-number-of-homogenous-substrings/solution/tong-ji-tong-gou-zi-zi-fu-chuan-de-shu-m-yn11/
 * 参考：https://leetcode-cn.com/problems/count-number-of-homogenous-substrings/solution/c-zhi-jie-bian-li-ji-suan-lian-xu-zi-fu-g825r/
 */
public class Two {
    public int countHomogenous(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int mod = (int) (1e9 + 7);
        long res = 0;
        int i = 0, j = 0;
        while (i < n) {
            char t = chars[i];
            while (j < n && chars[j] == t) {
                j++;
            }
            long m = j - i;
            res += (m + 1) * m / 2;
            i = j;
        }
        return (int) (res % mod);
    }


    public int countHomogenous1(String s) {
        if (s.length() == 0) return 0;
        char[] chars = s.toCharArray();
        int n = chars.length;
        int res = 1, cnt = 1;
        int mod = (int) (1e9 + 7);
        char pre = chars[0];
        for (int i = 1; i < n; i++) {
            if (chars[i] == pre) {
                cnt++;
            } else {
                cnt = 1;
                pre = chars[i];
            }
            res += cnt;
            if (res > mod) {
                res %= mod;
            }
        }
        return res;
    }
}
