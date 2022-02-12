package src.stack.minstack;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/01 11:57:05
 * description:
 * 单独实现一个最小栈
 * 参考：https://leetcode-cn.com/problems/min-stack-lcci/solution/dan-ge-zhan-he-shuang-zhan-gong-3chong-jie-jue-fan/
 */
public class AnotherSolution {
    class MinStack {
        private ListNode head; // 链表头，相当于栈顶

        // 压栈，需要进行判空
        public void push(int x) {
            if (isEmpty()) head = new ListNode(x, x, null);
            else head = new ListNode(x, Math.min(x, head.min), head);
        }

        // 出栈，相当于把链表头删除
        public void pop() {
            if (isEmpty()) {
                throw new IllegalStateException("stack is empty");
            }
            head = head.next;
        }

        // 栈顶的值也就是链表头部的值
        public int top() {
            if (isEmpty()) {
                throw new IllegalStateException("stack is empty");
            }
            return head.val;
        }

        // 链表头部的min属性保存的就是整个链表中的最小值
        public int getMin() {
            if (isEmpty()) {
                throw new IllegalStateException("stack is empty");
            }
            return head.min;
        }

        public boolean isEmpty() {
            return head == null;
        }
    }

    class ListNode {
        public int val;
        public int min; // 保存栈中的最小值
        public ListNode next;

        public ListNode(int val, int min, ListNode next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
}
