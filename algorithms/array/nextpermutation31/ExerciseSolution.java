package blogandquestion.algorithms.array.nextpermutation31;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/21 19:00:08
 * description:
 * 二刷，这题理解的还是不到位
 * 参考：https://leetcode-cn.com/problems/next-permutation/solution/xia-yi-ge-pai-lie-suan-fa-xiang-jie-si-lu-tui-dao-/
 */
public class ExerciseSolution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        if (n == 0) return;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i + 1] > nums[i]) {
                int j;
                for (j = n - 1; j >= 0; j--) {
                    if (nums[j] > nums[i]) {
                        break;
                    }
                }
                swap(nums, i, j);
                reverse(nums, i + 1, n - 1);
                return;
            }
        }
        // 如果没有进入上面的循环，表明数组是降序的，直接反转
        reverse(nums, 0, n - 1);
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start++] = arr[end];
            arr[end--] = temp;
        }
    }
}
