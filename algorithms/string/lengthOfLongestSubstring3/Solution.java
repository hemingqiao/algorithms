package blogandquestion.algorithms.string.lengthOfLongestSubstring3;

import java.util.HashMap;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/07 20:08:54
 * description: 滑动窗口
 *
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 *
 * see: https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/solution/hua-dong-chuang-kou-by-powcai/475125
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLen = 0; // 用于记录最大不重复字串的长度
        int left = 0; // 滑动窗口左指针
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                // 当发现重复元素时，窗口左指针右移
                // 如何实现窗口左指针右移呢？从哈希表中取出和当前字符相同的字符的索引（+1是为了跳过这个相同的字符），如果这个索引
                // 大于当前窗口位置（left），将left更新为取出的索引，如果从哈希表中取出的索引加上1小于当前窗口位置，那么这个字符不会
                // 影响当前窗口内的字符，left不变
                // 所以上述两个行为就是将left设置为left和从哈希表中取出的索引加1的较大值
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }

            map.put(s.charAt(i), i);
            maxLen = Math.max(maxLen, i - left + 1);
        }

        return maxLen;
    }
}

class AnotherSolution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        int len = chars.length;
        int maxLen = 0; // 用于记录最大不重复字串的长度
        int left = 0; // 滑动窗口左指针
        for (int i = 0; i < len; i++) {
            if (map.containsKey(chars[i])) {
                // 当发现重复元素时，窗口左指针右移
                left = Math.max(left, map.get(chars[i]));
            }

            // 由于从哈希表中取出索引后还需要再加上1跳过当前索引，不如我在添加进哈希表中就把值设置为索引加1
            map.put(chars[i], i + 1);
            maxLen = Math.max(maxLen, i - left + 1); // 更新最大长度
        }
        return maxLen;
    }

    public static void main(String[] args) {
        AnotherSolution as = new AnotherSolution();
        String s = "abba";
        int len = as.lengthOfLongestSubstring(s);
        System.out.println(len);
    }
}


class NewSolution {
    public int lengthOfLongestSubstring(String s) {
        int[] record = new int[128];
        int len = s.length();

        int res = 0;
        int start = 0; // 窗口开始位置
        for (int i = 0; i < len; i++) {
            char idx = s.charAt(i);
            start = Math.max(start, record[idx]);
            res = Math.max(res, i - start + 1);
            record[idx] = i + 1;
        }
        return res;
    }
}
