package blogandquestion.algorithms.array.threeconsecutiveodds1550;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/12/04 19:32:12
 * description:
 * 给你一个整数数组 arr，请你判断数组中是否存在连续三个元素都是奇数的情况：如果存在，请返回 true ；否则，返回 false 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：arr = [2,6,4,1]
 * 输出：false
 * 解释：不存在连续三个元素都是奇数的情况。
 * 示例 2：
 *
 * 输入：arr = [1,2,34,3,4,5,7,23,12]
 * 输出：true
 * 解释：存在连续三个元素都是奇数的情况，即 [5,7,23] 。
 *  
 *
 * 提示：
 *
 * 1 <= arr.length <= 1000
 * 1 <= arr[i] <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/three-consecutive-odds
 *
 */
public class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int right = 2, mid = 1, left = 0;
        int len = arr.length;
        while (right < len) {
            if ((arr[left] & 1) == 1 && (arr[mid] & 1) == 1 && (arr[right] & 1) == 1) {
                return true;
            }
            right++;
            mid++;
            left++;
        }
        return false;
    }
}


/**
 * 参考：https://leetcode-cn.com/problems/three-consecutive-odds/solution/cun-zai-lian-xu-san-ge-qi-shu-de-shu-zu-by-leetcod/583970
 */
class AnotherSolution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int num = 0;
        for (int i : arr) {
            if (num == 3) return true;
            num = (i & 1) == 1 ? num + 1 : 0;
        }
        return num == 3;
    }

    public static void main(String[] args) {
        AnotherSolution as = new AnotherSolution();
        int[] test = {1,1,1};
        boolean res = as.threeConsecutiveOdds(test);
        System.out.println(res);
    }
}
