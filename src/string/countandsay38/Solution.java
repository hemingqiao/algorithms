package src.string.countandsay38;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/12/04 13:12:42
 * description:
 * 给定一个正整数 n ，输出外观数列的第 n 项。
 *
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。
 *
 * 你可以将其视作是由递归公式定义的数字字符串序列：
 *
 * countAndSay(1) = "1"
 * countAndSay(n) 是对 countAndSay(n-1) 的描述，然后转换成另一个数字字符串。
 * 前五项如下：
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 第一项是数字 1
 * 描述前一项，这个数是 1 即 “ 一 个 1 ”，记作 "11"
 * 描述前一项，这个数是 11 即 “ 二 个 1 ” ，记作 "21"
 * 描述前一项，这个数是 21 即 “ 一 个 2 + 一 个 1 ” ，记作 "1211"
 * 描述前一项，这个数是 1211 即 “ 一 个 1 + 一 个 2 + 二 个 1 ” ，记作 "111221"
 * 要 描述 一个数字字符串，首先要将字符串分割为 最小 数量的组，每个组都由连续的最多 相同字符 组成。然后对于每个组，先描述字符的数量，然后描述字符，形成一个描述组。要将描述转换为数字字符串，先将每组中的字符数量用数字替换，再将所有描述组连接起来。
 *
 * 示例 1：
 *
 * 输入：n = 1
 * 输出："1"
 * 解释：这是一个基本样例。
 * 示例 2：
 *
 * 输入：n = 4
 * 输出："1211"
 * 解释：
 * countAndSay(1) = "1"
 * countAndSay(2) = 读 "1" = 一 个 1 = "11"
 * countAndSay(3) = 读 "11" = 二 个 1 = "21"
 * countAndSay(4) = 读 "21" = 一 个 2 + 一 个 1 = "12" + "11" = "1211"
 *
 * 提示：
 *
 * 1 <= n <= 30
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-and-say
 *
 * 参考：https://github.com/grandyang/leetcode/issues/38
 */
public class Solution {
    public String countAndSay(int n) {
        // 题目限定了1 <= n <= 30，不判断也可
        if (n <= 0) return "";
        String res = "1";
        // 因为已经给res赋值了"1"，相当于已经执行了一次
        // 所以剩下的执行次数是n - 1次，判断条件为--n
        while (--n > 0) {
            StringBuilder cur = new StringBuilder();
            int size = res.length();
            for (int i = 0; i < size; i++) {
                int cnt = 1;
                while (i + 1 < size && res.charAt(i) == res.charAt(i + 1)) {
                    cnt++;
                    i++;
                }
                cur.append(cnt).append(res.charAt(i));
            }
            res = cur.toString();
        }
        return res;
    }
}

/**
 * 参考：https://leetcode-cn.com/problems/count-and-say/solution/1-ms-zai-suo-you-java-ti-jiao-zhong-ji-bai-liao-97/
 */
class AnotherSolution {
    public String countAndSay(int n) {
        // 递归终止条件
        if (n == 1) return "1";
        StringBuilder res = new StringBuilder();
        // 使用递归拿到上一层的字符串
        String str = countAndSay(n - 1);
        int length = str.length();
        // 开始时指针为0
        int start = 0;
        // 从1开始
        for (int i = 1; i < length + 1; i++) {
            if (i == length) {
                // 如果是字符串的最后一位直接拼接
                res.append(i - start).append(str.charAt(start));
            } else if (str.charAt(i) != str.charAt(start)) {
                // 当start处的字符和i处的字符不同时，拼接并更新start
                res.append(i - start).append(str.charAt(start));
                start = i;
            }
        }
        return res.toString();
    }
}
