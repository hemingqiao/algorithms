package src.string.translatenumlcof;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/03/01 08:34:47
 * description:
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 *  
 *
 * 提示：
 *
 * 0 <= num < 231
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof
 *
 */
public class Solution {
    /*
    字符串的第 i 位置：
        可以单独作为一位来翻译
        如果第 i - 1 位和第 i 位组成的数字在 10 到 25 之间，可以把这两位连起来翻译

    到这里，我们发现它和「198. 打家劫舍」非常相似。我们可以用 f(i) 表示以第 i 位结尾的前缀串翻译的方案数，考虑第 i 位单独翻译和与前一位连接起来
    再翻译对 f(i) 的贡献。单独翻译对 f(i) 的贡献为 f(i - 1)；如果第 i - 1 位存在，并且第 i - 1 位和第 i 位形成的数字 x 满足 10 <= x <= 25
    ，那么就可以把第 i - 1 位和第 i 位连起来一起翻译，对 f(i) 的贡献为 f(i - 2)，否则为 0。
    由此就可以列出状态转移方程

    参考：https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/solution/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-by-leetcode-sol/
     */

    // 参考：https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/solution/di-gui-qiu-jie-shuang-bai-by-xiang-shang-de-gua-ni/
    public int translateNum(int num) {
        // 递归的出口是num是一个小于10的数，此时只有一种翻译方法
        if (num < 10) return 1;
        int rest = num % 100;
        if (rest >  25 || rest < 10) return translateNum(num / 10);
        return translateNum(num / 10) + translateNum(num / 100);
    }


    // dfs解法
    // 参考：https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/solution/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-by-leetcode-sol/435356
    public int translateNum1(int num) {
        String str = String.valueOf(num);
        return dfs(str, 0);
    }

    public int dfs(String source, int index) {
        if (index >= source.length() - 1) return 1;
        // 先求解每一次都翻译一个字符的方案
        int res = dfs(source, index + 1);
        String temp = source.substring(index, index + 2);
        if (temp.compareTo("10") >= 0 && temp.compareTo("25") <= 0) {
            res += dfs(source, index + 2);
        }
        return res;
    }
}
