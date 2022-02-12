package src.string.tolowercase709;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/05/23 15:08:43
 * description:
 * 给你一个字符串 s ，将该字符串中的大写字母转换成相同的小写字母，返回新的字符串。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "Hello"
 * 输出："hello"
 * 示例 2：
 *
 * 输入：s = "here"
 * 输出："here"
 * 示例 3：
 *
 * 输入：s = "LOVELY"
 * 输出："lovely"
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 100
 * s 由 ASCII 字符集中的可打印字符组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/to-lower-case
 * 
 */
public class Solution {
    // 参考：https://leetcode-cn.com/problems/to-lower-case/solution/ming-ming-zhi-you-26ge-zi-mu-wei-shi-yao-d2ec/
    public String toLowerCase(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        for (int i = 0; i < n; i++) {
            chars[i] = chars[i] |= 32;
        }
        return new String(chars);
    }

    // 参考：https://leetcode-cn.com/problems/to-lower-case/solution/chao-guo-100-java-charlei-xing-de-yun-su-u7n8/
    public String toLowerCase1(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        for (int i = 0; i < n; i++) {
            if (chars[i] >= 'A' && chars[i] <= 'Z') chars[i] += 32;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        String ret = "hello world";
        String lower = ret.toLowerCase();
        System.out.println(ret == lower);
    }
}
