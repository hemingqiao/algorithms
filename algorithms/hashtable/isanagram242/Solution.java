package blogandquestion.algorithms.hashtable.isanagram242;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/12 19:15:22
 * description: 因为题目限定只有小写字母，可以将对应的字符映射到一个长度为26的数组中，遍历第一个字符串，记录对应字符出现次数，然后
 * 在遍历另一个字符串，记录对应字符出现次数，只不过之前记录是每出现一次，增加1，第二次是每出现一次，对应值减1。
 * 两次遍历结束后，如果record数组中有元素不为零，则返回false。
 * 解题思路
 * see: https://leetcode-cn.com/problems/valid-anagram/
 *
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-anagram
 *
 */
public class Solution {
    public boolean isAnagram(String s, String t) {
        int[] record = new int[26];
        for (char c : s.toCharArray()) {
            record[c - 'a'] ++;
        }
        for (char c : t.toCharArray()) {
            record[c - 'a']--;
        }
        for (int j : record) {
            if (j != 0) return false;
        }
        return true;
    }
}

class AnotherSolution {
    // 如果输入字符串包含 unicode 字符怎么办？
    // 此时就需要使用哈希表，因为Unicode字符的范围可能超过100万
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char d : t.toCharArray()) {
            map.put(d, map.getOrDefault(d, 0) - 1);
        }
        for (int i : map.values()) {
            if (i != 0) return false;
        }
        return true;
    }
}
