package blogandquestion.algorithms.nowcoder.huawei;

import java.util.*;
import java.io.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/04/09 21:55:34
 * description:
 */
public class Nine {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
//        String s = br.readLine();
//        int in = Integer.parseInt(s);
        int in = Integer.parseInt(br.readLine());
        while (in != 0) {
            int t = in % 10;
            if (set.add(t)) {
                list.add(t);
            }
            in = in / 10;
        }
        int ret = 0;
        for (int num : list) {
            ret = ret * 10 + num;
        }
        System.out.println(ret);
    }
}
