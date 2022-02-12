package src.numbers.threesumcloest16;

import java.util.Arrays;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/08 09:03:23
 * description: 借鉴了三数之和的解题思路。
 * 先对数组升序排序，i指针负责外层遍历，内层定义两个指针left和right，分别从左右收缩，维护一个三数之和与目标值的差值。
 * 当新的差值小于之前的差值时，进行更新，同时判断三数之和是大于目标还是小于目标，如果等于目标，直接返回结果，如果大于目标值，将right指针
 * 右移，如果小于目标，将left指针左移，使三数之和向目标值target靠拢。
 * 同时题目设定每组输入只存在唯一答案，说明不需要进行去重处理。
 *
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 *  
 *
 * 示例：
 *
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 *  
 *
 * 提示：
 *
 * 3 <= nums.length <= 10^3
 * -10^3 <= nums[i] <= 10^3
 * -10^4 <= target <= 10^4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 *
 */
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int delta = Integer.MAX_VALUE;
        int sum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int temp = nums[i] + nums[left] + nums[right];
                if (Math.abs(temp - target) < delta) {
                    sum = temp;
                    delta = Math.abs(temp - target);
                }
                if (temp - target == 0) {
                    return sum;
                } else if (temp - target > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] test = {1, 1, 1, 0};
        int target = -100;
        int res = s.threeSumClosest(test, target);
        System.out.println(res);
    }
}

/*
官方题解对双指针解法的解释，感觉非常详尽了，能写出解法却不一定能解释清楚，这题我自己感觉就是如此，学习一下：

题目要求找到与目标值 target 最接近的三元组，这里的「最接近」即为差值的绝对值最小。我们可以考虑直接使用三重循环枚举三元组，
找出与目标值最接近的作为答案，时间复杂度为 O(N^3)。然而本题的 N 最大为 1000，会超出时间限制。

那么如何进行优化呢？我们首先考虑枚举第一个元素 a，对于剩下的两个元素 b 和 c，我们希望它们的和最接近 target−a。对于 b 和 c，
如果它们在原数组中枚举的范围（既包括下标的范围，也包括元素值的范围）没有任何规律可言，那么我们还是只能使用两重循环来枚举所有的可能情况。

因此，我们可以考虑对整个数组进行升序排序，这样一来：
假设数组的长度为 n，我们先枚举 a，它在数组中的位置为 i；
为了防止重复枚举，我们在位置 [i+1, n) 的范围内枚举 b 和 c。
当我们知道了 b 和 c 可以枚举的下标范围，并且知道这一范围对应的数组元素是有序（升序）的，那么我们是否可以对枚举的过程进行优化呢？

答案是可以的。借助双指针，我们就可以对枚举的过程进行优化。我们用 p_b 和 p_c 分别表示指向 b 和 c 的指针，初始时，p_b 指向位置 i+1，即左边界；
p_c 指向位置 n-1，即右边界。在每一步枚举的过程中，我们用 a+b+c 来更新答案，并且：

如果 a+b+c>target，那么就将 p_c 向左移动一个位置；

如果 a+b+c<target，那么就将 p_b 向右移动一个位置。

如果a+b+c=target，此时可以直接返回结果。

这是为什么呢？我们对 a+b+c>target 的情况进行一个详细的分析：

如果 a+b+c≥target，并且我们知道 p_b 到 p_c 这个范围内的所有数是按照升序排序的，那么如果 p_c 不变而 p_b 向右移动，
那么 a+b+c 的值就会不断地增加，显然就不会成为最接近 target 的值了。因此，我们可以知道在固定了 p_c 的情况下，
此时的 p_b 就可以得到一个最接近 target 的值，那么我们以后就不用再考虑 p_c 了，就可以将 p_c 向左移动一个位置。看能否找到一个更为接近target的
p_c。

同样地，在 a+b+c<target 时：

如果 a+b+c<target，并且我们知道 p_b到 p_c 这个范围内的所有数是按照升序排序的，那么如果 p_b 不变而 p_c 向左移动，那么 a+b+c 的值就会不断地减小，
显然就不会成为最接近 target 的值了。因此，我们可以知道在固定了 p_b 的情况下，此时的 p_c 就可以得到一个最接近 target 的值，那么我们以后就不用再考虑 p_b 了，
就可以将 p_b 向右移动一个位置。看能否找到一个更接近target的p_b。

实际上，p_b 和 p_c 就表示了我们当前可以选择的数的范围，而每一次枚举的过程中，我们尝试边界上的两个元素，根据它们与 target 的值的关系，
选择「抛弃」左边界的元素还是右边界的元素，从而减少了枚举的范围。这种思路与 11. 盛最多水的容器 中的双指针解法也是类似的。


链接：https://leetcode-cn.com/problems/3sum-closest/solution/zui-jie-jin-de-san-shu-zhi-he-by-leetcode-solution/
 */
