package src.numbers.rotatearray.searchtwo81;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/10 19:39:50
 * description: 一个通用的解决这四道旋转升序数组的思路
 */
public class GeneralSolution {
//    public boolean search(int[] nums, int target) {
//        if (nums == null || nums.length == 0) return false;
//        int left = 0, right = nums.length - 1;
//        while (left < right) {
//            int mid = (left + right) / 2;
//            if (nums[mid] ==  target) return true;
//            // [left, mid]区间有序
//            if (nums[mid] > nums[right]) {
//                // 在上面已经排除掉了target等于mid处的值
//                if (target >= nums[left] && target < nums[mid]) {
//                    // 如果target落在了这个区间，将搜索的右界变为mid - 1
//                    right = mid - 1;
//                } else {
//                    // 否则，前往右边继续查找
//                    left = mid + 1;
//                }
//            } else if (nums[mid] < nums[right]) {
//                // 此时[mid, right]区间是有序的
//                if (target > nums[mid] && target <= nums[right]) {
//                    // 如果target落在了[mid, right]区间内，将搜索的左边界变为mid + 1
//                    left = mid + 1;
//                } else {
//                    // 否则，前往左边继续查找
//                    right = mid - 1;
//                }
//            } else {
//                // 此时nums[mid] == nums[right], 如10111、11101这种情况，因为题目已经说明可能存在重复的数字
//                // 此时不好判断左边是有序的还是右边是有序的。
//                // 可以将right值减1，因为mid出的值是等于right出的值，而在上面已经判断mid处的值是否等于target
//                right--;
//            }
//        }
//        // 跳出循环时，搜索区间为1或者当数组长度为1时，需要判断是否等于target
//        return nums[left] == target;
//    }

    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) return true;

            if (nums[mid] == nums[right]) {
                // 此时nums[mid] == nums[right], 如10111、11101这种情况，因为题目已经说明可能存在重复的数字
                // 此时不好判断左边是有序的还是右边是有序的。
                // 可以将right值减1，因为mid处的值是等于right处的值，而在上面已经判断mid处的值是否等于target
                // 可以放心将right值减1，然后继续下一次查找
                right--;
                continue;
            }
            // [left, mid]区间有序
            if (nums[mid] > nums[right]) {
                // 在上面已经排除掉了target等于mid处的值
                if (target >= nums[left] && target < nums[mid]) {
                    // 如果target落在了这个区间，将搜索的右界变为mid - 1
                    right = mid - 1;
                } else {
                    // 否则，前往右边继续查找
                    left = mid + 1;
                }
            } else { // nums[mid] < nums[right]
                // 此时[mid, right]区间是有序的
                if (target > nums[mid] && target <= nums[right]) {
                    // 如果target落在了[mid, right]区间内，将搜索的左边界变为mid + 1
                    left = mid + 1;
                } else {
                    // 否则，前往左边继续查找
                    right = mid - 1;
                }
            }
        }
        return false;
    }
}
