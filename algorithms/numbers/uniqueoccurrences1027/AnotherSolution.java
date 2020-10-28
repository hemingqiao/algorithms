package blogandquestion.algorithms.uniqueoccurrences1027;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/28 09:02:44
 * description: 直接使用 map.values 初始化 HashSet，相当于获得了去重后结果，再比较 HashSet 的长度是否小于 map.values 的长度。
 * 不过，这种做法必须等到全部数据进入 Set 才知道结果，不能一遇到重复就立即分辨出来。
 * 解题思路
 * see: https://leetcode-cn.com/problems/unique-number-of-occurrences/solution/java-shi-jian-kong-jian-100hashmaphashset-by-magic/
 */
public class AnotherSolution {
    public boolean uniqueOccurrences(int[] arr) {
        if (arr == null) return true;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        Set<Integer> set = new HashSet<>();
        for (int i : map.values()) {
            if (!set.add(i)) return false; // 如果set中已经包含了i，add方法返回false，set不会发生改变
        }
        return true;
    }
}
