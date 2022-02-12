package src.removeelement.removeduplicatestwo80;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/14 20:11:22
 * description:
 * 解题思路：要求重复的元素最多不超过两个，也就是nums[index] != nums[index - 2]
 * see: https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/solution/shuang-zhi-zhen-zhi-tong-xiang-zhi-zhen-che-di-jie/
 */
public class AnotherSolution {
    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        } else if (nums.length <= 2) {
            return nums.length;
        }
        int index = 1;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[index - 1]) {
                nums[++index] = nums[i];
            }
        }
        return index + 1;
    }
}
