package blogandquestion.algorithms.array.isuniquelcci;

import java.util.Arrays;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/02/20 21:10:17
 * description:
 * 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
 *
 * 示例 1：
 *
 * 输入: s = "leetcode"
 * 输出: false
 * 示例 2：
 *
 * 输入: s = "abc"
 * 输出: true
 * 限制：
 *
 * 0 <= len(s) <= 100
 * 如果你不使用额外的数据结构，会很加分。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/is-unique-lcci
 *
 */
public class Solution {
    // 关于本题：https://leetcode-cn.com/problems/is-unique-lcci/comments/562374

    // 最开始想到的就是利用数组作为哈希表
    public boolean isUnique(String s) {
        int[] cnt = new int[128];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char t = s.charAt(i);
            ++cnt[t];
            if (cnt[t] > 1) return false;
        }
        return true;
    }

    // 上面解法用到了数组，如果不用其他数据结构，得用位运算
    // 但是位运算也有限制：如得是ASCII范围内的字符，如果是Unicode字符，还是老老实实排序吧
    public boolean isUnique1(String s) {
        // 参考：https://leetcode-cn.com/problems/is-unique-lcci/solution/java-wei-yun-suan-by-npe_tle-2/
        return false;
    }

    // 或者排序
    public boolean isUnique2(String s) {
        if (s == null) return true;
        char[] chars = s.toCharArray();
        int n = chars.length;
        Arrays.sort(chars);
        for (int i = 1; i < n; i++) {
            if (chars[i] == chars[i - 1]) return false;
        }
        return true;
    }
}
