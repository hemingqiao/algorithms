package blogandquestion.algorithms.nowcoder.huawei;

import java.util.*;
import java.io.*;


/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/04/09 10:34:36
 * description:
 */
public class Three {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num;
        while (!"".equals(num = br.readLine()))  {
            if (num == null) return;
            int n = Integer.parseInt(num);
            Set<Integer> set = new HashSet<>();
            while (n-- > 0) {
                int temp = Integer.parseInt(br.readLine());
                set.add(temp);
            }
            int[] nums = new int[set.size()];
            int p = 0;
            for (int nn : set) nums[p++] = nn;
            Arrays.sort(nums);
            for (int number : nums) {
                System.out.println(number);
            }
        }
    }
}
