package src;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/02/23 19:10:35
 * description:
 */
public class MergeSort {
    public void mergeSort(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
    }

    public void mergeSort(int[] nums, int low, int high) {
        // 待排序序列长度为1的时候，递归开始「回升」，因为默认长度为1的序列是有序的
        if (low >= high) return;
        int mid = (low + high) >>> 1;
        mergeSort(nums, low, mid);
        mergeSort(nums, mid + 1, high);
        merge(nums, low, mid, high);
    }

    // 归并
    public void merge(int[] nums, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int p1 = left, p2 = mid + 1, k = 0;
        while (p1 <= mid && p2 <= right) {
            if (nums[p1] <= nums[p2]) {
                temp[k++] = nums[p1++];
            } else {
                temp[k++] = nums[p2++];
            }
        }
        while (p1 <= mid) {
            temp[k++] = nums[p1++];
        }
        while (p2 <= right) {
            temp[k++] = nums[p2++];
        }

        for (int i = left; i <= right; i++) {
            nums[i] = temp[i - left];
        }
    }

    public int[] generateArray(int size, int boundary) {
        int[] ret = new int[size];
        for (int i = 0; i < size; i++) {
            ret[i] = (int) (Math.random() * boundary);
        }
        return ret;
    }

    public boolean isSortedArray(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        MergeSort ms = new MergeSort();
        int[] test = ms.generateArray(15000000, 100000000);
//        System.out.println(Arrays.toString(test));
        double now = System.currentTimeMillis();
        ms.mergeSort(test);
//        System.out.println(Arrays.toString(test));
        System.out.println(System.currentTimeMillis() - now + "ms elapsed");
        System.out.println(ms.isSortedArray(test));
    }
}
