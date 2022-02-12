package src.string.lengthoflongest340;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/02/02 13:38:12
 * description:
 * 给定一个字符串 s ，找出 至多 包含 k 个不同字符的最长子串 T。
 *
 * 示例 1:
 *
 * 输入: s = "eceba", k = 2
 * 输出: 3
 * 解释: 则 T 为 "ece"，所以长度为 3。
 * 示例 2:
 *
 * 输入: s = "aa", k = 1
 * 输出: 2
 * 解释: 则 T 为 "aa"，所以长度为 2。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-with-at-most-k-distinct-characters
 *
 */
public class Solution {
    // 这一题和159非常类似
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int res = 0, left = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char t = chars[i];
            if (map.containsKey(t)) {
                map.put(t, map.get(t) + 1);
            } else {
                map.put(t, 1);
            }
            while (map.size() > k) {
                char start = chars[left++]; // 注意这里的左指针要向右移动
                int val = map.get(start) - 1;
                if (val == 0) map.remove(start);
                else map.put(start, val);
            }

            // 右指针i每移动一次，就更新一次结果
            res = Math.max(res, i - left + 1);
        }
        return res;
    }
}
