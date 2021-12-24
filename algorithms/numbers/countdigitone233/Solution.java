package blogandquestion.algorithms.numbers.countdigitone233;

import java.util.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/08/14 10:12:34
 * description:
 * @see https://www.acwing.com/video/180/
 */
public class Solution {
    public int countDigitOne(int n) {
        if (n <= 0) return 0;
        List<Integer> number = new ArrayList<>();
        while (n != 0) {
            number.add(n % 10);
            n /= 10;
        }
        int res = 0;
        for (int i = number.size() - 1; i >= 0; i--) {
            int l = 0, r = 0, t = 1;
            for (int j = number.size() - 1; j > i; j--) l = l * 10 + number.get(j);
            for (int j = i - 1; j >= 0; j--) {
                r = r * 10 + number.get(j);
                t *= 10;
            }
            res += l * t;
            if (number.get(i) == 1) res += r + 1;
            else if (number.get(i) > 1) res += t;
        }
        return res;
    }
}
