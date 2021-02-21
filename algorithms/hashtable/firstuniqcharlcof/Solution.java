package blogandquestion.algorithms.hashtable.firstuniqcharlcof;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/02/21 22:09:06
 * description:
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 *
 * 示例:
 *
 * s = "abaccdeff"
 * 返回 "b"
 *
 * s = ""
 * 返回 " "
 *  
 *
 * 限制：
 *
 * 0 <= s 的长度 <= 50000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof
 *
 */
public class Solution {
    public char firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        if (n == 0) return ' ';
        int[] cnt = new int[26];
        for (int i = 0; i < n; i++) {
            ++cnt[chars[i] - 'a'];
        }
        char ret = ' ';
        for (int i = 0; i < n; i++) {
            if (cnt[chars[i] - 'a'] == 1) return chars[i];
        }
        return ret;
    }

    // 外层循环只需要遍历常数次（26次），内层的indexOf和lastIndexOf的时间复杂度是O(n)
    // 总的时间复杂度是O(n)
    public char firstUniqChar1(String s) {
        int index = Integer.MAX_VALUE;
        char ret = ' ';
        for (char i = 'a'; i <= 'z'; i++) {
            int first = s.indexOf(i);
            int last = s.lastIndexOf(i);
            if (first != -1 && first == last && first < index) {
                ret = i;
                index = first;
            }
        }
        return ret;
    }


    /* HashTable Solutions */

    public char firstUniqChar2(String s) {
        HashMap<Character, Boolean> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            map.put(c, !map.containsKey(c));
        }
        for (char c : chars) {
            if (map.get(c)) return c;
        }
        return ' ';
    }


    /**
     * 参考：https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/solution/mian-shi-ti-50-di-yi-ge-zhi-chu-xian-yi-ci-de-zi-3/
     * 参考：https://blog.csdn.net/justloveyou_/article/details/71713781
     * @see LinkedHashMap
     * @param s 源字符串
     * @return
     */
    public char firstUniqChar3(String s) {
        // LinkedHashMap保证了map中元素的顺序就是它们最初放置到map中的顺序
        // 即map中字符的顺序和源字符串中字符出现顺序一致
        LinkedHashMap<Character, Boolean> map = new LinkedHashMap<>();
        char[] chars = s.toCharArray();
        for (char c : chars) map.put(c, !map.containsKey(c));
        for (Map.Entry<Character, Boolean> entry : map.entrySet()) {
            if (entry.getValue()) return entry.getKey();
        }
        return ' ';
    }
}
