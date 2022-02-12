package src.numbers.findduplicate287;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/07/01 23:23:59
 * description:
 */
public class ExerciseSolution {
    // https://www.acwing.com/video/138/
    public int findDuplicate(int[] nums) {
        // 注意，所有元素都大于等于1，且小于等于n - 1，所以l从1开始的
        int l = 1, r = nums.length - 1;
        while (l < r) {
            int mid = l + r >> 1;
            int s = 0;
            // 每次遍历所有元素，判断位于[l, mid]区间的元素有多少个
            for (int i = 0; i < nums.length; i++) if (nums[i] >= l && nums[i] <= mid) ++s;
            // 如果位于[l, mid]区间内的元素个数大于坑位数，表明重复元素一定在这个区间内
            if (s > mid - l + 1) r = mid;
            else l = mid + 1;
        }
        return l;
    }
}
