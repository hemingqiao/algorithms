package src.stack.mystack225;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/18 21:35:39
 * description:
 */
public class MyStack {
    Queue<Integer> queue;
    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        this.queue = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        // 把要压入的元素入队，然后把这个新入队元素之前的元素依次出队再入队，依次来模拟栈后进先出的特性
        queue.add(x);
        for (int i = 0; i < queue.size() - 1; i++) {
            queue.add(queue.remove());
        }
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return queue.remove();
    }

    /**
     * Get the top element.
     */
    public int top() {
        return queue.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue.isEmpty();
    }
}
