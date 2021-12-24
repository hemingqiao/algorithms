package blogandquestion.algorithms.stack.myqueue232;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/03/05 08:31:01
 * description:
 */
public class ExerciseSolution {
    static class MyQueue {
        private Deque<Integer> stdin = new ArrayDeque<>();
        private Deque<Integer> stdout = new ArrayDeque<>();

        /**
         * Initialize your data structure here.
         */
        public MyQueue() {

        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            stdin.push(x);
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            if (stdout.isEmpty()) {
                while (!stdin.isEmpty()) {
                    stdout.push(stdin.pop());
                }
            }
            return stdout.pop();
        }

        /**
         * Get the front element.
         */
        public int peek() {
            int ret = this.pop();
            stdout.push(ret);
            return ret;
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return stdin.isEmpty() && stdout.isEmpty();
        }
    }
}
