package blogandquestion.algorithms;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/07 08:32:55
 * description:
 */
public class TrailingZeroes {
    public int trailingZeroes(int n) {
        int res = 0;
        for (int i = 1; i <= n; i++) {
            int j = i;
            /*while (j != 0) {
                if (j % 5 == 0) {
                    res++;
                }
                j /= 5;
            }*/
            while (j % 5 == 0) { // 0 % 5 == 0
                res++;
                j /= 5;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        TrailingZeroes tz = new TrailingZeroes();
        int result = tz.trailingZeroes(25);
        System.out.println(result);
    }
}
