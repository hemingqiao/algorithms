package blogandquestion.algorithms.string.lengthoflongestsubstringlcof;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/02/11 18:45:33
 * description:
 * 注意，此题和LeetCode的第三题相同。
 * @see https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
//        if (s.length() == 0 || s.length() == 1) return s.length();
        char[] chars = s.toCharArray();
        int n = chars.length;
        int res = 0;
        // 使用数组作为哈希表
        int[] cnt = new int[256];
        int left = 0, right = 0;
        while (right < n) {
            char t = chars[right++];
            cnt[t]++;

            // 如果某个字符对应的值大于1了，表明这个字符之前出现过，此时需要收缩窗口左边界
            // 移除这个出现过的字符
            while (cnt[t] > 1) {
                cnt[chars[left++]]--;
            }

            // 窗口每向右滑动一次，就更新一次结果
            // 需要注意的是，在上面right已经自增（++）过了，所以此处计算长度只需要减去left即可，不需要再加上1
            res = Math.max(res, right - left);
        }
        return res;
    }

    // 使用map作为哈希表
    public int lengthOfLongestSubstring1(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        for (int i = 0; i < n; i++) {
            char t = chars[i];
            if (map.containsKey(t)) {
                // 如果某个字符在前面出现过，窗口左边界更新为left和该字符最后一次出现的位置后的位置的较大者
                left = Math.max(left, map.get(t) + 1);
            }
            // 窗口每向右滑动一次，就更新一次字符的最后出现位置
            map.put(t, i);
            res = Math.max(res, i - left + 1);
        }
        return res;
    }
}
