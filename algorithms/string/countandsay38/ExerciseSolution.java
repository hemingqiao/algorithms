package blogandquestion.algorithms.string.countandsay38;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/23 10:50:34
 * description:
 * 还需要多写几遍（这题很新奇）
 */
public class ExerciseSolution {
    // 迭代解法
    public String countAndSay(int n) {
        String res = "1";
        while (--n > 0) {
            StringBuilder cur = new StringBuilder();
            int size = res.length();
            for (int i = 0; i < size; i++) {
                int cnt = 1;
                while (i + 1 < size && res.charAt(i) == res.charAt(i + 1)) {
                    cnt++;
                    i++;
                }
                cur.append(cnt).append(res.charAt(i));
            }
            res = cur.toString();
        }
        return res;
    }

    // 递归解法，很巧妙
    public String countAndSay1(int n) {
        if (n == 1) return "1"; // base case
        StringBuilder s = new StringBuilder();
        String str = countAndSay1(n - 1); // 取到上一个排列
        int l = str.length();
        int start = 0;
        for (int i = 1; i < l + 1; i++) {
            if (i == l) {
                s.append(i - start).append(str.charAt(start));
            } else if (str.charAt(i) != str.charAt(i - 1)) {
                s.append(i - start).append(str.charAt(start));
                start = i;
            }
        }
        return s.toString();
    }

    public static void main(String[] args) {
        ExerciseSolution es = new ExerciseSolution();
        int test = 4;
        String res = es.countAndSay1(test);
        System.out.println(res);
    }
}
