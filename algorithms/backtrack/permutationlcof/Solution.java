package blogandquestion.algorithms.backtrack.permutationlcof;

import java.util.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/23 11:17:24
 * description:
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 *
 *  
 *
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 *
 *  
 *
 * 示例:
 *
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 *  
 *
 * 限制：
 *
 * 1 <= s 的长度 <= 8
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof
 *
 */
public class Solution {
    public String[] permutation(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        List<String> list = new ArrayList<>();
        int n = chars.length;
        boolean[] used = new boolean[n];
        dfs(list, chars, "", used);
        String[] res = new String[list.size()];
        int i = 0;
        for (String str : list) res[i++] = str;
        return res;
    }

    public void dfs(List<String> list, char[] chars, String s, boolean[] used) {
        if (s.length() == chars.length) {
            list.add(s);
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (i > 0 && chars[i] == chars[i - 1] && !used[i - 1]) continue;
            if (used[i]) continue;
            used[i] = true;
            s += chars[i];
            dfs(list, chars, s, used);
            s = s.substring(0, s.length() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String test = "aab";
        String[] res = s.permutation(test);
        System.out.println(Arrays.toString(res));
    }
}

class SetSolution {
    // 利用Set的性质去重，取巧了其实，如果元素不是String而是数组或者其他对象，就没有办法复用了
    public String[] permutation(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        Set<String> list = new HashSet<>();
        int n = chars.length;
        boolean[] used = new boolean[n];
        dfs(list, chars, "", used);
        String[] res = new String[list.size()];
        int i = 0;
        for (String str : list) res[i++] = str;
        return res;
    }

    public void dfs(Set<String> list, char[] chars, String s, boolean[] used) {
        if (s.length() == chars.length) {
            list.add(s);
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (used[i]) continue;
            used[i] = true;
            s += chars[i];
            dfs(list, chars, s, used);
            s = s.substring(0, s.length() - 1);
            used[i] = false;
        }
    }
}

class ThirdSolution {
    public String[] permutation(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        List<String> res = new ArrayList<>();
        int n = chars.length;
        boolean[] used = new boolean[n];
        dfs(res, chars, new StringBuilder(), used);
        return res.toArray(new String[0]);
    }

    public void dfs(List<String> list, char[] chars, StringBuilder s, boolean[] used) {
        if (s.length() == chars.length) {
            list.add(s.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (i > 0 && chars[i] == chars[i - 1] && !used[i - 1]) continue;
            if (!used[i]) {
                used[i] = true;
                s.append(chars[i]);
                dfs(list, chars, s, used);
                s.deleteCharAt(s.length() - 1);
                used[i] = false;
            }
        }
    }
}
