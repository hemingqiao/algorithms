package src.leetcodeweeklycontest.c234;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/03/28 13:06:08
 * description:
 * 给你一个字符串 word ，该字符串由数字和小写英文字母组成。
 *
 * 请你用空格替换每个不是数字的字符。例如，"a123bc34d8ef34" 将会变成 " 123  34 8  34" 。注意，剩下的这些整数间至少要用一个空格隔开："123"、"34"、"8" 和 "34" 。
 *
 * 返回对 word 完成替换后形成的 不同 整数的数目。
 *
 * 如果两个整数的 不含前导零 的十进制表示不同，则认为这两个整数也不同。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：word = "a123bc34d8ef34"
 * 输出：3
 * 解释：不同的整数有 "123"、"34" 和 "8" 。注意，"34" 只计数一次。
 * 示例 2：
 *
 * 输入：word = "leet1234code234"
 * 输出：2
 * 示例 3：
 *
 * 输入：word = "a1b01c001"
 * 输出：1
 * 解释："1"、"01" 和 "001" 视为同一个整数的十进制表示，因为在比较十进制值时会忽略前导零的存在。
 *  
 *
 * 提示：
 *
 * 1 <= word.length <= 1000
 * word 由数字和小写英文字母组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-different-integers-in-a-string
 *
 */
public class One {
    public int numDifferentIntegers(String word) {
        char[] chars = word.toCharArray();
        int n = chars.length;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            char t = chars[i];
            if (t >= '0' && t <= '9') {
                int j = i;
                while (j < n && chars[j] == '0') {
                    j++;
                    i++;
                }
                StringBuilder sb = new StringBuilder();
                while (j < n && chars[j] >= '0' && chars[j] <= '9') {
                    sb.append(chars[j]);
                    j++;
                    i++;
                }
                --i;
                if (sb.length() == 0) set.add("0");
                else set.add(sb.toString());
            }
        }
        return set.size();
    }
}
