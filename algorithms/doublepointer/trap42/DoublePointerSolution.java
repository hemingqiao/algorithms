package blogandquestion.algorithms.doublepointer.trap42;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/23 21:06:47
 * description: 双指针解法。
 * 解题思路
 * see: https://leetcode-cn.com/problems/trapping-rain-water/solution/jie-yu-shui-shuang-zhi-zhen-jie-fa-by-wang-xiao-sh/
 * see: https://mp.weixin.qq.com/s/mFqrlhqYEPhRa9p4ewl3Xw
 */
public class DoublePointerSolution {
    public int trap(int[] height) {
        if (height.length == 0) return 0;
        int length = height.length;
        // 定义左右双指针
        int left = 0, right = length - 1;
        int res = 0;
        int l_max = 0, r_max = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= l_max) {
                    l_max = height[left];
                } else {
                    res += l_max - height[left];
                }
                ++left;
            } else {
                if (height[right] >= r_max) {
                    r_max = height[right];
                } else {
                    res += r_max - height[right];
                }
                --right;
            }
        }
        return res;
    }
}
