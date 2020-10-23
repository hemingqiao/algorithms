package blogandquestion.algorithms.doublepointer.trap42;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/23 20:44:46
 * description: 暴力遍历。执行速度非常之慢，击败5%。
 * 解题思路
 * see: https://mp.weixin.qq.com/s/mFqrlhqYEPhRa9p4ewl3Xw
 */
public class BruteSolution {
    public int trap(int[] height) {
        int res = 0;
        int length = height.length;
        for (int i = 0; i < length - 1; i++) {
            int l_max = 0, r_max = 0;
            // 找右边最高的柱子
            for (int j = i; j < length; j++) {
                r_max = Math.max(r_max, height[j]);
            }
            // 找左边最高的柱子
            for (int k = i; k >= 0; k--) {
                l_max = Math.max(l_max, height[k]);
            }
            // i处能接的雨水就是i处左侧最高的柱子和右侧最高的柱子中的较小值减去i处的值
            res += Math.min(l_max, r_max) - height[i];
        }
        return res;
    }
}
