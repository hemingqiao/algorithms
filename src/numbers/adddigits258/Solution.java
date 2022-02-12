package src.adddigits258;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/03 09:50:47
 * description:
 * 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。
 *
 * 示例:
 *
 * 输入: 38
 * 输出: 2
 * 解释: 各位相加的过程为：3 + 8 = 11, 1 + 1 = 2。 由于 2 是一位数，所以返回 2。
 * 进阶:
 * 你可以不使用循环或者递归，且在 O(1) 时间复杂度内解决这个问题吗？
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-digits
 *
 * see: https://leetcode-cn.com/problems/add-digits/solution/java-o1jie-fa-de-ge-ren-li-jie-by-liveforexperienc
 *
 * x100 + y10 + z = x99 + y9 + x + y + z
 * x99 + y9一定能被9整除，x + y + z最大为27(9 * 3)，当不是9的倍数时，对9取余就可以获得最终的结果，而如果恰好为27/18/9也就是原数可以被9整除，
 * 此时就会得到错误结果0，所以可以作如下处理：
 * (x99 + y9 + x + y + z - 1) % 9 + 1
 */
public class Solution {
    public int addDigits(int num) {
        if (num < 10) {
            return num;
        }

        int result = 0;
        while (num != 0) {
            result += num % 10;
            num /= 10;
        }
        return addDigits(result);
    }


    /**
     * 借助于数学分析，利用位运算
     * @param num
     * @return
     */
    public int addDigitsOpt(int num) {
        return (num - 1) % 9 + 1;
    }

    /**
     * 对上面解法的补充
     * @param num
     * @return
     */
    public int addDigitOpt1(int num) {
        int mod = num % 9;
        return num == 0 ? 0 : mod == 0 ? 9 : mod;
        /*
        下面的解法虽然简洁，但是相对于上面的代码，多了一次相同的求模运算，导致执行时间慢了大概一倍
        return num == 0 ? 0 : num % 9 == 0 ? 9 : num % 9;
         */
    }
}
