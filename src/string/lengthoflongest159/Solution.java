package src.string.lengthoflongest159;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/02/02 13:05:53
 * description:
 * 给定一个字符串 s ，找出 至多 包含两个不同字符的最长子串 t ，并返回该子串的长度。
 *
 * 示例 1:
 *
 * 输入: "eceba"
 * 输出: 3
 * 解释: t 是 "ece"，长度为3。
 * 示例 2:
 *
 * 输入: "ccaabbb"
 * 输出: 5
 * 解释: t 是 "aabbb"，长度为5。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-with-at-most-two-distinct-characters
 *
 * 参考：https://leetcode-cn.com/problems/longest-substring-with-at-most-two-distinct-characters/solution/java-hua-dong-chuang-kou-by-lyl0724-2/
 */
public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        Map<Character, Integer> map = new HashMap<>();
        int res = 0, start = 0;
        for (int i = 0; i < n; i++) {
            char t = chars[i];
            if (map.containsKey(t)) {
                map.put(t, map.get(t) + 1);
            } else {
                map.put(t, 1);
            }
            // 直到map中记录的字符数量等于2时退出循环
            while (map.size() > 2) {
                char left = chars[start++]; // 注意这里的左指针要向右移动
                int val = map.get(left) - 1;
                if (val == 0) {
                    map.remove(left);
                } else {
                    map.put(left, val);
                }
            }
            res = Math.max(res, i - start + 1); // 右指针i每移动一次，就更新结果
        }
        return res;
    }
}
