package blogandquestion.algorithms.string.multiply43;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/25 20:33:42
 * description:
 * 还需要多谢几遍，多思考
 */
public class ExerciseSolution {
    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] record = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            int n1 = num1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; j--) {
                int n2 = num2.charAt(j) - '0';
                int temp = record[i + j + 1] + n1 * n2;
                // i + j + 1在结果中是低位，应该先处理低位，然后处理可能的进位
                record[i + j + 1] = temp % 10;
                record[i + j] += temp / 10;
            }
        }
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < m + n; i++) {
            if (ret.length() == 0 && record[i] == 0) continue;
            ret.append(record[i]);
        }
        // 处理边界情况，num1或num2可能为0
        return ret.length() == 0 ? "0" : ret.toString();
    }
}
