package src.numbers.isnumber65;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/12 14:29:37
 * description:
 * 参考：https://github.com/grandyang/leetcode/issues/65
 */
public class AnotherSolution {
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) return false;
        boolean num = false, dot = false, exponential = false;
        char[] chars = s.trim().toCharArray();
        int len = chars.length;
        for (int i = 0; i < len; i++) {
            if (chars[i] >= '0' && chars[i] <= '9') {
                num = true;
            } else if (chars[i] == '.') {
                if (dot || exponential) return false;
                dot = true;
            } else if (chars[i] == 'E' || chars[i] == 'e') {
                if (exponential || !num) return false;
                exponential = true;
                num = false;
            } else if (chars[i] == '+' || chars[i] == '-') {
                if (i != 0 && chars[i - 1] != 'e' && chars[i - 1] != 'E') return false;
            } else {
                return false;
            }
        }
        return num;
    }
}

/*
先设定numSeen，dotSeen和eSeen三种boolean变量，分别代表是否出现数字、点和E
然后遍历目标字符串
1.判断是否属于数字的0~9区间
2.遇到点的时候，判断前面是否有点或者E，如果点的前面出现过点或者E都需要return false
3.遇到E的时候，判断前面数字是否合理，是否有E，并把numSeen置为false，防止E后无数字
4.遇到-+的时候，判断是否是第一个，如果不是第一个判断是否在E后面，都不满足则return false
5.其他情况都为false
最后返回numSeen的结果即可

作者：CharlesGao
链接：https://leetcode-cn.com/problems/valid-number/solution/java-luo-ji-chao-qing-xi-jie-fa-by-charlesgao/
 */
