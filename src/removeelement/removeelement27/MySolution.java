package src.removeelement.removeelement27;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/17 15:51:48
 * description: 使用快慢双指针。
 * 解题思路：
 * 参见https://labuladong.gitbook.io/algo/shu-ju-jie-gou-xi-lie/yuan-di-xiu-gai-shu-zu
 */
public class MySolution {
    public int removeElement(int[] nums, int val) {
        if(nums == null || nums.length == 0) return 0;

        int fast = 0, slow = 0;
        while(fast < nums.length) {
            if(nums[fast] != val) {
                nums[slow++] = nums[fast];
            }
            fast++;
        }
        return slow;
    }
}
