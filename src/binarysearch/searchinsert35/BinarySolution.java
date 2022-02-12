package src.binarysearch.searchinsert35;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/12/11 14:03:02
 * description:
 */
public class BinarySolution {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        int low = 0, high = nums.length;
        while (low < high) {
            int mid = (low + high) >>> 1;
            // 小于target的位置一定不是寻找的解
            if (nums[mid] < target) {
                // 新的搜索区间为[mid + 1, high]
                low = mid + 1;
            } else {
                // 新的搜索区间为[low, high]
                high = mid;
            }
        }
        // 退出循环时low == high
        return high;
    }
}
