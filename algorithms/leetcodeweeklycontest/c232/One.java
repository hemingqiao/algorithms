package blogandquestion.algorithms.leetcodeweeklycontest.c232;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/03/14 10:23:59
 * description:
 * 给你长度相等的两个字符串 s1 和 s2 。一次 字符串交换 操作的步骤如下：选出某个字符串中的两个下标（不必不同），并交换这两个下标所对应的字符。
 *
 * 如果对 其中一个字符串 执行 最多一次字符串交换 就可以使两个字符串相等，返回 true ；否则，返回 false 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s1 = "bank", s2 = "kanb"
 * 输出：true
 * 解释：例如，交换 s2 中的第一个和最后一个字符可以得到 "bank"
 * 示例 2：
 *
 * 输入：s1 = "attack", s2 = "defend"
 * 输出：false
 * 解释：一次字符串交换无法使两个字符串相等
 * 示例 3：
 *
 * 输入：s1 = "kelb", s2 = "kelb"
 * 输出：true
 * 解释：两个字符串已经相等，所以不需要进行字符串交换
 * 示例 4：
 *
 * 输入：s1 = "abcd", s2 = "dcba"
 * 输出：false
 *  
 *
 * 提示：
 *
 * 1 <= s1.length, s2.length <= 100
 * s1.length == s2.length
 * s1 和 s2 仅由小写英文字母组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/check-if-one-string-swap-can-make-strings-equal
 *
 */
public class One {
    public boolean areAlmostEqual(String s1, String s2) {
        int n1 = s1.length();
        int cnt = 0;
        int[] ret = new int[26];
        int[] ret1 = new int[26];
        for (int i = 0; i < n1; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                cnt++;
                ret[s1.charAt(i) - 'a']++;
                ret1[s2.charAt(i) - 'a']++;
            }
            if (cnt > 2) return false;
        }
        if (cnt == 0) return true;
        if (cnt == 1) return false;
        int times = 0;
        for (int i = 0; i < 26; i++) {
            // 针对"aca", "bcb"这样的用例
            if (ret[i] == 1 && ret1[i] == 1) times++;
        }
        return times == 2;
    }

    public static void main(String[] args) {
        String s1 = "aca", s2 = "bcb";
        One one = new One();
        boolean res = one.areAlmostEqual(s1, s2);
        System.out.println(res);
    }
}
