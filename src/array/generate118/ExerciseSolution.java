package src.array.generate118;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/02/07 19:49:18
 * description:
 */
public class ExerciseSolution {
    // 这代码写的很丑
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> t1 = new ArrayList<>(){{
            add(1);
        }};
        list.add(t1);
        if (n == 1) return list;
        List<Integer> t2 = new ArrayList<>(){{
            add(1);
            add(1);
        }};
        list.add(t2);
        if (n == 2) return list;
        for (int i = 3; i <= n; i++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            List<Integer> pre = list.get(i - 1);
            for (int j = 0; j < pre.size() - 1; j++) {
                temp.add(pre.get(j) + pre.get(j + 1));
            }
            temp.add(1);
            list.add(temp);
        }
        return list;
    }

    // 这种写法优雅一些
    public List<List<Integer>> generate1(int n) {
        List<List<Integer>> list = new ArrayList<>();
        if (n == 0) return list;
        List<Integer> first = new ArrayList<>();
        first.add(1);
        list.add(first);
        for (int i = 1; i < n; i++) {
            List<Integer> t = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    t.add(1);
                } else {
                    t.add(list.get(i - 1).get(j - 1) + list.get(i - 1).get(j));
                }
            }
            list.add(t);
        }
        return list;
    }
}
