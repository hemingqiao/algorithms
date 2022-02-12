package src.numbers.isnumber65;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/12 09:04:25
 * description:
 * 验证给定的字符串是否可以解释为十进制数字。
 *
 * 例如:
 *
 * "0"=>true
 * " 0.1 "=>true
 * "abc"=>false
 * "1 a"=>false
 * "2e10"=>true
 * " -90e3 " => true
 * " 1e"=>false
 * "e3"=>false
 * " 6e-1"=>true
 * " 99e2. "=> false
 * "53.5e93"=>true
 * " --6 "=>false
 * "-+3"=>false
 * "95a54e53"=>false
 *
 * 说明: 我们有意将问题陈述地比较模糊。在实现代码之前，你应当事先思考所有可能的情况。这里给出一份可能存在于有效十进制数字中的字符列表：
 *
 * 数字 0-9
 * 指数 - "e"
 * 正/负号 - "+"/"-"
 * 小数点 - "."
 * 当然，在输入中，这些字符的上下文也很重要。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-number
 *
 * 参考：https://leetcode-cn.com/problems/valid-number/solution/biao-qu-dong-fa-by-user8973/
 */
public class Solution {
    // 利用有限状态自动机DFA求解
    // 参考：《编译器原理》
    public int make(char c) {
        switch(c) {
            case ' ': return 0;
            case '+':
            case '-': return 1;
            case '.': return 3;
            case 'e': return 4;
            default:
                if(c >= 48 && c <= 57) return 2;
        }
        return -1;
    }

    public boolean isNumber(String s) {
        int state = 0;
        int finals = 0b101101000;
        int[][] transfer = new int[][]{{ 0, 1, 6, 2,-1},
                {-1,-1, 6, 2,-1},
                {-1,-1, 3,-1,-1},
                { 8,-1, 3,-1, 4},
                {-1, 7, 5,-1,-1},
                { 8,-1, 5,-1,-1},
                { 8,-1, 6, 3, 4},
                {-1,-1, 5,-1,-1},
                { 8,-1,-1,-1,-1}};
        char[] ss = s.toCharArray();
        for(int i=0; i < ss.length; ++i) {
            int id = make(ss[i]);
            if (id < 0) return false;
            state = transfer[state][id];
            if (state < 0) return false;
        }
        return (finals & (1 << state)) > 0;
    }
}

/**
 * 参考：https://www.cnblogs.com/grandyang/p/4084408.html
 * 参考：https://blog.csdn.net/fightforyourdream/article/details/12900751
 */
class RegExpSolution {
    // 正则效率很低
    public boolean isNumber(String s) {
        String regexp = "^[+-]?(\\d+|\\d+\\.\\d*|\\.\\d+)([eE][+-]?\\d+)?$";
        s = s.trim();
        if (s.isEmpty()) return false;
        return s.matches(regexp);
    }
}
