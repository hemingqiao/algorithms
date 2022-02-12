package src.leetcodeweeklycontest.c222;

import java.util.*;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2021/01/03 10:41:06
 * description:
 * 大餐 是指 恰好包含两道不同餐品 的一餐，其美味程度之和等于 2 的幂。
 *
 * 你可以搭配 任意 两道餐品做一顿大餐。
 *
 * 给你一个整数数组 deliciousness ，其中 deliciousness[i] 是第 i 道餐品的美味程度，返回你可以用数组中的餐品做出的不同 大餐 的数量。结果需要对 10^9 + 7 取余。
 *
 * 注意，只要餐品下标不同，就可以认为是不同的餐品，即便它们的美味程度相同。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：deliciousness = [1,3,5,7,9]
 * 输出：4
 * 解释：大餐的美味程度组合为 (1,3) 、(1,7) 、(3,5) 和 (7,9) 。
 * 它们各自的美味程度之和分别为 4 、8 、8 和 16 ，都是 2 的幂。
 * 示例 2：
 *
 * 输入：deliciousness = [1,1,1,3,3,3,7]
 * 输出：15
 * 解释：大餐的美味程度组合为 3 种 (1,1) ，9 种 (1,3) ，和 3 种 (1,7) 。
 *  
 *
 * 提示：
 *
 * 1 <= deliciousness.length <= 105
 * 0 <= deliciousness[i] <= 220
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-good-meals
 *
 */
public class Two {
//    public int countPairs(int[] deliciousness) {
//        int cnt = 0;
//        for (int i = 0; i < deliciousness.length; i++) {
//            for (int j = i + 1; j < deliciousness.length; j++) {
//                int temp = deliciousness[i] + deliciousness[j];
//                if (temp == 0) continue;
//                if ((temp & (temp - 1)) == 0) {
//                    cnt++;
//                }
//            }
//        }
//        return (int) (cnt % (1e9 + 7));
//    }

//    public int countPairs(int[] deliciousness) {
//        Set<Integer> set = new HashSet<>();
//        int[] temp = new int[]{8192, 512, 64, 128, 256, 1024, 2048, 4096, 16384, 32768, 4194304, 8388608, 16777216, 33554432, 67108864, 134217728, 268435456, 536870912, 1073741824, 2147483647, 1, 65536, 2, 131072, 4, 262144, 8, 524288, 16, 1048576, 32, 2097152};
//        for (int i : temp) {
//            set.add(i);
//        }
//        int cnt = 0;
//        for (int i = 0; i < deliciousness.length; i++) {
//            for (int j = i + 1; j < deliciousness.length; j++) {
//                if (set.contains(deliciousness[i] + deliciousness[j])) {
//                    cnt++;
//                }
//            }
//        }
//        return (int) (cnt % (1e9 + 7));
//    }

//    public int countPairs(int[] deliciousness) {
//        Map<Integer, Boolean> map = new HashMap<>();
//        int cnt = 0;
//        for (int i = 0; i < deliciousness.length; i++) {
//            for (int j = i + 1; j < deliciousness.length; j++) {
//                int temp = deliciousness[i] + deliciousness[j];
//                if (temp == 0) continue;
//                if (map.get(temp) != null) {
//                    cnt++;
//                } else {
//                    if ((temp & (temp - 1)) == 0) {
//                        cnt++;
//                        map.put(temp, true);
//                    }
//                }
//            }
//        }
//        return (int) (cnt % (1e9 + 7));
//    }


    // 参考：https://leetcode-cn.com/problems/count-good-meals/solution/java-jie-fa-by-nechadil-ywc4/
    /*
    public int countPairs(int[] deliciousness) {
        Map<Integer, Integer> map = new HashMap<>();
        int cnt = 0;
        int limit = (int)Math.pow(2, 22);
        int mod = (int)(1e9 + 7);
        map.put(deliciousness[0], 1);
        for (int i = 1; i < deliciousness.length; i++) {
            for (int j = 1; j < limit; j *= 2) {
                if (map.containsKey(j - deliciousness[i])) {
                    cnt = (cnt + map.get(j - deliciousness[i])) % mod;
                }
            }
            map.put(deliciousness[i], map.getOrDefault(deliciousness[i], 0) + 1);
        }
        return cnt;
    }
    */

    public int countPairs(int[] deliciousness) {
        Map<Integer, Integer> map = new HashMap<>();
        long cnt = 0; // cnt可能会超过整型的范围，使用长整型
        int limit = (int)Math.pow(2, 22);
        map.put(deliciousness[0], 1);
        for (int i = 1; i < deliciousness.length; i++) {
            for (int j = 1; j < limit; j *= 2) {
                if (map.containsKey(j - deliciousness[i])) {
                    cnt += map.get(j - deliciousness[i]);
                }
            }
            map.put(deliciousness[i], map.getOrDefault(deliciousness[i], 0) + 1);
        }
        return (int) (cnt % (1e9 + 7));
    }

    public static void main(String[] args) {
        int[] test = new int[]{2,14,11,5,1744,2352,0,1,1300,2796,0,4,376,1672,73,55,2006,42,10,6,0,2,2,0,0,1,0,1,0,2,271,241,1,63,1117,931,3,5,378,646,2,0,2,0,15,1};
//        int[] test = new int[]{1,3,5,7,9};
        Two t = new Two();
        int res = t.countPairs(test);
        System.out.println(res);
    }
}

/**
 * 参考：https://leetcode-cn.com/problems/count-good-meals/solution/c-ha-xi-by-francissoft-r3nj/
 */
class AnotherSolution {
    public int countPairs(int[] deliciousness) {
        Map<Integer, Integer> map = new HashMap<>();
        long cnt = 0;
        for (int i = 0; i < deliciousness.length; i++) {
            for (int j = 0; j <= 21; j++) {
                int key = (1 << j) - deliciousness[i]; // 注意这里是1左移j位，即 1 * (2 ^ j)
                if (map.containsKey(key)) {
                    cnt += map.get(key);
                }
            }
            map.put(deliciousness[i], map.getOrDefault(deliciousness[i], 0) + 1);
        }
        return (int) (cnt % (1e9 + 7));
    }
}
