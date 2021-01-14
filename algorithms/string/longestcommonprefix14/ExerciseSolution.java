package blogandquestion.algorithms.string.longestcommonprefix14;

import java.util.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/14 20:06:11
 * description:
 */
public class ExerciseSolution {
    // 二刷
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        if (n == 0) return "";
        StringBuilder ret = new StringBuilder();
        char pre;
        for (int i = 0; i < strs[0].length(); i++) {
            pre = strs[0].charAt(i);
            for (int j = 1; j < n; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != pre) return ret.toString();
            }
            ret.append(pre);
        }
        return ret.toString();
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        }){{
            offer(32);
            offer(1024);
            offer(64);
        }};
        System.out.println(queue);
    }
}
