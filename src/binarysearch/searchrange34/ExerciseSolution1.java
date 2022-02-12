package src.binarysearch.searchrange34;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/05/31 21:23:37
 * description:
 */
public class ExerciseSolution1 {
    public int[] searchRange(int[] arr, int target) {
        int n = arr.length;
        if (n == 0) return new int[]{-1, -1};
        int[] ret = new int[2];
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = (l + r) >>> 1;
            // 先查找target的起始索引
            // 若 arr[mid] >= target 成立，则答案一定存在于[l, mid]内，mid有可能是答案
            if (arr[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        // 如果l处的值不等于target，表明数组中不存在target
        if (arr[l] != target) return new int[]{-1, -1};
        ret[0] = l;
        l = 0;
        r = n - 1;
        while (l < r) {
            int mid = (l + r + 1) >>> 1;
            // 查找target的终止索引
            // 如果 arr[mid] <= target 成立，则答案一定存在于[mid, r]内，mid可能是答案
            if (arr[mid] <= target) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        ret[1] = l;
        return ret;
    }

    public int[] searchRange1(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1, -1};
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (nums[mid] >= target) r = mid;
            else l = mid + 1;
        }
        if (nums[l] != target) return new int[]{-1, -1};
        int j = l;
        while (j + 1 < nums.length && nums[j + 1] == target) j++;
        return new int[]{l, j};
    }

    public int search(int[] nums, int target) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] >= target) r = mid;
            else l = mid + 1;
        }
        if (nums[l] != target) return 0;
        int s = l;
        l = 0;
        r = n - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (nums[mid] <= target) l = mid;
            else r = mid - 1;
        }
        return l - s + 1;
    }

    public static void main(String[] args) {
        ExerciseSolution1 es = new ExerciseSolution1();
        int[] test = {5, 7, 7, 8, 8, 10};
        int res = es.search(test, 8);
        System.out.println(res);
    }
}
