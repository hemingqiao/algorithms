package src.heap.medianfinder295;

import java.util.PriorityQueue;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/08/28 10:41:46
 * description:
 */
public class MedianFinder {
    PriorityQueue<Integer> upper = new PriorityQueue<>();
    PriorityQueue<Integer> lower = new PriorityQueue<>((a, b) -> b - a);

    /** initialize your data structure here. */
    public MedianFinder() {

    }

    public void addNum(int num) {
        if (lower.size() == 0 || num <= lower.peek()) {
            lower.offer(num);
            if (lower.size() > upper.size() + 1) {
                upper.offer(lower.poll());
            }
        } else {
            upper.offer(num);
            if (upper.size() > lower.size()) {
                lower.offer(upper.poll());
            }
        }
    }

    public double findMedian() {
        if ((lower.size() + upper.size()) % 2 == 0) return (lower.peek() + upper.peek()) / 2.0;
        return lower.peek();
    }
}
