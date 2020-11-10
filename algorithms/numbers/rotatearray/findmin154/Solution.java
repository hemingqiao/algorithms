package blogandquestion.algorithms.numbers.rotatearray.findmin154;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/10 19:12:27
 * description:
 */
public class Solution {
    // 暴力解法
    public int findMin(int[] nums) {
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        return min;
    }
}
