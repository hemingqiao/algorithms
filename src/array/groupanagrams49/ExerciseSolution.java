package src.array.groupanagrams49;

import java.util.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/26 21:10:30
 * description:
 * 二刷
 */
public class ExerciseSolution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ret = new ArrayList<>();
        if (strs == null || strs.length == 0) return ret;
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String temp = String.valueOf(chars);
            if (!map.containsKey(temp)) {
                map.put(temp, new ArrayList<>());
            }
            map.get(temp).add(str);
        }
        for (List<String> l : map.values()) {
            ret.add(l);
        }
        return ret;
    }
}
