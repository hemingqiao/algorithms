package src.numbers.longestones1004;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/02/19 09:18:40
 * description:
 * 给定一个由若干 0 和 1 组成的数组 A，我们最多可以将 K 个值从 0 变成 1 。
 *
 * 返回仅包含 1 的最长（连续）子数组的长度。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
 * 输出：6
 * 解释：
 * [1,1,1,0,0,1,1,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 6。
 * 示例 2：
 *
 * 输入：A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
 * 输出：10
 * 解释：
 * [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 10。
 *  
 *
 * 提示：
 *
 * 1 <= A.length <= 20000
 * 0 <= K <= A.length
 * A[i] 为 0 或 1 
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-consecutive-ones-iii
 *
 *
 * 相关题目：485，487
 * 参考：https://github.com/grandyang/leetcode/issues/1004
 */
public class Solution {
    public int longestOnes(int[] A, int K) {
        int n = A.length, cnt = 0, res = 0;
        int left = 0;
        // 维护一个窗口，窗口中的0的数量不超过K
        for (int i = 0; i < n; i++) {
            if (A[i] == 0) ++cnt;
            // 如果窗口中0的数量大于K了，将窗口左边界右移，直到窗口中0的数量小于等于K
            while (cnt > K) {
                if (A[left] == 0) --cnt;
                ++left;
            }
            // 窗口每向右移动一次，就更新一次结果
            res = Math.max(res, i - left + 1);
        }
        return res;
    }
}
