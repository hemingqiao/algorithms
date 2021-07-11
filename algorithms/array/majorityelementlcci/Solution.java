package blogandquestion.algorithms.array.majorityelementlcci;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/07/11 08:11:47
 * description:
 */
public class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int r = -1, c = 0;
        for (int i = 0; i < n; i++) {
            if (c == 0) {
                r = nums[i];
                ++c;
            } else if (nums[i] == r) {
                ++c;
            } else {
                --c;
            }
        }
        // 特殊用例中，不存在超过数组一半的元素，所以需要判断下
        c = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == r) ++c;
        }
        return c > n / 2 ? r : -1;
    }
}
