package blogandquestion.algorithms.array.detectcapitaluse520;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/01 11:06:35
 * description:
 * 规定了三种正确方式，要么都是大写或小写，要么首字母大写，其他情况都不正确。那么要做的就是统计出单词中所有大写字母的个数cnt，再来判断是否属于
 * 这三种情况，如果cnt为0，说明都是小写，正确；如果cnt和单词长度相等，说明都是大写，正确；如果cnt为1，且首字母为大写，正确，其他情况均返回false
 * 参考：https://github.com/grandyang/leetcode/issues/520
 */
public class AnotherSolution {
    // 这个就写的很漂亮了
    public boolean detectCapitalUse(String word) {
        int count = 0;
        char[] chars = word.toCharArray();
        int n = chars.length;
        for (char c : chars) {
            if (c <= 'Z') count++;
        }
        return count == 0 || count == n || count == 1 && chars[0] <= 'Z';
    }
}
