package src.string.lengthOfLongestSubstring3;

import java.util.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/09/25 12:17:50
 * description:
 */
public class ExerciseSolution3 {
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int[] st = new int[256];
        int n = chars.length, ans = 0;
        for (int i = 0, j = 0; i < n; i++) {
            st[chars[i]]++;
            while (st[chars[i]] > 1) st[chars[j++]]--;
            ans = Math.max(ans, i - j + 1);
        }
        return ans;
    }

    public int lengthOfLongestSubstring1(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        Map<Character, Integer> map = new HashMap<>();
        int res = 0, start = 0;
        for (int i = 0; i < n; i++) {
            char t = chars[i];
            if (map.containsKey(t)) {
                // 取max是为了保证左边的指针start不会向左移动，左指针start是单调向右移动的
                // eg: abba
                start = Math.max(start, map.get(t) + 1);
            }
            map.put(t, i);
            // 右指针i每移动一次，就更新一次结果
            res = Math.max(res, i - start + 1);
        }
        return res;
    }
}
