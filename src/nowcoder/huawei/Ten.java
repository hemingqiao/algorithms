package src.nowcoder.huawei;

import java.util.*;
import java.io.*;


/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/04/12 18:48:14
 * description:
 */
public class Ten {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        char[] chars = input.toCharArray();
        Set<Character> set = new HashSet<>();
        int n = chars.length;
        for (int i = 0; i < n; i++) set.add(chars[i]);
        System.out.println(set.size());
    }
}
