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
                //left = Math.max(left, map.get(s.charAt(i)) + 1);
                int temp = map.get(s.charAt(i)) + 1;
                if (temp > left) {
                    left = temp;
                }
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
                int temp = map.get(chars[i]) + 1;
                if (temp > left) {
                    left = temp;
                }
            }

            map.put(chars[i], i); // 更新map
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

class ASolution {
    public int lengthOfLongestSubstring(String s) {
        char[] sc = s.toCharArray();
        int left = 0;
        int maxLen = 0;
        for (int j = 0; j < sc.length; j++) {
            for (int min = left; min < j; min++) {
                if (sc[min] == sc[j]) {
                    maxLen = Math.max(maxLen, j - left);
                    left = min + 1;
                    break;
                }
            }
        }
        return Math.max(sc.length - left, maxLen);
    }

    public static void main(String[] args) {
        ASolution as = new ASolution();
        String s = "abcabcbb";
        int len = as.lengthOfLongestSubstring(s);
        System.out.println(len);
    }
}
