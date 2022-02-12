package src.binary.covertotitle168;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/06/29 22:05:33
 * description:
 */
public class ExerciseSolution {
    public String convertToTitle(int n) {
        StringBuilder s = new StringBuilder();
        while (n != 0) {
            --n;
            s.insert(0, (char) ('A' + n % 26));
            n /= 26;
        }
        return s.toString();
    }
}
