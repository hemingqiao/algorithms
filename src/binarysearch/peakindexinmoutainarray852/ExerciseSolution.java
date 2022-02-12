package src.binarysearch.peakindexinmoutainarray852;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/06/15 22:06:23
 * description:
 */
public class ExerciseSolution {
    // 二分模板
    public int peakIndexInMountainArray(int[] arr) {
        // 题目保证性质一定存在的区间是 0 < i < arr.length - 1, 即[1, arr.length - 2]
        int l = 1, r = arr.length - 2;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (arr[mid] > arr[mid + 1]) r = mid;
            else l = mid + 1;
        }
        return l;
    }
}
