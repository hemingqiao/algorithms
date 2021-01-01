package blogandquestion.algorithms.stack.maxqueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/01 11:24:54
 * description:
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 *
 * 若队列为空，pop_front 和 max_value 需要返回 -1
 *
 * 示例 1：
 *
 * 输入:
 * ["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
 * [[],[1],[2],[],[],[]]
 * 输出: [null,null,null,2,1,2]
 * 示例 2：
 *
 * 输入:
 * ["MaxQueue","pop_front","max_value"]
 * [[],[],[]]
 * 输出: [null,-1,-1]
 *  
 *
 * 限制：
 *
 * 1 <= push_back,pop_front,max_value的总操作数 <= 10000
 * 1 <= value <= 10^5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof
 *
 * 参考：https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof/solution/jian-zhi-offer-59-ii-dui-lie-de-zui-da-z-0pap/
 */
class MaxQueue {
    private final Queue<Integer> queue = new ArrayDeque<>();
    private final Deque<Integer> deque = new ArrayDeque<>();
    public MaxQueue() {

    }

    public int max_value() {
        if (!deque.isEmpty()) {
            return deque.peek();
        }
        return -1;
    }

    public void push_back(int value) {
        queue.add(value);
        while (!deque.isEmpty() && deque.peekLast() < value) {
            deque.pollLast();
        }
        deque.add(value);
    }

    public int pop_front() {
        if (queue.isEmpty()) return -1;
        if (queue.peek().equals(deque.peek())) {
            deque.poll();
        }
        return queue.poll();
    }
}
