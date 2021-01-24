package blogandquestion.algorithms.removeelement.removeduplicates26;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/21 13:07:09
 * description:
 * 二刷
 */
public class ExerciseSolution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n < 2) return n;
        int left = 0, right = 1;
        while (right < n) {
            if (nums[right] == nums[left]) {
                right++;
            } else {
                nums[++left] = nums[right++];
            }
        }
        return left + 1;
    }
}
