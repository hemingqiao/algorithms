package blogandquestion.algorithms.hashtable.findwords500;

import java.util.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/02 16:09:52
 * description:
 */
public class Solution {
    public String[] findWords(String[] words) {
        char[] r1 = new char[]{'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'};
        char[] r2 = new char[]{'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l'};
        char[] r3 = new char[]{'z', 'x', 'c', 'v', 'b', 'n', 'm'};
        Map<Character, Integer> row1 = new HashMap<>();
        Map<Character, Integer> row2 = new HashMap<>();
        Map<Character, Integer> row3 = new HashMap<>();
        for (char c : r1) row1.put(c, 1);
        for (char c : r2) row2.put(c, 1);
        for (char c : r3) row3.put(c, 1);
        List<String> res = new ArrayList<>();
        for (String word : words) {
            String w = word.toLowerCase();
            char[] chars = w.toCharArray();
            char t = chars[0];
            boolean flag = true;
            if (row1.containsKey(t)) {
                for (char c : chars) {
                    if (row1.get(c) == null) {
                        flag = false;
                        break;
                    }
                }
            } else if (row2.containsKey(t)) {
                for (char c : chars) {
                    if (row2.get(c) == null) {
                        flag = false;
                        break;
                    }
                }
            } else {
                for (char c : chars) {
                    if (row3.get(c) == null) {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) {
                res.add(word);
            }
        }
        String[] ret = new String[res.size()];
        int p = 0;
        for (String str : res) {
            ret[p++] = str;
        }
        return ret;
    }
}
