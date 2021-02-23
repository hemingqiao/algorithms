package blogandquestion.algorithms.string.compressstringlcci;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/02/23 21:03:21
 * description:
 * 二刷
 */
public class ExerciseSolution {
    public String compressString(String S) {
        char[] chars = S.toCharArray();
        int n = chars.length;
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < n) {
            sb.append(chars[i]);
            int cnt = 1;
            while (i < n - 1 && chars[i] == chars[i + 1]) {
                cnt++;
                i++;
            }
            sb.append(cnt);
            i++;
        }
        if (sb.length() < n) {
            return sb.toString();
        }
        return S;
    }
}
