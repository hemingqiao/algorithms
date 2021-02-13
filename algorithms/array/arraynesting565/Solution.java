package blogandquestion.algorithms.array.arraynesting565;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/05 17:30:34
 * description:
 */
public class Solution {
    public int arrayNesting(int[] nums) {
        int n = nums.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            int cnt = 1;
            while (nums[i] != i) {
                swap(nums, nums[i], nums[nums[i]]);
                cnt++;
            }
            res = Math.max(cnt, res);
        }
        return res;
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
