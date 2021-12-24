package blogandquestion.algorithms.leetcodeweeklycontest.c251;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/07/25 11:06:45
 * description:
 */
public class One {
    public int getLucky(String s, int k) {
        char[] c = s.toCharArray();
        int n = c.length;
        int[] q = new int[110];
        for (int i = 0; i < n; i++) q[i] = (c[i] - 'a') + 1;
        StringBuilder res = new StringBuilder();
        while (k-- > 0) {
            StringBuilder temp = new StringBuilder();
            for (int i = 0; i < n; i++) temp.append(q[i]);
            int t = 0;
            for (int i = 0; i < temp.length(); i++) {
                int a = temp.charAt(i) - '0';
                t += a;
            }
            res = new StringBuilder().append(t);
            for (int i = 0; i < res.length(); i++) q[i] = res.charAt(i) - '0';
            n = res.length();
        }
        return Integer.valueOf(res.toString());
    }

    public static void main(String[] args) {
        One one = new One();
        int res = one.getLucky("leetcode", 2);
        System.out.println(res);
    }
}
