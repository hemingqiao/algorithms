package blogandquestion.algorithms.greedy.minkbitflips995;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/02/18 09:16:05
 * description:
 * 在仅包含 0 和 1 的数组 A 中，一次 K 位翻转包括选择一个长度为 K 的（连续）子数组，同时将子数组中的每个 0 更改为 1，而每个 1 更改为 0。
 *
 * 返回所需的 K 位翻转的最小次数，以便数组没有值为 0 的元素。如果不可能，返回 -1。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：A = [0,1,0], K = 1
 * 输出：2
 * 解释：先翻转 A[0]，然后翻转 A[2]。
 * 示例 2：
 *
 * 输入：A = [1,1,0], K = 2
 * 输出：-1
 * 解释：无论我们怎样翻转大小为 2 的子数组，我们都不能使数组变为 [1,1,1]。
 * 示例 3：
 *
 * 输入：A = [0,0,0,1,0,1,1,0], K = 3
 * 输出：3
 * 解释：
 * 翻转 A[0],A[1],A[2]: A变成 [1,1,1,1,0,1,1,0]
 * 翻转 A[4],A[5],A[6]: A变成 [1,1,1,1,1,0,0,0]
 * 翻转 A[5],A[6],A[7]: A变成 [1,1,1,1,1,1,1,1]
 *  
 *
 * 提示：
 *
 * 1 <= A.length <= 30000
 * 1 <= K <= A.length
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-number-of-k-consecutive-bit-flips
 *
 * 参考：https://github.com/grandyang/leetcode/issues/995
 */
public class Solution {
    // 队列的大小就是翻转的次数吗？
    public int minKBitFlips(int[] A, int K) {
        int n = A.length;
        Deque<Integer> queue = new ArrayDeque<>();
        int res = 0;
        for (int i = 0; i < n; i++) {
            // 首先检测队首元素是否超出了范围，是的话就扔掉
            if (!queue.isEmpty() && i >= (queue.peekFirst() + K)) {
                queue.pollFirst();
            }
            if (queue.size() % 2 == A[i]) {
                if (i + K > n) return -1;
                queue.add(i);
                ++res;
            }
        }
        return res;
    }
}
