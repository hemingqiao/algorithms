package blogandquestion.algorithms.nowcoder.meituan;

import java.util.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/03/01 15:39:20
 * description:
 * 参考：https://www.nowcoder.com/test/28665343/summary
 */
public class Solution {
    static class Main {
        public static void main(String[] args) {
            Scanner cin = new Scanner(System.in);
            int n = cin.nextInt();
            int x = cin.nextInt();
            int y = cin.nextInt();
            int[] records = new int[n];
            for (int i = 0; i < n; i++) {
                records[i] = cin.nextInt();
            }
            System.out.println(new Main().getAns(n, x, y, records));
        }

        public int getAns(int n, int x, int y, int[] records) {
            if (x * 2 > n || y * 2 < n) return -1;
            Arrays.sort(records);
            return records[x - 1];
        }
    }

    static class Main1 {
        public static void main(String[] args) {
            Scanner cin = new Scanner(System.in);
            int n = cin.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = cin.nextInt();
            }
            System.out.println(new Main1().solution(nums));
        }

        public int solution(int[] nums) {
            int n = nums.length;
            Arrays.sort(nums);
            int ans = 0;
            for (int i = 0; i < n; i++) {
                if (nums[i] != i + 1) {
                    ans += Math.abs(i + 1 - nums[i]);
                }
            }
            return ans;
        }
    }

    static class Main2 {
        // TLE
        public static void main(String[] args) {
            Scanner cin = new Scanner(System.in);
            int T = cin.nextInt();
            for (int i = 0; i < T; i++) {
                int N = cin.nextInt();
                String n = cin.next();
                int M = cin.nextInt();
                String sex = cin.next();
                new Main2().resolve(N, n, M, sex);
            }
        }

        public void resolve(int N, String n, int M, String sex) {
            char[] chars = n.toCharArray();
            char[] sexes = sex.toCharArray();

            for (int i = 0; i < M; i++) {
                char t = sexes[i];
                if (t == 'M') {
                    boolean printed = false;
                    int zeroIdx = 0;
                    boolean flag = false;
                    for (int j = 0; j < N; j++) {
                        int num = chars[j] - '0';
                        if (num == 1) {
                            System.out.println(j + 1);
                            printed = true;
                            chars[j] = '2';
                            break;
                        } else if (num == 0 && !flag) {
                            zeroIdx = j;
                            flag = true;
                        }
                    }
                    if (!printed) {
                        System.out.println(zeroIdx + 1);
                        chars[zeroIdx] = '1';
                    }
                } else {
                    boolean printed = false;
                    int oneIdx = 0;
                    boolean flag = false;
                    for (int j = 0; j < N; j++) {
                        int num = chars[j] - '0';
                        if (num == 0) {
                            System.out.println(j + 1);
                            printed = true;
                            chars[j] = '1';
                            break;
                        } else if (num == 1 && !flag) {
                            oneIdx = j;
                            flag = true;
                        }
                    }
                    if (!printed) {
                        System.out.println(oneIdx + 1);
                        chars[oneIdx] = '2';
                    }
                }
            }
        }
    }
}
