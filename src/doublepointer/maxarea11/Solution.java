package src.doublepointer.maxarea11;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/09 19:29:44
 * description: 看了题解，使用双指针。
 *
 * 算法流程： 设置双指针 i,j 分别位于容器壁两端，根据规则移动指针（后续说明），并且更新面积最大值 res，直到 i == j 时返回 res。
 *
 * 指针移动规则与证明： 每次选定围成水槽两板高度 h[i],h[j] 中的短板，向中间收窄 1 格。以下证明：
 *
 * 设每一状态下水槽面积为 S(i, j),(0 <= i < j < n)，由于水槽的实际高度由两板中的短板决定，则可得面积公式 S(i,j)=min(h[i],h[j])×(j−i)。
 * 在每一个状态下，无论长板或短板收窄 1 格，都会导致水槽 底边宽度 −1：
 * 若向内移动短板，水槽的短板 min(h[i], h[j]) 有可能变大，因此水槽面积 S(i, j) 有可能增大。
 * 若向内移动长板，水槽的短板 min(h[i], h[j]) 不变或变小，下个水槽的面积一定小于当前水槽面积。
 *
 *
 * see: https://leetcode-cn.com/problems/container-with-most-water/solution/container-with-most-water-shuang-zhi-zhen-fa-yi-do/
 */
public class Solution {
    public int maxArea(int[] height) {
        int res = 0;
        int i = 0, j = height.length - 1;
        while (i < j) {
            // 需要注意这里相乘的顺序不能颠倒，不能先i++在执行j - i，因为执行j - i时i的值已经被改变了
            res = height[i] < height[j]
                    ? Math.max(res, (j - i) * height[i++])
                    : Math.max(res, (j - i) * height[j--]);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution ms = new Solution();
        int[] test = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int result = ms.maxArea(test);
        System.out.println(result);
    }
}
