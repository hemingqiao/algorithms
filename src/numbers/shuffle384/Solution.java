package src.numbers.shuffle384;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/06/26 10:23:25
 * description:
 * 洗牌算法的应用
 */
public class Solution {
    int[] nums;
    int[] val;

    public Solution(int[] nums) {
        this.nums = nums;
        this.val = nums.clone();
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return nums;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        int n = val.length;
        while (n != 0) {
            int r = (int) (Math.random() * n--);
            int temp = val[r];
            val[r] = val[n];
            val[n] = temp;
        }
        return val;
    }
}
