package src.leetcodeweeklycontest.d48;

import java.util.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/03/21 10:16:15
 * description:
 * 给你一个混合字符串 s ，请你返回 s 中 第二大 的数字，如果不存在第二大的数字，请你返回 -1 。
 *
 * 混合字符串 由小写英文字母和数字组成。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "dfa12321afd"
 * 输出：2
 * 解释：出现在 s 中的数字包括 [1, 2, 3] 。第二大的数字是 2 。
 * 示例 2：
 *
 * 输入：s = "abc1111"
 * 输出：-1
 * 解释：出现在 s 中的数字只包含 [1] 。没有第二大的数字。
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 500
 * s 只包含小写英文字母和（或）数字。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/second-largest-digit-in-a-string
 *
 */
public class One {
    public int secondHighest(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>(); // 用Set来去重
        for (int i = 0; i < n; i++) {
            if (chars[i] >= '0' && chars[i] <= '9' && !set.contains(chars[i] - '0')) {
                list.add(chars[i] - '0');
                set.add(chars[i] - '0');
            }
        }
        Collections.sort(list);
        if (list.size() > 1) return list.get(list.size() - 2);
        return -1;
    }

    public static void main(String[] args) {
        One one = new One();
        String test = "dfa12321afd";
        int res = one.secondHighest(test);
        System.out.println(res);
    }

    // 利用数组记录出现的数字，并从后向前遍历
    // 参考：https://leetcode-cn.com/problems/second-largest-digit-in-a-string/solution/java-shu-zu-by-wyyang-acvv-z8wy/
    public int secondHighest1(String s) {
        int[] cnt = new int[10];
        char[] chars = s.toCharArray();
        int n = chars.length;
        for (int i = 0; i < n; i++) {
            char t = chars[i];
            if (t >= '0' && t <= '9') ++cnt[t - '0'];
        }
        boolean hasFirst = false;
        for (int j = 9; j >= 0; j--) {
            if (cnt[j] > 0 && !hasFirst) {
                hasFirst = true;
            } else if (cnt[j] > 0) {
                return j;
            }
        }
        return -1;
    }
}
