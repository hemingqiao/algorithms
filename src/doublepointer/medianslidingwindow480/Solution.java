package src.doublepointer.medianslidingwindow480;


import java.util.Arrays;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/02/03 08:59:06
 * description:
 * 中位数是有序序列最中间的那个数。如果序列的长度是偶数，则没有最中间的数；此时中位数是最中间的两个数的平均数。
 *
 * 例如：
 *
 * [2,3,4]，中位数是 3
 * [2,3]，中位数是 (2 + 3) / 2 = 2.5
 * 给你一个数组 nums，有一个长度为 k 的窗口从最左端滑动到最右端。窗口中有 k 个数，每次窗口向右移动 1 位。你的任务是找出每次窗口移动后得到的新窗口中元素的中位数，并输出由它们组成的数组。
 *
 *  
 *
 * 示例：
 *
 * 给出 nums = [1,3,-1,-3,5,3,6,7]，以及 k = 3。
 *
 * 窗口位置                      中位数
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       1
 *  1 [3  -1  -3] 5  3  6  7      -1
 *  1  3 [-1  -3  5] 3  6  7      -1
 *  1  3  -1 [-3  5  3] 6  7       3
 *  1  3  -1  -3 [5  3  6] 7       5
 *  1  3  -1  -3  5 [3  6  7]      6
 *  因此，返回该滑动窗口的中位数数组 [1,-1,-1,3,5,6]。
 *
 *  
 *
 * 提示：
 *
 * 你可以假设 k 始终有效，即：k 始终小于输入的非空数组的元素个数。
 * 与真实值误差在 10 ^ -5 以内的答案将被视作正确答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sliding-window-median
 *
 * 参考：https://leetcode-cn.com/problems/sliding-window-median/solution/480-java-er-fen-cha-zhao-mou-pao-pai-xu-8dcw4/
 */
public class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        double[] res = new double[n - k + 1];
        int p = 0;
        int[] temp = new int[k];
        for (int i = 0; i < k; i++) {
            temp[i] = nums[i];
        }
        Arrays.sort(temp);
        res[p++] = getMidNumber(temp);
        for (int i = 0; i < n - k; i++) {
            // 窗口向右滑动，最左边的数需要被删除，找到这个需要被删除的数的索引
            int index = binarySearch(temp, nums[i]);
            // 把这个需要被删除的数替换为窗口最右侧新加入的数
            temp[index] = nums[i + k];
            // 利用插入排序重新对temp数组进行排序
            if (index < temp.length - 1 && temp[index] > temp[index + 1]) {
                int temporary = temp[index];
                int j = index + 1;
                for (; j < temp.length && temporary > temp[j]; j++) {
                    temp[j - 1] = temp[j];
                }
                temp[j - 1] = temporary;
            }
            if (index > 0 && temp[index] < temp[index - 1]) {
                int temporary = temp[index];
                int j = index - 1;
                for (; j >= 0 && temp[j] > temporary; j--) {
                    temp[j + 1] = temp[j];
                }
                temp[j + 1] = temporary;
            }
            res[p++] = getMidNumber(temp);
        }
        return res;
    }

    public double getMidNumber(int[] arr) {
        int n = arr.length;
        if ((n & 1) == 1) { // 奇数
            return arr[n >> 1];
        } else {
            // 防止两者直接相加后溢出（超过2147483647）
            return arr[(n >> 1) - 1] / 2.0 + arr[n >> 1] / 2.0;
        }
    }

    public int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] test = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        double[] res = s.medianSlidingWindow(test, k);
        System.out.println(Arrays.toString(res));
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
