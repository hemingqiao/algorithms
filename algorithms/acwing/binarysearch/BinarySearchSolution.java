package blogandquestion.algorithms.acwing.binarysearch;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/05/29 08:44:09
 * description:
 */
public class BinarySearchSolution {
    public int upper_bound(int[] arr, int target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = (l + r) >>> 1;
            // upper_bound是返回大于target的第一个元素位置
            // 所以对于check函数来说，如果arr[mid] > target，那么答案一定存在于[l, mid]区间，mid也是可能的答案
            if (arr[mid] > target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public int lower_bound(int[] arr, int target) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = (left + right) >>> 1;
            // lower_bound是返回大于等于target的第一个位置
            // 和upper_bound函数类似，但是check函数的条件变为了arr[mid] >= target，则答案一定存在于[l, mid]区间，mid也是可能的答案
            if (arr[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        BinarySearchSolution s = new BinarySearchSolution();
        int[] test = {1, 2, 2, 3, 4, 5, 5};
        int[] test1 = {1, 2, 2, 3, 3, 3, 4, 6};
        int res = s.upper_bound(test1, 7);
        System.out.println(res);
        System.out.println(s.lower_bound(test, 0));
    }
}
