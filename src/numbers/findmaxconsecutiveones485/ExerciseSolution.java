package src.numbers.findmaxconsecutiveones485;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/02/15 09:23:28
 * description:
 */
public class ExerciseSolution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int left = 0, right = 0;
        int res = 0;
        while (right < n) {
            if (nums[right] == 0) {
                res = Math.max(res, right - left);
                left = right + 1;
            }
            ++right;
        }
        // 跳出循环后需要在进行一次判断，因为数组中的所有元素都可能为1，导致不会进入while循环中的if语句块
        return Math.max(res, right - left);
    }

    public int findMaxConsecutiveOnes1(int[] nums) {
        int n = nums.length;
        int cnt = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                cnt++;
            } else  {
                cnt = 0;
            }
            res = Math.max(res, cnt);
        }
        return res;
    }
}
