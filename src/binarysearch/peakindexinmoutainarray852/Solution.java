package src.binarysearch.peakindexinmoutainarray852;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/12 11:11:57
 * description: 利用单调区间来判断。
 * 我们把符合下列属性的数组 A 称作山脉：
 *
 * A.length >= 3
 * 存在 0 < i < A.length - 1 使得A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
 * 给定一个确定为山脉的数组，返回任何满足 A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1] 的 i 的值。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[0,1,0]
 * 输出：1
 * 示例 2：
 *
 * 输入：[0,2,1,0]
 * 输出：1
 *  
 *
 * 提示：
 *
 * 3 <= A.length <= 10000
 * 0 <= A[i] <= 10^6
 * A 是如上定义的山脉
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/peak-index-in-a-mountain-array
 *
 */
public class Solution {
    public int peakIndexInMoutainArray(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] > arr[mid - 1] && arr[mid] < arr[mid + 1]) {
                left = mid;
            } else if (arr[mid] < arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                right = mid;
            } else if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                return mid;
            }
        }
        return -1;
    }
}

class AnotherSolution {
    public int peakIndexInMoutainArray(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            // 因为在顶点两侧数据是单调递增或者单调递减的，所以判断条件可以优化如下
            // 每次循环时最先判断是否是顶点，如果是，返回结果退出循环，否则，判断其单调性
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                return mid;
            } else if (arr[mid] < arr[mid + 1]) {
                left = mid;
            } else if (arr[mid] > arr[mid + 1]) {
                right = mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        AnotherSolution as = new AnotherSolution();
        int[] test = {0,1,0};
        int result = as.peakIndexInMoutainArray(test);
        System.out.println(result);
    }
}
