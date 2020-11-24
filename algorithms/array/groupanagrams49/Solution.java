package blogandquestion.algorithms.array.groupanagrams49;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/24 15:03:20
 * description:
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 说明：
 *
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/group-anagrams
 *
 * 参考：https://leetcode-cn.com/problems/group-anagrams/solution/liang-chong-fang-shi-jie-jue-by-sdwwld/
 */
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] c = new char[26];
            for (char c1 : s.toCharArray()) {
                c[c1 - 'a']++;
            }
            String key = String.valueOf(c);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
