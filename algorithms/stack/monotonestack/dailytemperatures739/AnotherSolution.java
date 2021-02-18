package blogandquestion.algorithms.stack.monotonestack.dailytemperatures739;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/02/18 21:14:52
 * description:
 * 这题也是经典的单调栈问题了
 * 参考：https://github.com/grandyang/leetcode/issues/739
 */
public class AnotherSolution {
    // 直接暴力求解
    // 这次提交AC了，不过估计着一段时间之后，就会通过不了了😂
    public int[] dailyTemperature(int[] T) {
        int n = T.length;
        int[] ret = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (T[j] > T[i]) {
                    ret[i] = j - i;
                    break;
                }
            }
        }
        return ret;
    }

    /*
    这道题应该使用递减栈Descending Stack来做，栈里只有递减元素，思路是这样的，遍历数组，如果栈不为空，且当前数字大于栈顶元素，那么如果直接入
    栈的话就不是递减栈了，所以需要取出栈顶元素，那么由于当前数字大于栈顶元素的数字，而且一定是第一个大于栈顶元素的数，所以此时直接求出下标差就是
    二者的距离了，然后继续看新的栈顶元素，直到当前数字小于等于栈顶元素停止，然后将数字入栈，这样就可以一直保持递减栈，且每个数字和第一个大于它的
    数的距离也可以算出来了
     */

    public int[] dailyTemperature1(int[] T) {
        int n = T.length;
        int[] ret = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                int idx = stack.pop();
                ret[idx] = i - idx;
            }
            stack.push(i);
        }
        return ret;
    }
}
