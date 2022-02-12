package src.string.findrepeateddnasequences187;

import java.util.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/10/09 20:55:58
 * description:
 */
public class Solution {
    // 普通解法
    public List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> cnt = new HashMap<>();
        for (int i = 0; i + 10 <= s.length(); i++) {
            String key = s.substring(i, i + 10);
            cnt.put(key, cnt.getOrDefault(key, 0) + 1);
        }
        List<String> ans = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : cnt.entrySet()) {
            if (entry.getValue() > 1) ans.add(entry.getKey());
        }
        return ans;
    }
}
