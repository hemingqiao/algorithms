package blogandquestion.algorithms.binarysearch.searchinsert35;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/07 14:23:38
 * description: 在这道题目中，一共四种情况：
 * 1、目标值在所有元素之前；
 * 2、目标值等于数组中的某个元素
 * 3、目标值插入到数组中的某个位置
 * 4、目标值在数组的所有元素之后
 * 解题思路
 * see: https://leetcode-cn.com/problems/search-insert-position/solution/35sou-suo-cha-ru-wei-zhi-che-di-jiang-tou-er-fen-f/
 */
public class BruteSolution {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        for (int i = 0; i < nums.length; i++) {
            // 处理前三种情况
            // 因为数组是有序的，所以一旦在数组中找到了大于等于目标值的元素，这个位置就是所找的
            if (nums[i] >= target) {
                return i;
            }
        }
        // 处理最后一种情况
        return nums.length;
    }
}
