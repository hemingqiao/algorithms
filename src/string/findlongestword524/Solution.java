package src.string.findlongestword524;

import java.util.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/09/14 20:40:19
 * description:
 * 给你一个字符串 s 和一个字符串数组 dictionary 作为字典，找出并返回字典中最长的字符串，该字符串可以通过删除 s 中的某些字符得到。
 *
 * 如果答案不止一个，返回长度最长且字典序最小的字符串。如果答案不存在，则返回空字符串。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
 * 输出："apple"
 *
 * 示例 2：
 *
 * 输入：s = "abpcplea", dictionary = ["a","b","c"]
 * 输出："a"
 *
 *
 *
 * 提示：
 *
 *     1 <= s.length <= 1000
 *     1 <= dictionary.length <= 1000
 *     1 <= dictionary[i].length <= 1000
 *     s 和 dictionary[i] 仅由小写英文字母组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-word-in-dictionary-through-deleting
 *
 * 判断某个字符串是否是另一个字符串的子序列
 * @see https://www.acwing.com/activity/content/problem/content/2981/
 */
public class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        String res = "";
        for (String d : dictionary) {
            if (check(d, s)) {
                if (res.isEmpty() || res.length() < d.length() || res.length() == d.length() && d.compareTo(res) < 0) {
                    res = d;
                }
            }
        }
        return res;
    }

    // 判断字符串a是否是字符串b的子序列
    public boolean check(String a, String b) {
        int i = 0, j = 0, m = a.length(), n = b.length();
        while (i < m && j < n) {
            if (a.charAt(i) == b.charAt(j)) i++;
            j++;
        }
        return i == m;
    }
}
