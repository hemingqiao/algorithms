package blogandquestion.algorithms.numbers.findmaxconsecutiveones487;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/02/19 09:18:11
 * description:
 * 给定一个二进制数组，你可以最多将 1 个 0 翻转为 1，找出其中最大连续 1 的个数。
 *
 * 示例 1：
 *
 * 输入：[1,0,1,1,0]
 * 输出：4
 * 解释：翻转第一个 0 可以得到最长的连续 1。
 *      当翻转以后，最大连续 1 的个数为 4。
 *  
 *
 * 注：
 *
 * 输入数组只包含 0 和 1.
 * 输入数组的长度为正整数，且不超过 10,000
 *  
 *
 * 进阶：
 * 如果输入的数字是作为 无限流 逐个输入如何处理？换句话说，内存不能存储下所有从流中输入的数字。您可以有效地解决吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-consecutive-ones-ii
 *
 * 参考：https://www.cnblogs.com/grandyang/p/6376115.html
 */
public class Solution {
    // 这题是1004的简化版，1004最多允许将k个0翻转为1
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length, cnt = 0, res = 0, k = 1;
        int left = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) ++cnt;
            while (cnt > k) {
                if (nums[left] == 0) --cnt;
                ++left;
            }
            res = Math.max(res, i - left + 1);
        }
        return res;
    }


    // follow up
    // 上面那种方法对于 follow up 中的情况无法使用，因为 nums[left] 需要访问之前的数字。可以用一个队列将遇到的0的位置全都保存下来，这样需要
    // 移动 left 的时候可以直接从队列中出队最前面的0的位置，就知道需要移到哪里了
    public int findMaxConsecutiveOnes1(int[] nums) {
        int n = nums.length, res = 0, k = 1;
        int left = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) queue.add(i);
            if (queue.size() > k) {
                left = queue.poll() + 1;
            }
            res = Math.max(res, i - left + 1);
        }
        return res;
    }
}
