package blogandquestion.algorithms.leetcodeweeklycontest.c221;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/12/27 10:28:13
 * description:
 */
public class Solution {
    public boolean halvesAreAlike(String s) {
        s = s.toLowerCase();
        int len = s.length();
        String left = s.substring(0, len / 2);
        String right = s.substring(len / 2);
        return getVowelNum(left) == getVowelNum(right);
    }

    private int getVowelNum(String s) {
        char[] chars = s.toCharArray();
        int cnt = 0;
        for (char c : chars) {
            switch (c) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    cnt++;
                default:
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String test = "teEtbook";
        boolean res = s.halvesAreAlike(test);
        System.out.println(res);
    }
}
