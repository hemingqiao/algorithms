package src.nowcoder.huawei;

import java.util.*;
import java.io.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/04/09 20:50:37
 * description:
 */
public class Eight {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        Set<Integer> record = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        while (n-- > 0) {
            String[] in = br.readLine().split(" ");
            int first = Integer.parseInt(in[0]), second = Integer.parseInt(in[1]);
            if (map.containsKey(first)) {
                map.put(first, map.get(first) + second);
            } else {
                map.put(first, second);
            }
            if (record.add(first)) {
                list.add(first);
            }
        }
        Collections.sort(list);
        for (int i : list) {
            System.out.println(i + " " + map.get(i));
        }
    }
}
