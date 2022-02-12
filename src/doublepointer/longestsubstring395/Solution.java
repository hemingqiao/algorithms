package src.doublepointer.longestsubstring395;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/02/27 08:28:08
 * description:
 * 找到给定字符串（由小写字符组成）中的最长子串 T ， 要求 T 中的每一字符出现次数都不少于 k 。输出 T 的长度。
 *
 * 示例 1:
 *
 * 输入:
 * s = "aaabb", k = 3
 *
 * 输出:
 * 3
 *
 * 最长子串为 "aaa" ，其中 'a' 重复了 3 次。
 * 示例 2:
 *
 * 输入:
 * s = "ababbc", k = 2
 *
 * 输出:
 * 5
 *
 * 最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-with-at-least-k-repeating-characters
 *
 * 参考：https://github.com/grandyang/leetcode/issues/395
 */
public class Solution {
    /*
    因为题目中限定了字符串中只有字母，这意味着最多不同的字母数只有 26 个，最后满足题意的子串中的不同字母数一定是在 [1, 26] 的范围，这样就可以
    遍历这个范围，每次只找不同字母个数为 cnt，且每个字母至少重复k次的子串，来更新最终结果 res
     */

    public int longestSubstring(String s, int k) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int res = 0;
        for (int cnt = 1; cnt <= 26; cnt++) {
            int left = 0, i = 0, uniqueCnt = 0;
            int[] charCnt = new int[26];
            while (i < n) {
                boolean valid = true;
                if (charCnt[chars[i++] - 'a']++ == 0) ++uniqueCnt;
                while (uniqueCnt > cnt) {
                    if (--charCnt[chars[left++] - 'a'] == 0) --uniqueCnt;
                }
                for (int j = 0; j < 26; j++) {
                    if (charCnt[j] > 0 && charCnt[j] < k) {
                        valid = false;
                        break;
                    }
                }
                if (valid) res = Math.max(res, i - left); // 注意这里，i在上面已经执行过自增，所以这里求区间长度不需要再加上1了
            }
        }
        return res;
    }
}
