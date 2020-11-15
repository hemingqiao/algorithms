package blogandquestion.algorithms.backtrack.partition131;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/15 10:04:56
 * description:
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 *
 * 返回 s 所有可能的分割方案。
 *
 * 示例:
 *
 * 输入: "aab"
 * 输出:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-partitioning
 *
 * 解题思路
 * see: https://mp.weixin.qq.com/s/Pb1epUTbU8fHIht-g_MS5Q
 */
public class Solution {
    List<List<String>> res = new ArrayList<>();
    List<String> path = new ArrayList<>();

    public List<List<String>> partition(String s) {
        backtracking(s, 0);
        return res;
    }

    private void backtracking(String s, int startIndex) {
        if (startIndex >= s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            // 判断startIndex到i之间的字符串是否回文
            if (isPalindrome(s, startIndex, i)) {
                String str = s.substring(startIndex, i + 1);
                path.add(str);
            } else {
                continue;
            }
            backtracking(s, i + 1); // 回溯
            path.remove(path.size() - 1); // 撤销之前的选择
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        //char[] chars = s.toCharArray(); // 转成char数组会很耗费时间
        for (int i = start, j = end; i < j; i++, j--) {
            //if (chars[i] != chars[j]) return false;
            if (s.charAt(i) != s.charAt(j)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<String>> res = s.partition("aab");
        System.out.println(res);
    }
}

class SolutionOpt {
    List<List<String>> res = new ArrayList<>();
    List<String> path = new ArrayList<>();

    public List<List<String>> partition(String s) {
        backtracking(s, 0);
        return res;
    }

    private void backtracking(String s, int startIndex) {
        if (startIndex >= s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            // 判断startIndex到i之间的字符串是否回文
            if (isPalindrome(s, startIndex, i)) {
                String str = s.substring(startIndex, i + 1);
                path.add(str);
                // 可以把后续回溯写道if里面，因为只有当前字串是会问才会继续进行下去
                backtracking(s, i + 1); // 回溯
                path.remove(path.size() - 1); // 撤销之前的选择
            } else {
                continue;
            }
        }
    }

    private boolean isPalindrome(String s, int start, int end) {
        //char[] chars = s.toCharArray(); // 转成char数组会很耗费时间
        for (int i = start, j = end; i < j; i++, j--) {
            //if (chars[i] != chars[j]) return false;
            if (s.charAt(i) != s.charAt(j)) return false;
        }
        return true;
    }
}
