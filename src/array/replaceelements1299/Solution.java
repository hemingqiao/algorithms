package src.array.replaceelements1299;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/12/10 21:48:04
 * description:
 * 给你一个数组 arr ，请你将每个元素用它右边最大的元素替换，如果是最后一个元素，用 -1 替换。
 *
 * 完成所有替换操作后，请你返回这个数组。
 *
 *  
 *
 * 示例：
 *
 * 输入：arr = [17,18,5,4,6,1]
 * 输出：[18,6,6,6,1,-1]
 *  
 *
 * 提示：
 *
 * 1 <= arr.length <= 10^4
 * 1 <= arr[i] <= 10^5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/replace-elements-with-greatest-element-on-right-side
 *
 */
public class Solution {
    public int[] replaceElements(int[] arr) {
        int len = arr.length;
        int[] max = new int[len];
        max[len - 1] = -1;
        int maxVal = arr[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            max[i] = Math.max(maxVal, arr[i + 1]);
            maxVal = max[i];
        }
        return max;
    }
}

class AnotherSolution {
    // 可以修改原数组
    public int[] replaceElements(int[] arr) {
        int len = arr.length;
        int max = arr[len - 1];
        arr[len - 1] = -1;
        for (int i = len - 2; i >= 0; i--) {
            int temp = arr[i];
            arr[i] = max;
            if (temp > max) max = temp; // 如果当前位置值大于max，就更新max
        }
        return arr;
    }
}
