package blogandquestion.algorithms.greedy.inttoroman12;


/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/14 18:54:06
 * description:
 */
public class ExerciseSolution {
    public String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < romans.length; i++) {
            while (num >= values[i]) {
                ret.append(romans[i]);
                num -= values[i];
            }
        }
        return ret.toString();
    }
}
