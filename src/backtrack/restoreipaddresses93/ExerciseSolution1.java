package src.backtrack.restoreipaddresses93;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/02/22 21:19:44
 * description:
 *
 */
public class ExerciseSolution1 {
    public List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<>();
        help(list, 0, s, "");
        return list;
    }

    public void help(List<String> list, int segmentNum, String source, String ret) {
        if (segmentNum == 4) {
            if (source.length() == 0) list.add(ret);
            return;
        }
        for (int k = 1; k < 4; k++) {
            if (source.length() < k) break;
            int val = Integer.parseInt(source.substring(0, k));
            // 如果分割出来的段大于255或者有前导0，则当前的k不可用
            if (val > 255 || String.valueOf(val).length() != k) continue;
            // 当前段合法，则进行递归调用，分割剩下的字符串
            StringBuilder t = new StringBuilder();
            String temp = t.append(ret).append(source.substring(0, k)).append(segmentNum == 3 ? "" : ".").toString();
            help(list, segmentNum + 1, source.substring(k), temp);
        }
    }
}
