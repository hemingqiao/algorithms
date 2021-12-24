package blogandquestion.algorithms.nowcoder.car;

import java.util.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/03/13 20:34:15
 * description:
 */
public class Solution {
    public int[] replaceElements (int[] arr) {
        // write code here
        int max = -1;
        int n = arr.length;
        int[] ret = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            ret[i] = max;
            max = Math.max(max, arr[i]);
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] test = new int[]{17,18,5,4,6,1};
        int[] res = s.replaceElements(test);
        System.out.println(Arrays.toString(res));
    }

    // 寻找插入位置，实际上是找大于等于target的第一个元素的位置
    // C++中的lower_bound函数
    public int searchInsertPosition (int[] nums, int target) {
        // write code here
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
