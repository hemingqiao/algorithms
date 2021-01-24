package blogandquestion.algorithms.removeelement.removeelement27;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/21 13:20:08
 * description:
 * 二刷
 */
public class ExerciseSolution {
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        if (n == 0) return n;
        int left = 0, right = 0;
//        int cnt = 0;
        while (right < n) {
            if (nums[right] == val) {
                right++;
            } else {
                nums[left++] = nums[right++];
//                cnt++;
            }
        }
//        return cnt;
        return left;
    }
}
