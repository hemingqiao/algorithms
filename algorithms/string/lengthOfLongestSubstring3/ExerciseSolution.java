package blogandquestion.algorithms.string.lengthOfLongestSubstring3;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/09 19:16:21
 * description:
 */
public class ExerciseSolution {
    public int lengthOfLongestSubstring(String s) {
        // map用来记录每个字符最后出现的位置
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        int left = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                left = Math.max(left, map.get(c) + 1);
            }
            map.put(c, i);
            maxLen = Math.max(maxLen, i - left + 1);
        }
        return maxLen;
    }
}
