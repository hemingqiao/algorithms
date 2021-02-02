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
                // 取start和最后一次出现位置加1两者的最大值是为了防止重复字符最后一次出现位置已经不在窗口中的情况
                // 如abba，当i = 3时，start = 2，而a前一次出现的位置是0，加上1是1，已经在窗口之外了
                left = Math.max(left, map.get(c) + 1);
            }
            map.put(c, i);
            // 右指针i每移动一次，就更新一次结果
            maxLen = Math.max(maxLen, i - left + 1);
        }
        return maxLen;
    }
}
