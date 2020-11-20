package blogandquestion.algorithms.binarysearch.searchmatrix74;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/20 19:59:08
 * description:
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix
 *
 * 序列是有序的（递增），在有序序列中查找特定元素可以使用二分法
 */
public class Solution {
    // 需要注意的是，如果区间选择了左闭右开，那么二分的出口条件就不再是left <= right了
    // 并且当value > target时，right取值为mid，因为右边是开区间，取不到。并且此时while循环的判断条件是left < right
    // 因为此时区间是左闭右开，当两个指针相遇时（left == right），就会跳出循环
    // 同时还有一点需要注意，当选择左闭右开区间时，right的初始值就可以取元素的个数了（比最后一个元素的索引值大1）
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        int len = matrix.length, width = matrix[0].length;
        // 取闭区间（左边指针取0，右边指针取元素个数-1）
        int left = 0, right = len * width - 1;
        // 判断条件是小于等于，为了方便处理只有一个元素时的情形
        while (left <= right) {
            int mid = (left + right) / 2;
            int value = matrix[mid / width][mid % width];
            if (value == target) {
                return true;
            } else if (value < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
