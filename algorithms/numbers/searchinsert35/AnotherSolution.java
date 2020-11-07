package blogandquestion.algorithms.numbers.searchinsert35;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/07 14:29:41
 * description: 这道题目给出了数组是有序的，这也是使用二分查找的基础条件。
 * 同时题目还强调数组中无重复元素，因为一旦有重复元素，使用二分查找法返回的元素下表可能不是唯一的。
 * 解题思路
 * see: https://leetcode-cn.com/problems/search-insert-position/solution/35sou-suo-cha-ru-wei-zhi-che-di-jiang-tou-er-fen-f/
 */
public class AnotherSolution {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        int left = 0, right = nums.length - 1;
        // 定义一个左闭右闭的区间，[left,right]
        // 当left == right时区间仍然有效
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                // 处理目标元素就是和数组中的某个元素相同的情况
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        // 处理剩下的三种情况
        return right + 1;
    }
}

class ThirdSolution {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        int left = 0, right = nums.length;
        // 定义一个左闭右开的区间，右边界是取不到的，所以右边界初始值取了数组的长度
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                // 因为右边是一个开区间，右边界值是取不到的，右边界减1的值可以取到
                // 右值需要能取到mid - 1，所以右边界值为mid
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }
}
