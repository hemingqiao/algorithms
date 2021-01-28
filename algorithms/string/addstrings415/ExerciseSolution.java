package blogandquestion.algorithms.string.addstrings415;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/28 20:30:57
 * description:
 * 二刷
 */
public class ExerciseSolution {
    public String addStrings(String num1, String num2) {
        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();
        int l1 = chars1.length, l2 = chars2.length;
        int carry = 0;
        StringBuilder s = new StringBuilder();
        for (int i = l1 - 1, j = l2 - 1; i >= 0 || j >= 0 || carry != 0; i--, j--) {
            int a = i < 0 ? 0 : chars1[i] - '0';
            int b = j < 0 ? 0 : chars2[j] - '0';
            int temp = a + b + carry;
            s.append(temp % 10);
            carry = temp / 10;
        }
        s.reverse();
        return s.toString();
    }
}
