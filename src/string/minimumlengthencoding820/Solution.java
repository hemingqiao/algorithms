package src.string.minimumlengthencoding820;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/04/19 13:33:05
 * description:
 */
public class Solution {
    public int minimumLengthEncoding(String[] words) {
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });
        StringBuilder sb = new StringBuilder();
        for (String s : words) {
            int index = sb.indexOf(s + "#");
            if (index == -1) {
                sb.append(s).append("#");
            }
        }
        return sb.length();
    }
}
