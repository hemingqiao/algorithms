package blogandquestion.algorithms.array.topk.getleastnumbersoffer40;


import java.util.Arrays;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/21 21:10:08
 * description:
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * 示例 2：
 *
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 *  
 *
 * 限制：
 *
 * 0 <= k <= arr.length <= 10000
 * 0 <= arr[i] <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof
 *
 * 本题与另一题类似：https://leetcode-cn.com/problems/smallest-k-lcci/
 */
public class Solution {
    public int[] getLeastNumbers(int[] nums, int k) {
        int[] res = new int[k];
        quickSort(nums, 0, nums.length - 1);
        for (int i = 0; i < k; i++) {
            res[i] = nums[i];
        }
        return res;
    }

    public void quickSort(int[] arr, int low, int high) {
        if (low >= high) return;
        swap(arr, low, (int) (Math.random() * (high - low + 1)) + low);
        int pivot = arr[low];
        int j = low;
        for (int i = low + 1; i <= high; i++) {
            if (arr[i] < pivot) {
                j++;
                swap(arr, j, i);
            }
        }
        swap(arr, low, j);

        quickSort(arr, low, j - 1);
        quickSort(arr, j + 1, high);
    }

    /*
    // 这种写法较上面的写法速度稍慢
    public void quickSort(int[] arr, int low, int high) {
        if (low >= high) return;
        swap(arr, low, (int) (Math.random() * (high - low + 1)) + low);
        int pivot = arr[low];
        int left = low, right = high;
        while (left < right) {
            while (left < right && arr[right] >= pivot) {
                right--;
            }
            while (left < right && arr[left] <= pivot) {
                left++;
            }
            swap(arr, left, right);
        }
        arr[low] = arr[left];
        arr[left] = pivot;

        quickSort(arr, low, left - 1);
        quickSort(arr, left + 1, high);
    }
    */

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

/**
 * 参考：https://zhuanlan.zhihu.com/p/114699207
 */
class AnotherSolution {
    // 快速排序的变形：快速搜索
    public int[] getLeastNumbers(int[] nums, int k) {
        if (k == 0 || nums.length == 0) return new int[0];
        // 第k小的数下标是k-1
        return quickSelect(nums, 0, nums.length - 1, k - 1);
    }

    public int[] quickSelect(int[] nums, int low, int high, int k) {
        int j = partition(nums, low, high);
        // 每快排切分1次，找到排序后下标为j的元素，如果j恰好等于k就返回j以及j左边所有的数；
        if (j == k) {
            return Arrays.copyOf(nums, j + 1);
        }
        // 否则根据下标j与k的大小关系来决定继续切分左段还是右段。
        return j > k ? quickSelect(nums, low, j - 1, k) : quickSelect(nums, j + 1, high, k);
    }

    // 快排切分，返回下标j，使得比nums[j]小的数都在j的左边，比nums[j]大的数都在j的右边。
    public int partition(int[] nums, int low, int high) {
        // 下面随机选取序列中的元素作为排序基准是为了应对极端情况，如果能够确定不会出现极端的情况
        // 可以去掉下面这行代码
        swap(nums, low, (int)(Math.random() * (high - low + 1)) + low);
        int j = low;
        int pivot = nums[low];
        for (int i = low + 1; i <= high; i++) {
            if (nums[i] < pivot) {
                j++;
                swap(nums, j, i);
            }
        }
        swap(nums, j, low);
        return j;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
