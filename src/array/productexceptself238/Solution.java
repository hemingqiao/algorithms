package src.array.productexceptself238;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/26 22:15:26
 * description:
 * 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 *
 *  
 *
 * 示例:
 *
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 *  
 *
 * 提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。
 *
 * 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 *
 * 进阶：
 * 你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/product-of-array-except-self
 */
public class Solution {
    // 直接用除法会得到除0异常
    // wrong answer
    public int[] productExceptSelfWrong(int[] nums) {
        int res = 1;
        for (int num : nums) {
            res *= num;
        }
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = res / nums[i];
        }
        return ans;
    }

    /*
    原数组：       [1       2       3       4]
    左部分的乘积：   1      1*1      1*2    1*2*3
    右部分的乘积： 2*3*4    3*4      4*1      1
    结果：        1*2*3*4  1*3*4   1*2*4  1*2*3*1
    从上面可以看出，当前位置的结果就是它左部分的乘积再乘以它右部分的乘积。因此需要进行两次遍历，第一次遍历用于求左部分的乘积，
    第二次遍历在求右部分的乘积的同时，再将最后的计算结果一起求出来
     */
    public int[] productExceptSelf(int[] nums) {
        int left = 1;
        int right = 1;
        int len = nums.length;
        int[] output = new int[len];
        for (int i = 0; i < len; i++) {
            output[i] = left;
            left *= nums[i];
        }
        for (int j = len - 1; j >= 0; j--) {
            output[j] *= right;
            right *= nums[j];
        }
        return output;
    }
}
