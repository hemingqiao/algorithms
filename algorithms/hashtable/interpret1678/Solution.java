package blogandquestion.algorithms.hashtable.interpret1678;


/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/12/13 09:55:31
 * description:
 * 请你设计一个可以解释字符串 command 的 Goal 解析器 。command 由 "G"、"()" 和/或 "(al)" 按某种顺序组成。Goal 解析器会将 "G" 解释为
 * 字符串 "G"、"()" 解释为字符串 "o" ，"(al)" 解释为字符串 "al" 。然后，按原顺序将经解释得到的字符串连接成一个字符串。
 *
 * 给你字符串 command ，返回 Goal 解析器 对 command 的解释结果。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：command = "G()(al)"
 * 输出："Goal"
 * 解释：Goal 解析器解释命令的步骤如下所示：
 * G -> G
 * () -> o
 * (al) -> al
 * 最后连接得到的结果是 "Goal"
 * 示例 2：
 *
 * 输入：command = "G()()()()(al)"
 * 输出："Gooooal"
 * 示例 3：
 *
 * 输入：command = "(al)G(al)()()G"
 * 输出："alGalooG"
 *  
 *
 * 提示：
 *
 * 1 <= command.length <= 100
 * command 由 "G"、"()" 和/或 "(al)" 按某种顺序组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/goal-parser-interpretation
 *
 */
public class Solution {
    public String interpret(String command) {
        StringBuilder ans = new StringBuilder();
        char[] chars = command.toCharArray();
        int len = chars.length;
        for (int i = 0; i < len; i++) {
            if (chars[i] == 'G') {
                ans.append('G');
            } else if (chars[i] == '(') {
                if (i + 1 < len && chars[i + 1] != ')') {
                    ans.append("al");
                    i += 3; // for循环处i执行了自加，所以此处加上3即可
                } else {
                    ans.append("o");
                    i += 1;
                }
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String res = s.interpret("(al)G(al)()()G");
        System.out.println(res);
    }
}
