package blogandquestion.algorithms.doublepointer.twosumtwo167;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/10/11 10:56:55
 * description: 使用和两数之和I相同的思路
 */
public class MySolution {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(numbers[i])) {
                return new int[]{map.get(numbers[i]) + 1, i + 1};
            }
            map.put(target - numbers[i], i);
        }
        return new int[2];
    }

    public static void main(String[] args) {
        int[] test = {2, 7, 11, 15};
        MySolution s = new MySolution();
        int[] res = s.twoSum(test, 9);
        System.out.println(Arrays.toString(res));
        System.out.println('z' - 0);
    }
}
