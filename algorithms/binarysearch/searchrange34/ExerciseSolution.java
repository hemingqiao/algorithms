package blogandquestion.algorithms.binarysearch.searchrange34;

import java.util.Arrays;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/17 21:45:54
 * description:
 */
public class ExerciseSolution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) return new int[]{-1, -1};
        int left = 0, right = n;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        // 当数组中不存在目标值时，搜索得到的位置可能是数组的长度（n）或者该位置对应的值最接近target，而不是等于target
        // 需要先判断得到的位置是否为n，否则访问n会抛出数组越界异常
        if (left == n || nums[left] != target) return new int[]{-1, -1};
        int p = left + 1;
        while (p < n && nums[p] == target) {
            p++;
        }
        return new int[]{left, p - 1};
    }

    public static void main(String[] args) {
        ExerciseSolution es = new ExerciseSolution();
        int[] test = new int[]{0, 1, 3, 3, 3, 3, 5, 6};
        int[] res = es.searchRange(test, 2);
        System.out.println(Arrays.toString(res));
    }
}
