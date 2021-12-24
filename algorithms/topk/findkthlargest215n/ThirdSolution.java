package blogandquestion.algorithms.topk.findkthlargest215n;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/21 17:09:23
 * description:
 * 参考：https://leetcode-cn.com/problems/kth-largest-element-in-an-array/solution/partitionfen-er-zhi-zhi-you-xian-dui-lie-java-dai-/
 */
public class ThirdSolution {
    public int findKthLargest(int[] nums, int k) {
        int left = 0, right = nums.length - 1;
        int targetIndex = nums.length - k;
        while (left < right) {
            int mid = findIndex(nums, left, right);
            if (mid == targetIndex) {
                return nums[mid];
            } else if (mid < targetIndex) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return nums[left];
    }

    public int findIndex(int[] arr, int low, int high) {
        // 将第一个元素与序列中一个随机元素交换位置
        // 以交换后的首元素作为快速排序的基准，以应对极端情况
        swap(arr, low, (int)(Math.random() * (high - low + 1)) + low);
        int pivot = arr[low];
        int j = low;
        for (int i = low + 1; i <= high; i++) {
            if (arr[i] < pivot) {
                j++;
                swap(arr, j, i);
            }
        }
        // 执行完上面这个循环之后，有[low + 1, j]区间内元素都小于pivot，(j, high]区间内元素大于等于pivot
        // 此时可以把pivot元素（位于索引low处）交换到索引 j 处，也就是 swap(arr, low, j);
        // 交换之后，有[low, j - 1]区间内元素都小于pivot，j处元素值等于pivot，(j, high]区间内元素大于等于pivot
        swap(arr, low, j);
        return j;
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
