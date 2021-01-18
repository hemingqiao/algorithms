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
