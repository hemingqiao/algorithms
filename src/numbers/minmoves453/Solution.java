package src.numbers.minmoves453;

import java.util.Arrays;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/19 18:43:12
 * description:
 * 给定一个长度为 n 的非空整数数组，找到让数组所有元素相等的最小移动次数。每次移动将会使 n - 1 个元素增加 1。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [1,2,3]
 * <p>
 * 输出:
 * 3
 * <p>
 * 解释:
 * 只需要3次移动（注意每次移动会增加两个元素的值）：
 * <p>
 * [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-moves-to-equal-array-elements
 */
public class Solution {
    public int minMoves(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        int first = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res += nums[i] - first;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minMoves(new int[]{1, 2, 3, 4}));
    }
}

/**
 * 参考：https://leetcode-cn.com/problems/minimum-moves-to-equal-array-elements/solution/zhi-xing-yong-shi-72-ms-zai-suo-you-c-ti-jiao-zh-4/
 */
class AnotherSolution {
    public int minMoves(int[] nums) {
        int minValue = Integer.MIN_VALUE;
        for (int num : nums) {
            minValue = Math.min(minValue, num);
        }
        int res = 0;
        for (int j : nums) {
            res += j - minValue;
        }
        return res;
    }
}

/**
 * 参考：https://leetcode-cn.com/problems/minimum-moves-to-equal-array-elements/solution/zui-xiao-yi-dong-ci-shu-shi-shu-zu-yuan-su-xiang-d/
 */
class BruteSolution {
    // 在暴力法中，通过扫描整个数组以查找最大值和最小元素。此后，将 1 添加到除最大元素之外的所有元素，并增加移动数的计数。
    // 之后重复相同的过程，直到最大元素和最小元素彼此相等。
    public int minMoves(int[] nums) {
        // 使用递归，当遇到[1,2147483647]测试用例时，递归栈爆了。
        return brute(nums, 0, nums.length - 1, 0);
    }

    private int brute(int[] nums, int max, int min, int count) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums[max]) {
                max = i;
            }
            if (nums[i] < nums[min]) {
                min = i;
            }
        }
        if (nums[max] == nums[min]) {
            return count;
        }
        for (int j = 0; j < nums.length; j++) {
            if (j == max) continue;
            nums[j]++;
        }
        count++;
        return brute(nums, max, min, count);
    }

    // 但是这个方法会超时
    public int minMovesOpt(int[] nums) {
        int max = 0, min = nums.length - 1;
        int count = 0;
        while (true) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > nums[max]) {
                    max = i;
                }
                if (nums[i] < nums[min]) {
                    min = i;
                }
            }
            if (nums[max] == nums[min]) {
                return count;
            }
            for (int j = 0; j < nums.length; j++) {
                if (j == max) continue;
                nums[j]++;
            }
            count++;
        }
    }

    public static void main(String[] args) {
        BruteSolution bs = new BruteSolution();
        int[] test = {1, 2, 3, 4};
        int res = bs.minMoves(test);
        System.out.println(res);
    }
}
