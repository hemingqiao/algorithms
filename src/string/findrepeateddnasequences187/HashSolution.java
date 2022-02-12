package src.string.findrepeateddnasequences187;

import java.util.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/10/09 20:57:06
 * description:
 * 字符串哈希
 */
public class HashSolution {
    static int N = 100010, P = 131;
    static long[] h = new long[N], p = new long[N];

    public List<String> findRepeatedDnaSequences(String s) {
        char[] c = s.toCharArray();
        p[0] = 1;
        for (int i = 1; i <= c.length; i++) {
            h[i] = h[i - 1] * P + c[i - 1];
            p[i] = p[i - 1] * P;
        }
        List<String> ans = new ArrayList<>();
        Map<Long, Integer> cnt = new HashMap<>();
        // h数组是从1开始计数的
        for (int i = 1; i + 9 <= c.length; i++) {
            long hash = get(i, i + 9);
            int val = cnt.getOrDefault(hash, 0);
            if (val == 1) ans.add(s.substring(i - 1, i + 9));
            cnt.put(hash, val + 1);
        }
        return ans;
    }

    public long get(int l, int r) {
        return h[r] - h[l - 1] * p[r - l + 1];
    }
}
