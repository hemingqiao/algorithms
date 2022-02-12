package src.stack.monotonestack.nextgreaterelements503;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/03/06 09:11:01
 * description:
 */
public class ExerciseSolution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ret = new int[n];
        // 找不到下一个更大的元素时，以结果为-1，初始化时以-1填充数组
        for (int i = 0; i < n; i++) ret[i] = -1;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n * 2; i++) {
            int num = nums[i % n];
            while (!stack.isEmpty() && nums[stack.peek()] < num) {
                ret[stack.pop()] = num;
            }
            // 当i大于等于n时，就不再推入栈中了
            // 因为 ret 的长度必须是n，超过n的部分只是为了给之前栈中的数字找其后面的较大值，所以不能压入栈
            if (i < n) stack.push(i);
        }
        return ret;
    }
}
