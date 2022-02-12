package src.array.getrow119;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/02/12 08:35:40
 * description:
 */
public class ExerciseSolution {
    // 没有优化空间
    public List<Integer> getRow(int r) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        if (r == 0) return list;
        list.add(1);
        if (r == 1) return list;
        for (int i = 2; i <= r; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    temp.add(1);
                }
            }
            list = temp;
        }
        return list;
    }
}
