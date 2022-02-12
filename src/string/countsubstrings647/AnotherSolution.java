package src.string.countsubstrings647;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/31 14:35:33
 * description:
 * 参考：https://github.com/grandyang/leetcode/issues/647
 */
public class AnotherSolution {
    // 以字符串中的每一个字符都当作回文串中间的位置，然后向两边扩散，每当成功匹配两个左右两个字符，结果 res 自增1，然后再比较下一对。需要注意
    // 回文字符串有奇数和偶数两种形式，如果是奇数长度，那么i位置就是中间那个字符的位置，所以左右两遍都从i开始遍历；如果是偶数长度的，那么i是
    // 最中间两个字符的左边那个，右边那个就是 i+1
    int res = 0;
    public int countSubstrings(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        for (int i = 0; i < n; i++) {
            help(chars, i, i);
            help(chars, i, i + 1);
        }
        return res;
    }

    public void help(char[] chars, int l, int r) {
        while (l >= 0 && r < chars.length && chars[l] == chars[r]) {
            res++;
            l--;
            r++;
        }
    }
}
