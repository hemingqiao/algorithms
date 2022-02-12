package src.leetcodeweeklycontest.c246;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/06/20 11:23:21
 * description: 获取一个字符串的所有子字符串（朴素解法）
 */
public class GetAllSubstring {
    public static void main(String[] args) {
        String test = "foo";
        System.out.println(getAllSubstring(test));
        System.out.println(getAllSubstring1(test));
    }

    public static List<String> getAllSubstring(String s) {
        List<String> ret = new ArrayList<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                ret.add(s.substring(i, j));
            }
        }
        return ret;
    }

    public static List<String> getAllSubstring1(String s) {
        List<String> ret = new ArrayList<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                ret.add(s.substring(j, i));
            }
        }
        return ret;
    }
}
