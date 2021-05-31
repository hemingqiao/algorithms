package blogandquestion.algorithms.binarysearch.searchrange34;

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
}
