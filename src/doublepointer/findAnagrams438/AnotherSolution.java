package src.doublepointer.findAnagrams438;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/12 22:05:19
 * description: 使用数组代替哈希map，执行速度变快了不少。
 *
 * see: https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/solution/javayou-hua-labuladongda-lao-hua-dong-chuang-kou-t/
 */
public class AnotherSolution {
    public List<Integer> findAnagrams(String s, String p) {
        if (s == null || s.length() == 0) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        int[] needs = new int[26]; // 由于都是小写字母，因此直接用26个长度的数组代替原来的HashMap
        int[] window = new int[26];
        int left = 0, right = 0, total = p.length(); // 用total检测窗口中是否已经涵盖了p中的字符
        for (char ch : p.toCharArray()) {
            needs[ch - 'a']++;
        }
        while (right < s.length()) {
            char chr = s.charAt(right);
            // 如果needs中需要这个字符，把这个字符放入窗口
            if (needs[chr - 'a'] > 0) {
                window[chr - 'a']++;
                if (window[chr - 'a'] <= needs[chr - 'a']) { // 将字符放入窗口后，如果窗口中这个字符的数量小于等于needs中需要的数量，将total减少1
                    total--;
                }
            }

            // total为0，表明已经找到所有需要的字符
            while (total == 0) {
                if (right - left + 1 == p.length()) {
                    res.add(left);
                }
                // 向右滑动窗口
                char chl = s.charAt(left);
                if (needs[chl - 'a'] > 0) {
                    window[chl - 'a']--;
                    if (window[chl - 'a'] < needs[chl - 'a']) {
                        total++;
                    }
                }
                left++;
            }
            right++;
        }
        return res;
    }
}
