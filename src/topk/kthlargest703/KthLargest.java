package src.topk.kthlargest703;

import java.util.PriorityQueue;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/12/23 17:27:02
 * description:
 * 设计一个找到数据流中第 k 大元素的类（class）。注意是排序后的第 k 大元素，不是第 k 个不同的元素。
 *
 * 请实现 KthLargest 类：
 *
 * KthLargest(int k, int[] nums) 使用整数 k 和整数流 nums 初始化对象。
 * int add(int val) 返回当前数据流中第 k 大的元素。
 *  
 *
 * 示例：
 *
 * 输入：
 * ["KthLargest", "add", "add", "add", "add", "add"]
 * [[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
 * 输出：
 * [null, 4, 5, 5, 8, 8]
 *
 * 解释：
 * KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
 * kthLargest.add(3);   // return 4
 * kthLargest.add(5);   // return 5
 * kthLargest.add(10);  // return 5
 * kthLargest.add(9);   // return 8
 * kthLargest.add(4);   // return 8
 *  
 *
 * 提示：
 * 1 <= k <= 104
 * 0 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * -104 <= val <= 104
 * 最多调用 add 方法 104 次
 * 题目数据保证，在查找第 k 大元素时，数组中至少有 k 个元素
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-a-stream
 *
 */
public class KthLargest {
    // 默认是小顶堆
    private PriorityQueue<Integer> queue = new PriorityQueue<>();
    private int size;

    public KthLargest(int k, int[] nums) {
        this.size = k;
        for (int num : nums) {
            if (queue.size() < k) {
                queue.add(num);
            } else if (num > queue.peek()) {
                // 当前值大于堆顶元素，加入堆
                queue.poll();
                queue.add(num);
            }
        }
    }

    public int add(int val) {
        if (queue.size() < size) {
            queue.add(val);
        } else if (val > queue.peek()) {
            queue.poll();
            queue.add(val);
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        KthLargest kl = new KthLargest(1, new int[]{});
        int r1 = kl.add(-3);
        int r2 = kl.add(-2);
        int r3 = kl.add(-4);
        int r4 = kl.add(0);
        int r5 = kl.add(4);
    }
}
