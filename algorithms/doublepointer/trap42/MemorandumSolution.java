package blogandquestion.algorithms.doublepointer.trap42;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/23 20:55:05
 * description: 使用备忘录进行优化。执行时间从暴力解法的115ms降到1ms，击败99.99
 * 解题思路
 * see: https://mp.weixin.qq.com/s/mFqrlhqYEPhRa9p4ewl3Xw
 */
public class MemorandumSolution {
    public int trap(int[] height) {
        if (height.length == 0) return 0;
        int res = 0;
        int length = height.length;
        // 使用两个数组r_max和l_max充当备忘录，l_max[i]表示位置i左边最高的柱子高度，r_max[i]表示位置i右边最高的柱子高度。
        // 预先把这两个数组计算好，避免重复计算
        int[] l_max = new int[length];
        int[] r_max = new int[length];
        // 初始化两个备忘录
        l_max[0] = height[0];
        r_max[length - 1] = height[length - 1];
        // 从左向右计算l_max数组中的元素
        for (int i = 1; i < length; i++) {
            l_max[i] = Math.max(l_max[i - 1], height[i]);
        }
        // 从右向左计算r_max数组中的元素
        for (int k = length - 2; k >= 0; k--) {
            r_max[k] = Math.max(r_max[k + 1], height[k]);
        }

        // 遍历求解能够接的最多雨水量
        for (int j = 0; j < length; j++) {
            res += Math.min(l_max[j], r_max[j]) - height[j];
        }
        return res;
    }
}
