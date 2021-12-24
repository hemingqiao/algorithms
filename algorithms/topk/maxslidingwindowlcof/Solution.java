package blogandquestion.algorithms.topk.maxslidingwindowlcof;

import java.util.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/03/28 19:37:45
 * description:
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 *
 * 示例:
 *
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *  
 *
 * 提示：
 *
 * 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。
 *
 * 注意：本题与主站 239 题相同：https://leetcode-cn.com/problems/sliding-window-maximum/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof
 *
 */
public class Solution {
    // AC
    // 使用大顶堆，定义一种数据结构存放索引和索引对应的值
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) return new int[0];
        int[] ret = new int[n - k + 1];
        PriorityQueue<Pair> queue = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o2.value - o1.value;
            }
        });
        int left = 0;
        for (int i = 0; i < n; i++) {
            // 堆非空，且堆顶元素已经处于窗口之外时，移除堆顶元素
            while (!queue.isEmpty() && queue.peek().index <= i - k) {
                queue.poll();
            }
            queue.offer(new Pair(nums[i], i));
            if (i - left + 1 >= k) {
                ret[left++] = queue.peek().value;
            }
        }
        return ret;
    }

    static class Pair {
        int value;
        int index;

        Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        int[] test = new int[]{9, 10, 9, -7, -4, -8, 2, -6};
        Solution s = new Solution();
        int[] res = s.maxSlidingWindow(test, 5);
        System.out.println(Arrays.toString(res));
    }

    public int[] maxSlidingWindow1(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) return new int[0];
        Deque<Integer> queue = new ArrayDeque<>();
        int[] ret = new int[n - k + 1];
        int left = 0;
        for (int i = 0; i < n; i++) {
            // 维护一个单调递增的双端队列
            // 如果队列非空，且当前位置元素的值大于队列尾部元素对应的值，不断弹出队列尾部的值
            while (!queue.isEmpty() && nums[i] > nums[queue.peekLast()]) {
                queue.pollLast();
            }
            queue.offer(i);
            // 如果队列头部的元素已经移出窗口，将其从队列头部弹出
            if (queue.peek() <= i - k) {
                queue.poll();
            }
            // 窗口长度满足要求
            if (i - left + 1 >= k) {
                ret[left++] = nums[queue.peek()];
            }
        }
        return ret;
    }
}
