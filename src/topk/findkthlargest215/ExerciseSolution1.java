package src.topk.findkthlargest215;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/07/08 23:35:57
 * description:
 */
public class ExerciseSolution1 {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(0, nums.length - 1, k, nums);
    }

    public int quickSelect(int l, int r, int k, int[] q) {
        if (l >= r) return q[l];
        int x = q[l];
        // int j = l;
        // for (int i = l + 1; i <= r; i++) {
        //     if (q[i] >= x) swap(q, ++j, i);
        // }
        // swap(q, l, j);
        int i = l - 1, j = r + 1;
        while (i < j) {
            while (q[++i] > x) ;
            while (q[--j] < x) ;
            if (i < j) swap(q, i, j);
        }

        int sl = j - l + 1;
        if (k <= sl) return quickSelect(l, j, k, q);
        return quickSelect(j + 1, r, k - sl, q);
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        ExerciseSolution1 es1 = new ExerciseSolution1();
        int[] t = {3, 2, 1, 5, 6, 4};
        int res = es1.findKthLargest(t, 2);
        System.out.println(res);
    }
}
