package src.stack.cqueuelcof;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/02/01 22:02:31
 * description:
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 *
 *  
 *
 * 示例 1：
 *
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 * 示例 2：
 *
 * 输入：
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * 输出：[null,-1,null,null,5,2]
 * 提示：
 *
 * 1 <= values <= 10000
 * 最多会对 appendTail、deleteHead 进行 10000 次调用
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
 *
 */
public class CQueue {
    Stack<Integer> in = new Stack<>();
    Stack<Integer> out = new Stack<>();
    int count = 0;
    public CQueue() {

    }

    public void appendTail(int value) {
        in.push(value);
        count++;
    }

    public int deleteHead() {
        if (count == 0) {
            return -1;
        }
        if (out.isEmpty()) {
            while (!in.isEmpty()) out.push(in.pop());
        }
        count--;
        return out.pop();
    }
}


// 使用双端队列比使用Stack慢
class CQueue1 {
    Deque<Integer> in = new ArrayDeque<>();
    Deque<Integer> out = new ArrayDeque<>();
    int count = 0;
    public CQueue1() {

    }

    public void appendTail(int value) {
        in.offer(value);
        count++;
    }

    public int deleteHead() {
        if (count == 0) {
            return -1;
        }
        if (out.isEmpty()) {
            while (!in.isEmpty()) out.offer(in.poll());
        }
        count--;
        return out.poll();
    }
}
