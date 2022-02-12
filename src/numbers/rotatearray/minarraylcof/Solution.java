package src.numbers.rotatearray.minarraylcof;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/03/20 13:31:40
 * description:
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
 *
 * 示例 1：
 *
 * 输入：[3,4,5,1,2]
 * 输出：1
 * 示例 2：
 *
 * 输入：[2,2,2,0,1]
 * 输出：0
 * 注意：本题与主站 154 题相同：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof
 *
 *
 * @see src.numbers.rotatearray.findmin154;
 */
public class Solution {
    public int minArray(int[] numbers) {
        if (numbers == null || numbers.length == 0) return -1;
        // 因为在确定单调区间的时候需要和最右边元素做比较，所以右边界取了 `numbers.length - 1`
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int mid = (left + right) >>> 1;
            // 此时最小值在 mid 的右侧
            if (numbers[mid] > numbers[right]) {
                left = mid + 1;
            } else if (numbers[mid] < numbers[right]) {
                // 此时最小值可能是mid，也可能在mid左侧，mid不能被排除
                right = mid;
            } else {
                // 此时nums[mid] == nums[right]，因为数组中存在重复数字，如[3，1，3，3，3，3，3]和[3，3，3，3，3，1，3]
                // 无法确定最小值在mid的左边还是在mid的右边。
                // 此时可以令right减1，因为即使right处就是最小值，mid处的值等于right处的值，不会把最小值排除掉
                --right;
            }
        }
        return numbers[left];
    }
}
