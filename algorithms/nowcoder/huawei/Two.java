package blogandquestion.algorithms.nowcoder.huawei;

import java.util.*;
import java.io.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/04/09 10:17:26
 * description:
 */
public class Two {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().toLowerCase();
        char tar = br.readLine().toLowerCase().charAt(0);
        int ret = 0, n = str.length() - 1;
        for (int i = 0; i <= n; i++) {
            if (str.charAt(i) == tar) ++ret;
        }
        System.out.println(ret);
    }
}
