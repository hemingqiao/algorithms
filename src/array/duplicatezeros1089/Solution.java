package src.array.duplicatezeros1089;

import java.util.Arrays;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/02 16:44:31
 * description:
 * 给你一个长度固定的整数数组 arr，请你将该数组中出现的每个零都复写一遍，并将其余的元素向右平移。
 *
 * 注意：请不要在超过该数组长度的位置写入元素。
 *
 * 要求：请对输入的数组 就地 进行上述修改，不要从函数返回任何东西。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[1,0,2,3,0,4,5,0]
 * 输出：null
 * 解释：调用函数后，输入的数组将被修改为：[1,0,0,2,3,0,0,4]
 * 示例 2：
 *
 * 输入：[1,2,3]
 * 输出：null
 * 解释：调用函数后，输入的数组将被修改为：[1,2,3]
 *  
 *
 * 提示：
 *
 * 1 <= arr.length <= 10000
 * 0 <= arr[i] <= 9
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/duplicate-zeros
 *
 */
public class Solution {
    public void duplicateZeros(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0 && i + 1 < n) {
                move(arr, i + 1, n);
                arr[i + 1] = 0;
                i++;
            }
        }
    }

    private void move(int[] arr, int start, int len) {
//        for (int i = len - 2; i >= start; i--) {
//            arr[i + 1] = arr[i];
//        }
        // 调用arraycopy方法执行时间从上面循环的16ms降到1ms
        if (len - 1 - start >= 0) System.arraycopy(arr, start, arr, start + 1, len - 1 - start);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] test = new int[]{0,2,0,4,5};
        s.duplicateZeros(test);
        System.out.println(Arrays.toString(test));
    }
}
