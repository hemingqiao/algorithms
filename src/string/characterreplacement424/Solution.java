package src.string.characterreplacement424;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/02/02 10:06:39
 * description:
 * 给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换 k 次。在执行上述操作后，找到包含重复字母
 * 的最长子串的长度。
 *
 * 注意：字符串长度 和 k 不会超过 104。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "ABAB", k = 2
 * 输出：4
 * 解释：用两个'A'替换为两个'B',反之亦然。
 * 示例 2：
 *
 * 输入：s = "AABABBA", k = 1
 * 输出：4
 * 解释：
 * 将中间的一个'A'替换为'B',字符串变为 "AABBBBA"。
 * 子串 "BBBB" 有最长重复字母, 答案为 4。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-repeating-character-replacement
 *
 * 参考：https://github.com/grandyang/leetcode/issues/424
 */
public class Solution {
    // 不太理解
    public int characterReplacement(String s, int k) {
        int res = 0, maxCnt = 0, start = 0;
        int[] counts = new int[26];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            // 求满足 (子字符串的长度减去出现次数最多的字符个数)<=k 的最大子字符串长度
            maxCnt = Math.max(maxCnt, ++counts[s.charAt(i) - 'A']);
            while (i - start + 1 - maxCnt > k) {
                --counts[s.charAt(start) - 'A'];
                ++start;
            }
            res = Math.max(res, i - start + 1);
        }
        return res;
    }

    public int characterReplacement1(String s, int k) {
        int res = 0, maxCnt = 0, start = 0;
        int[] counts = new int[26];
        char[] chars = s.toCharArray();
        int n = chars.length;
        for (int i = 0; i < n; i++) {
            maxCnt = Math.max(maxCnt, ++counts[chars[i] - 'A']);
            while (i - start + 1 - maxCnt > k) {
                // 窗口右移
                --counts[chars[start] - 'A'];
                ++start;
            }
            res = Math.max(res, i - start + 1);
        }
        return res;
    }
}
