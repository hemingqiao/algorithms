package src.topk.kthlargest703;

import java.util.PriorityQueue;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/02/11 09:09:26
 * description:
 */
public class KthLargest1 {
    // 整个骚操作
    private PriorityQueue<Integer> queue;
    private int capacity;

    public KthLargest1(int k, int[] nums) {
        queue = new PriorityQueue<>(k);
        capacity = k;
        for (int num : nums) add(num);
    }

    public int add(int val) {
        if (queue.size() < capacity) {
            queue.offer(val);
        } else if (queue.peek() < val) {
            queue.poll();
            queue.offer(val);
        }
        return queue.peek();
    }
}
