package blogandquestion.algorithms.string.compressstringlcci;



/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/23 11:01:30
 * description:
 * 字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。
 *
 * 示例1:
 *
 *  输入："aabcccccaaa"
 *  输出："a2b1c5a3"
 * 示例2:
 *
 *  输入："abbccd"
 *  输出："abbccd"
 *  解释："abbccd"压缩后为"a1b2c2d1"，比原字符串长度更长。
 * 提示：
 *
 * 字符串长度在[0, 50000]范围内。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/compress-string-lcci
 *
 */
public class Solution {
    public String compressString(String S) {
        char[] chars = S.toCharArray();
        int n = chars.length;
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int cnt = 1;
            while (i + 1 < n && chars[i] == chars[i + 1]) {
                cnt++;
                i++;
            }
            temp.append(chars[i]).append(cnt);
        }
        String t = temp.toString();
        return t.length() < n ? t : S;
    }
}
