package blogandquestion.algorithms.array.productexceptself238;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/26 22:04:31
 * description:
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
