package blogandquestion.algorithms.stack.minstack155;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/23 14:24:01
 * description:
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 *  
 *
 * 示例:
 *
 * 输入：
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 *
 * 输出：
 * [null,null,null,null,-3,null,0,-2]
 *
 * 解释：
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 *  
 *
 * 提示：
 *
 * pop、top 和 getMin 操作总是在 非空栈 上调用。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/min-stack
 *
 * 参考：https://leetcode-cn.com/problems/min-stack/solution/155-zui-xiao-zhan-3chong-jie-jue-fang-shi-by-sdwwl/
 */
public class MinStack {
    // head相当于栈顶
    public ListNode head;
    /** initialize your data structure here. */
    public MinStack() {

    }

    // 压栈，需要判断栈是否为空
    public void push(int x) {
        if (isEmpty()) {
            head = new ListNode(x, x, null);
        } else {
            head = new ListNode(x, Math.min(x, head.min), head);
        }
    }

    // 出栈，需要判断栈是否为空
    // 注意这里的pop没有返回值
    public void pop() {
        if (isEmpty()) {
            throw new IllegalStateException("stack is empty");
        }
        head = head.next;
    }

    // 需要判断栈是否为空
    public int top() {
        if (isEmpty()) {
            throw new IllegalStateException("stack is empty");
        }
        return head.val;
    }

    // 需要判断栈是否为空
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
    public int min;
    public ListNode next;

    public ListNode(int val, int min, ListNode next) {
        this.val = val;
        this.min = min;
        this.next = next;
    }
}
