package src.doublepointer.minwindow76;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/11 11:58:09
 * description: 双指针，滑动窗口。
 *
 * 给你一个字符串 S、一个字符串 T 。请你设计一种算法，可以在 O(n) 的时间复杂度内，从字符串 S 里面找出：包含 T 所有字符的最小子串。
 *
 *  
 *
 * 示例：
 *
 * 输入：S = "ADOBECODEBANC", T = "ABC"
 * 输出："BANC"
 *  
 *
 * 提示：
 *
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-window-substring
 *
 * 解题思路：
 * see: https://leetcode-cn.com/problems/minimum-window-substring/solution/tong-su-qie-xiang-xi-de-miao-shu-hua-dong-chuang-k/
 * see: https://leetcode-cn.com/problems/minimum-window-substring/solution/yi-bu-bu-xing-cheng-hua-dong-chuang-kou-si-lu-shen/
 */
public class Solution {
    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0) {
            return "";
        }
        int[] need = new int[128];
        // 记录需要的字符的个数
        for (int i = 0; i < t.length(); i++) {
            need[t.charAt(i)]++;
        }
        // l是当前左边界，r是当前右边界，size记录窗口大小，count是需求的字符个数，start是最小覆盖串开始的index
        int l = 0, r = 0, size = Integer.MAX_VALUE, count = t.length(), start = 0;
        // 遍历所有字符
        while (r < s.length()) {
            char c = s.charAt(r);
            if (need[c] > 0) { // 需要字符c
                count--;
            }
            need[c]--; // 把右边的字符加入窗口
            if (count == 0) {//窗口中已经包含所有字符
            	// 缩减窗口
                while (l < r && need[s.charAt(l)] < 0) {
                    need[s.charAt(l)]++;
                    l++;// 左指针右移
                }
                if (r - l + 1 < size) { // 左指针不能右移时候调整最小窗口大小，更新最小窗口开始的start
                    size = r - l + 1;
                    start = l; // 记录下最小值时候的开始位置，最后返回覆盖串时候会用到
                }
                // 左边界右移，此时窗口不在满足条件，需要右移窗口，开始下一轮求解
                need[s.charAt(l)]++;
                l++;
                count++;
            }
            r++;
        }
        return size == Integer.MAX_VALUE ? "" : s.substring(start, start + size);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        Solution sl = new Solution();
        String result = sl.minWindow(s, t);
        System.out.println(result);
    }
}
