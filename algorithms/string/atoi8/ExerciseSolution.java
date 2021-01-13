package blogandquestion.algorithms.string.atoi8;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/13 18:29:18
 * description:
 * 参考：https://github.com/grandyang/leetcode/issues/8
 */
public class ExerciseSolution {
    public int myAtoi(String s) {
        if (s == null || s.length() == 0) return 0;
        int len = s.length();
        int index = 0;
        while (index < len && s.charAt(index) == ' ') {
            index++;
        }
        if (index == len) return 0;
        boolean isPositive = true;
        if (!Character.isDigit(s.charAt(index))) {
            if (s.charAt(index) != '+' && s.charAt(index) != '-') {
                return 0;
            }
            isPositive = s.charAt(index++) != '-';
        }
        int ret = 0;
        while (index < len && Character.isDigit(s.charAt(index))) {
            // Integer.MAX_VALUE = 2147483647
            // 如果ret == Integer.MAX_VALUE / 10 == 214748364时，下一位比7大，则意味着会超出范围
            // 此时根据正负与否返回整型最大值或者整型最小值
            if (ret > Integer.MAX_VALUE / 10 || ret == Integer.MAX_VALUE / 10 && (s.charAt(index) - '0' > 7)) {
                return isPositive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            ret = ret * 10 + (s.charAt(index++) - '0');
        }
        return isPositive ? ret : -ret;
    }

    public static void main(String[] args) {
        String test = "-2147483648";
        ExerciseSolution es = new ExerciseSolution();
        int res = es.myAtoi(test);
        System.out.println(res);
        System.out.println(res / 10);
    }
}
