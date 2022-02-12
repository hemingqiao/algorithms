package src.binarysearch.missingnumber;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/12/21 22:41:52
 * description:
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [0,1,3]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [0,1,2,3,4,5,6,7,9]
 * 输出: 8
 *  
 *
 * 限制：
 *
 * 1 <= 数组长度 <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof
 *
 */
public class Solution {
    // 题目限定，升序数组，考虑二分查找
    // 仔细观察可以发现，所求的目标值就是第一个索引不等于值的位置：如对于这个数组[0, 1, 2, 4]而言，所求的就是索引3
    // 所以进行二分查找时，如果mid处索引等于值，mid这个值可以排除掉，此时left赋值mid + 1
    // 因为所求索引可能是数组的最后一个位置后的位置（即索引等于length处），区间选左闭右开，则循环不变量为right（right不能取到）
    // 因此，当mid处索引不等于索引处的值时，right赋值为mid，此时right仍然是取不到的，保持循环不变量（或者理解为排除不掉mid，所以right赋值为mid）
    public int missingNumber(int[] nums) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] != mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
