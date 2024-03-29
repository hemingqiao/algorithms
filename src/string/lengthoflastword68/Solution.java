package src.string.lengthoflastword68;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/24 14:48:10
 * description:
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。
 *
 * 如果不存在最后一个单词，请返回 0 。
 *
 * 说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。
 *
 *  
 *
 * 示例:
 *
 * 输入: "Hello World"
 * 输出: 5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/length-of-last-word
 */
public class Solution {
    public int lengthOfLastWord(String s) {
        int res = 0;
        int times = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ' && times == 0) {
                continue;
            }
            if (s.charAt(i) != ' ') {
                res++;
                times = 1;
            } else {
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int res = new Solution().lengthOfLastWord("hello world");
        System.out.println(res);
    }
}
