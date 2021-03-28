package blogandquestion.algorithms.topk.maxslidingwindow239;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/12/24 14:38:06
 * description:
 * 给你一个zheng's数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回滑动窗口中的最大值。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * 示例 2：
 *
 * 输入：nums = [1], k = 1
 * 输出：[1]
 * 示例 3：
 *
 * 输入：nums = [1,-1], k = 1
 * 输出：[1,-1]
 * 示例 4：
 *
 * 输入：nums = [9,11], k = 2
 * 输出：[11]
 * 示例 5：
 *
 * 输入：nums = [4,-2], k = 2
 * 输出：[4]
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 10^5
 * -104 <= nums[i] <= 10^4
 * 1 <= k <= nums.length
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sliding-window-maximum
 *
 */
public class AnotherSolution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < 2) return nums;
        Deque<Integer> queue = new ArrayDeque<>();
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            // 维护一个递增的双向队列
            // 如果队列非空，且当前位置的值大于队列尾部的值，弹出队列尾部的值，继续进行判断
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
                queue.pollLast();
            }
            queue.addLast(i);
            // 窗口右侧索引为R，左侧索引为L，窗口长度为k，则L = R - 1 - k
            // 如果queue.peek() < i - k，代表队列首的元素不在窗口内了，需要从队列中弹出
            if (queue.peek() <= i - k) {
                queue.poll();
            }
            // i - k = -1时，窗口形成
            if (i - k >= -1) {
                result[i - k + 1] = nums[queue.peek()];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        AnotherSolution s = new AnotherSolution();
        int[] test = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] res = s.maxSlidingWindow(test, k);
        System.out.println(Arrays.toString(res));
    }
}

/**
 * 另外一种思路
 * @see https://github.com/grandyang/leetcode/issues/239
 */
class ThirdSolution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> queue = new ArrayDeque<>();
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            // 如果队列头部元素是i - k的话，表明窗口右移一位，需要移除队列头部元素
            if (!queue.isEmpty() && nums[queue.peek()] == i - k) {
                queue.poll();
            }
            // 维护一个递增的双向队列
            // 如果队列非空，且当前位置的值大于队列尾部的值，弹出队列尾部的值，继续进行判断
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
                queue.pollLast();
            }
            queue.addLast(i);
            // i - k = -1时，窗口形成
            if (i - k >= -1) {
                result[i - k + 1] = nums[queue.peek()];
            }
        }
        return result;
    }
}
