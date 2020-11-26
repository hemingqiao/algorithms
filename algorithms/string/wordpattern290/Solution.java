package blogandquestion.algorithms.string.wordpattern290;

import java.util.HashMap;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/26 16:26:49
 * description:
 */
public class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] strings = s.split(" "); // 以空格分割s
        if (pattern.length() != strings.length) return false;

        char[] patterns = pattern.toCharArray();
        int len = patterns.length;
        int[] charsP = new int[128];
        //int[] charsS = new int[128];
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            // 如果是首次出现，进行赋值
            if (charsP[patterns[i]] == 0) {
                charsP[patterns[i]] = i + 1;
            }
            if (map.getOrDefault(strings[i], 0) == 0) {
                map.put(strings[i], i + 1);
            }
            if (charsP[patterns[i]] != map.get(strings[i])) {
                return false;
            }
        }
        return true;
    }
}
