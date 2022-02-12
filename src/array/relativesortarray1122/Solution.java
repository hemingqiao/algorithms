package src.array.relativesortarray1122;

/**
 * @author Heming
 * created by IntelliJ IDEA
 * founded at 2020/11/25 13:09:25
 * description:
 * 给你两个数组，arr1 和 arr2，
 *
 * arr2 中的元素各不相同
 * arr2 中的每个元素都出现在 arr1 中
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 *
 *  
 *
 * 示例：
 *
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 *  
 *
 * 提示：
 *
 * 1 <= arr1.length, arr2.length <= 1000
 * 0 <= arr1[i], arr2[i] <= 1000
 * arr2 中的元素 arr2[i] 各不相同
 * arr2 中的每个元素 arr2[i] 都出现在 arr1 中
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/relative-sort-array
 *
 * 参考：https://leetcode-cn.com/problems/relative-sort-array/solution/ji-shu-pai-xu-san-ge-forxun-huan-gao-ding-0msjavac/
 */
public class Solution {
    // 计数排序
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] temp = new int[1001]; // 题目限定两个数组的最大长度不超过1000
        int len = arr1.length;
        for (int i : arr1) {
            temp[i]++;
        }
        int pos = 0;
        for (int j : arr2) {
            // j在arr1中存在对应的值，将对应值在arr1中出现的次数取出，并赋值
            while (temp[j] > 0) {
                arr1[pos++] = j;
                temp[j]--;
            }
        }
        // 遍历完arr2之后，将arr1中剩余的元素依次放到尾部（因为是从小到大遍历的，所以是有序的）
        for (int i = 0; i < 1001; i++) {
            while (temp[i] > 0) {
                arr1[pos++] = i;
                temp[i]--;
            }
        }
        return arr1;
    }
}
