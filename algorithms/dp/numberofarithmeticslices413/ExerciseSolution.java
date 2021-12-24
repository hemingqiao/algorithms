package blogandquestion.algorithms.dp.numberofarithmeticslices413;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/08/10 22:20:10
 * description:
 */
public class ExerciseSolution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        for (int i = n - 1; i > 0; i--) nums[i] -= nums[i - 1];
        int res = 0;
        for (int i = 1; i < n; i++) {
            int j = i;
            while (j < n && nums[j] == nums[i]) j++;
            int k = j - i;
            res += (k - 1) * k / 2;
            i = j - 1;
        }
        return res;
    }
}
