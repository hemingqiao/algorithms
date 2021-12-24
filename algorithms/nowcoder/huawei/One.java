package blogandquestion.algorithms.nowcoder.huawei;

import java.util.*;
import java.io.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/04/09 19:29:37
 * description:
 */
public class One {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String in = br.readLine();
        int n = in.length() - 1, ret = 0;
        while (n >= 0 && in.charAt(n) != ' ') {
            ++ret;
            --n;
        }
        System.out.println(ret);
    }
}
