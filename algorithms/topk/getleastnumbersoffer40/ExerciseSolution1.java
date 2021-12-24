package blogandquestion.algorithms.topk.getleastnumbersoffer40;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/07/22 21:01:34
 * description:
 */
public class ExerciseSolution1 {
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] ret = new int[k];
        quickSelect(arr, 0, arr.length - 1, k);
        for (int i = 0; i < k; i++) ret[i] = arr[i];
        return ret;
    }

    public void quickSelect(int[] q, int l, int r, int k) {
        if (l == r) return;
        int x = q[l], i = l - 1, j = r + 1;
        while (i < j) {
            while (q[++i] < x);
            while (q[--j] > x);
            if (i < j) swap(q, i, j);
        }
        int sl = j - l + 1;
        if (k <= sl) quickSelect(q, l, j, k);
        else quickSelect(q, j + 1, r, k - sl);
    }

    public void swap(int[] q, int i, int j) {
        int temp = q[i];
        q[i] = q[j];
        q[j] = temp;
    }
}
