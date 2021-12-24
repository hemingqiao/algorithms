package blogandquestion.algorithms.acwing.binarysearch;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/06/05 09:43:12
 * description:
 */
public class BinarySearch {
    // 找到大于等于tar的最后一个位置（如果数组中存在tar，返回tar出现的最后位置，否则返回大于tar的第一个位置）
    public int find(int[] arr, int tar) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int mid = (l + r + 1) >>> 1;
            if (arr[mid] <= tar) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    // upper_bound返回第一个大于x的位置
    public int upper_bound(int[] arr, int x) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (arr[mid] > x) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    // lower_bound函数返回第一个大于等于x的位置
    public int lower_bound(int[] arr, int x) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (arr[mid] >= x) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        int[] test = {1, 2, 5, 5, 6, 7, 7, 9};
        BinarySearch bs = new BinarySearch();
        int res = bs.lower_bound(test, 6);
        System.out.println(res);
    }
}
