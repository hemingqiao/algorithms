package blogandquestion.algorithms.array.reversepairslcof51;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/07/23 22:10:32
 * description:
 */
public class ExerciseSolution {
    public static int N = 50010;
    public static int[] temp = new int[N];

    public int reversePairs(int[] nums) {
        return (int) mergeSort(nums, 0, nums.length - 1);
    }

    public long mergeSort(int[] q, int l, int r) {
        if (l >= r) return 0;
        int mid = l + r >> 1;
        long res = mergeSort(q, l, mid) + mergeSort(q, mid + 1, r);
        int k = 0, i = l, j = mid + 1;
        while (i <= mid && j <= r) {
            if (q[i] <= q[j]) temp[k++] = q[i++];
            else {
                res += mid - i + 1;
                temp[k++] = q[j++];
            }
        }
        while (i <= mid) temp[k++] = q[i++];
        while (j <= r) temp[k++] = q[j++];
        while (k-- > 0) q[k + l] = temp[k];
        return res;
    }
}
