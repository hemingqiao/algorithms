package src.numbers.singlenumber136;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/02 22:40:54
 * description: 利用异或运算。
 * 1、任何数和 0 做异或运算，结果仍然是原来的数
 * 2、任何数和自身做异或运算，结果为0
 *
 * 解题思路
 * see: https://leetcode-cn.com/problems/single-number/solution/zhi-chu-xian-yi-ci-de-shu-zi-by-leetcode-solution/
 */
public class AnotherSolution {
    public int singleNumber(int[] nums) {
        int single = 0;
        for (int num: nums) {
            single ^= num;
        }
        return single;
    }
}
