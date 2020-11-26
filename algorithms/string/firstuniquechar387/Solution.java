package blogandquestion.algorithms.string.firstuniquechar387;

import java.util.HashMap;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/26 18:29:33
 * description:
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 *  
 *
 * 示例：
 *
 * s = "leetcode"
 * 返回 0
 *
 * s = "loveleetcode"
 * 返回 2
 *  
 *
 * 提示：你可以假定该字符串只包含小写字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-unique-character-in-a-string
 *
 */
public class Solution {
    public int firstUniqueChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        int len = chars.length;
        for (char c : chars) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < len; i++) {
            if (map.get(chars[i]) == 1) return i;
        }
        return -1;
    }
}

class AnotherSolution {
    public int firstUniqueChar(String s) {
        // 使用数组代替哈希表，比哈希表快36ms，击败97
        int[] arr = new int[26];
        char[] chars = s.toCharArray();
        int len = chars.length;
        for (char c : chars) {
            arr[c - 'a']++;
        }
        for (int i = 0; i < len; i++) {
            if (arr[chars[i] - 'a'] == 1) return i;
        }
        return -1;
    }
}
