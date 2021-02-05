package blogandquestion.algorithms.numbers.rotatearray.searchone33;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/22 19:40:19
 * description:
 * 参考：https://github.com/grandyang/leetcode/issues/33
 * 参考：https://leetcode-cn.com/problems/search-in-rotated-sorted-array/solution/ji-bai-liao-9983de-javayong-hu-by-reedfan/
 */
public class ExerciseSolution {
    // 二分搜索法的关键在于获得了中间数后，判断下面要搜索左半段还是右半段，通过观察可以得出规律，如果中间的数小于最右边的数，则右半段是有序的，
    // 若中间数大于最右边数，则左半段是有序的，只要在有序的半段里用首尾两个数组来判断目标值是否在这一区域内，这样就可以确定保留哪半边了
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] == target) return mid;
            if (nums[mid] < nums[right]) {
                // 此时[mid, right]区间有序
                // 判断target是否处于这个有序区间内（target == mid已经在上面判断过，所以不需要再判断了）
                if (target > nums[mid] && target <= nums[right]) left = mid + 1;
                else right = mid - 1;
            } else {
                // 此时[left, mid]区间有序，判断target是否位于这个有序区间内
                if (target >= nums[left] && target < nums[mid]) right = mid - 1;
                else left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        ExerciseSolution es = new ExerciseSolution();
        int[] test = new int[]{3,5,1};
        int res = es.search(test, 3);
        System.out.println(res);
    }

    // 通过与数组最左边的值比较来确定有序的区间，上面的search是通过与数组最右边的值进行比较来确定有序区间的
    public int search1(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] == target) return mid;
            if (nums[mid] < nums[left]) {
                // 此时区间[mid, right]是有序的，判断target是否位于有序的区间内
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                // 此时区间[left, mid]是有序的，首先判断target是否位于有序区间内
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
}
