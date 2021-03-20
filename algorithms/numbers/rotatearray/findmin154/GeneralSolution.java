package blogandquestion.algorithms.numbers.rotatearray.findmin154;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/10 20:13:32
 * description: 一个通用的解决这四道旋转升序数组的思路
 */
public class GeneralSolution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            // 此时[mid, right]区间是递增的，最小值一定在mid及mid左边，mid不能排除掉（因为 mid 可能就是最小值）
            if (nums[mid] < nums[right]) {
                right = mid;
            } else if (nums[mid] > nums[right]) {
                // 此时[left, mid]区间是递增的，最小值一定在mid的右边
                left = mid + 1;
            } else {
                // 此时nums[mid] == nums[right]，因为数组中存在重复数字，如[3，1，3，3，3，3，3]和[3，3，3，3，3，1，3]
                // 无法确定最小值在mid的左边还是在mid的右边。
                // 此时可以令right--，因为即使right处就是最小值，mid处的值等于right处的值，不会把最小值排除掉
                right--;
            }
        }
        // 当查找范围的长度为 1 时或者数组长度为 1 时，返回
        return nums[left];
    }
}
