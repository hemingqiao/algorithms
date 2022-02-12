package src.numbers.rotatearray.findmin153;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/04/08 12:58:34
 * description:
 * 三刷
 */
public class ExerciseSolution1 {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) >>> 1;
            // nums[mid]大于nums[right]，表明最小值在mid的右边
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else { // 否则，最小值出现在mid的左边，此时不能排除mid就是最小值的可能性
                right = mid;
            }
        }
        return nums[left];
    }
}
