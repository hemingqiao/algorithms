package blogandquestion.algorithms.numbers.rotatearray.findmin154;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/06/26 11:08:45
 * description:
 */
public class ExerciseSolution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (r >= 0 && nums[r] == nums[l]) r--;
        if (r < 0) return nums[l];
        if (nums[l] < nums[r]) return nums[l]; // 如果去除尾部和头部所有的相同元素后，序列单调递增，直接返回第一个元素，例 [1, 2, 3, 1]
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] < nums[0]) r = mid;
            else l = mid + 1;
        }
        return nums[l];
    }
}
