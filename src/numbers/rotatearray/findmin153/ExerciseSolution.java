package src.numbers.rotatearray.findmin153;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/03/20 11:57:13
 * description:
 */
public class ExerciseSolution {
    // WA
    // 和 left 左边界作比较并不能确定最小值在哪半边，nums[mid] > nums[left]，此时最小值可能在右边也可能在左边
//    public int findMin(int[] nums) {
//        if (nums == null || nums.length == 0) return -1;
//        int left = 0, right = nums.length;
//        while (left < right) {
//            int mid = (left + right) >>> 1;
//            // [left, mid]是单调递增区间
//            if (nums[mid] > nums[left]) {
//                left = mid + 1;
//            } else {
//                right = mid;
//            }
//        }
//        return nums[left];
//    }

    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        // 因为在确定单调区间的时候需要和最右边元素做比较，所以右边界取了 `nums.length - 1`
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) >>> 1;
            // 此时最小值在 mid 的右侧
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}
