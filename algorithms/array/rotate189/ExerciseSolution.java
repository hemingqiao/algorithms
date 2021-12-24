package blogandquestion.algorithms.array.rotate189;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/03/01 19:59:13
 * description:
 */
public class ExerciseSolution {
    // 使用额外空间
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] copy = new int[n];
        for (int i = 0; i < n; i++) copy[i] = nums[i];
        for (int j = 0; j < n; j++) {
            nums[(j + k) % n] = copy[j];
        }
    }


    // 思路是先把前 n - k 个数翻转一下，再把后 k 个数翻转一下，最后把整个数组翻转一下
    public void rotate1(int[] nums, int k) {
        int n = nums.length;
        int steps = k % n;
        reverse(nums, 0, n - 1 - steps);
        reverse(nums, n - steps, n - 1);
        reverse(nums, 0, n - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            ++start;
            --end;
        }
    }
}
