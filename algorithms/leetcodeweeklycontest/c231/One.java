package blogandquestion.algorithms.leetcodeweeklycontest.c231;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/03/07 10:27:55
 * description:
 * 给你一个二进制字符串 s ，该字符串 不含前导零 。
 *
 * 如果 s 最多包含 一个由连续的 '1' 组成的字段 ，返回 true​​​ 。否则，返回 false 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "1001"
 * 输出：false
 * 解释：字符串中的 1 没有形成一个连续字段。
 * 示例 2：
 *
 * 输入：s = "110"
 * 输出：true
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 100
 * s[i]​​​​ 为 '0' 或 '1'
 * s[0] 为 '1'
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/check-if-binary-string-has-at-most-one-segment-of-ones
 *
 */
public class One {
    public boolean checkOnesSegment(String s) {
        int n = s.length();
        int times = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                times++;
                int j = i + 1;
                while (j < n && s.charAt(j) == '1') {
                    j++;
                    i++;
                }
                if (i == n - 1 && times == 1) return true;
            }
        }
        return times == 1;
    }

    public static void main(String[] args) {
        One one = new One();
        String test = "1001";
        boolean res = one.checkOnesSegment(test);
        System.out.println(res);
    }

    public boolean checkOnesSegment1(String s) {
        int n = s.length();
        int times = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                times++;
                if (times > 1) return false;
                int j = i + 1;
                while (j < n && s.charAt(j) == '1') {
                    j++;
                    i++;
                }
            }
        }
        return times == 1;
    }

    public boolean checkOnesSegment2(String s) {
        if (s.length() == 1) return true;
        for (int i = 1; i < s.length(); i++) {
            // 题目要求1必须连续出现，所以如果1没有连续出现，就可以返回false了
            if (s.charAt(i) == '1' && s.charAt(i - 1) != '1') return false;
        }
        return true;
    }
}
