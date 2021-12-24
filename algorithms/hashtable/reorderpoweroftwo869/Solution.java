package blogandquestion.algorithms.hashtable.reorderpoweroftwo869;

import java.util.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/10/29 21:00:35
 * description:
 */
public class Solution {
    public boolean reorderedPowerOf2(int N) {
        int n = (int) 1e9;
        String s = String.valueOf(N);
        Map<Character, Integer> c1 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            c1.put(s.charAt(i), c1.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 1; i < n; i *= 2) {
            if (check(c1, String.valueOf(i), s)) return true;
        }
        return false;
    }

    public boolean check(Map<Character, Integer> c, String t, String s) {
        if (s.length() != t.length()) return false;
        Map<Character, Integer> m = new HashMap<>();
        for (int i = 0; i < t.length(); i++) m.put(t.charAt(i), m.getOrDefault(t.charAt(i), 0) + 1);
        for (int i = 0; i < s.length(); i++) {
            char cc = s.charAt(i);
            if (!m.containsKey(cc) || !m.get(t.charAt(i)).equals(c.get(t.charAt(i)))) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        boolean res = s.reorderedPowerOf2(10);
        System.out.println(res);
    }
}
