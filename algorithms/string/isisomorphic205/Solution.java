package blogandquestion.algorithms.string.isisomorphic205;

import java.util.HashMap;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/25 10:08:00
 * description:
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 *
 * 如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。
 *
 * 所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。
 *
 * 示例 1:
 *
 * 输入: s = "egg", t = "add"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "foo", t = "bar"
 * 输出: false
 * 示例 3:
 *
 * 输入: s = "paper", t = "title"
 * 输出: true
 * 说明:
 * 你可以假设 s 和 t 具有相同的长度。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/isomorphic-strings
 */
public class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for (Integer i = 0; i < s.length(); i++) {
            if (map1.put(s.charAt(i), i) != map2.put(t.charAt(i), i)) {
                return false;
            }
        }
        return true;
    }

    public boolean isIsomorphicOpt(String s, String t) {
        // 对应每一位的字符具有相同个数，就代表这两个字符串是同构的
        int[] a1 = new int[256];
        int[] a2 = new int[256];
        for (int i = 0; i < s.length(); i++) {
            if (a1[s.charAt(i)] != a2[t.charAt(i)]) return false;
            a1[s.charAt(i)] = i + 1;
            a2[t.charAt(i)] = i + 1;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "egg";
        String t = "add";
        boolean res = new Solution().isIsomorphicOpt(s, t);
        System.out.println(res);
    }
}

class AnotherSolution {
    public boolean isIsomorphicOpt(String s, String t) {
        if (s.length() != t.length()) return false;
        // 对应每一位的字符具有相同个数，就代表这两个字符串是同构的
        int[] a1 = new int[128];
        int[] a2 = new int[128];
        char[] charS = s.toCharArray();
        char[] charT = t.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (a1[charS[i]] != a2[charT[i]]) return false;
            a1[charS[i]] = i + 1;
            a2[charT[i]] = i + 1;
        }
        return true;
    }

    // 对上面再优化
    public boolean isIsomorphicOpt1(String s, String t) {
        if (s.length() != t.length()) return false;
        // 对应每一位的字符具有相同个数，就代表这两个字符串是同构的
        int[] a1 = new int[128];
        int[] a2 = new int[128];
        char[] charS = s.toCharArray();
        char[] charT = t.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            // 先判断索引对应的值是否为0，在判断两个索引对应的值是否相等
            if (a1[charS[i]] == 0) {
                a1[charS[i]] = i + 1;
            }
            if (a2[charT[i]] == 0) {
                a2[charT[i]] = i + 1;
            }
            if (a1[charS[i]] != a2[charT[i]]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        AnotherSolution as = new AnotherSolution();
        String s = "egg", t = "add";
        boolean res = as.isIsomorphicOpt(s, t);
        System.out.println(res);
    }
}
