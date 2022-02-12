package src.numbers.minsubarraylen209;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/09 20:41:36
 * description: 将Solution.java中的for循环改为while循环
 * 解题思路
 * see: https://leetcode-cn.com/problems/minimum-size-subarray-sum/solution/javade-jie-fa-ji-bai-liao-9985de-yong-hu-by-sdwwld/
 */
public class AnotherSolution {
    public int minSubArrayLen(int s, int[] nums) {
        int left = 0, right = 0, sum = 0, res = Integer.MAX_VALUE;
        while (right < nums.length) {
            sum += nums[right++];
            while (sum >= s) {
                // 因为上面right已经自增过了，所以此时计算窗口长度只需right-left，而不需要在加1
                res = Math.min(res, right - left);
                sum -= nums[left++];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
